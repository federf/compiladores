package ir.ast;

import ir.ASTVisitor;
import java.util.*;

public class VarLocation extends Location {

    Type type;
    int size;
    int offset;

    //lista de VarLocation declaradas
    static LinkedList<VarLocation> vars=new LinkedList();
    
    static int off = -4;

    public static void resetOffset(){
        off = -4;
    }

    public VarLocation(String id, Type type, Expression expr, int size) {
        //si la expression es null, entonces es una declaracion de variable
        //caso contrario, indicaria que estamos frente a un acceso de variable de tipo arreglo

        //si no es una declaracion de un label
        if(!id.contains("Label")){
            if(expr==null){
                //si es un arreglo
                if(type.isArray()){
                    //al ser la declaracion de un arreglo, su tamaño debe ser mayor a cero
                    if(size>0){
                        this.id=id;
                        this.type = type;
                        this.expr = expr;
                        this.size = size;
                        this.offset = off;
                        //para el tamaño del arreglo
                        off = off - (size*4) ;
                        //cambiamos el offset para el proximo
                        off = off - 4;    
                    }else{
                        System.out.println("ERROR: el tamaño de un arreglo debe ser MAYOR A CERO");
                    }
                }else{
                    this.id=id;
                    this.type = type;
                    this.expr = expr;
                    this.size = size;
                    this.offset = off;
                    //cambiamos el offset para el proximo
                    off = off - 4;    
                }
                //al tratarse de una declaracion, la guardamos en la lista
                vars.addLast(this);
            }else{
                //al tratarse de un acceso, es a un arreglo, buscamos el arreglo para conocer su offset
                VarLocation actual=search(id);
                //si se encontro la varlocation correspondiente
                if(actual!=null){
                    //verificamos que se trate de un arreglo
                    if(actual.getType().isArray()){
                        //evaluamos el indice ingresado
                        int index=evaluateExpression(expr.toString());
                        //si el indice es valido para el arreglo 
                        if((index<actual.size) && (index>=0)){
                            this.id=id;
                            this.type = type;
                            this.expr = expr;
                            this.size = size;
                            this.offset = actual.getOffset()-(4*(actual.size-index));
                            //cambiamos el offset para el proximo
                            off = off - 4;  
                        }else{
                            System.out.println("ERROR: Indice Invalido.");
                        }
                    }else{
                        System.out.println("ERROR: VarLocation "+id+" no es un arreglo.");
                    }
                }else{//sino, mostramos un mensaje de error
                    System.out.println("ERROR: VarLocation "+id+" no definida.");
                }
            }
        }else{

            //si es una declaracion de un label
            this.id=id;
            this.type = type;
            this.expr = expr;
            this.size = size;
            this.offset = off;
            //cambiamos el offset para el proximo
            off = off - 4; 
        }
        
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    public Type getType(){
        return this.type;
    }

    public void setType(Type t){
        this.type=t;
    }

    public int getOffset(){
        //si es una variable normal
        if(this.size==0){
            return this.offset;
        }else{//sino, debe ser un arreglo
        //retornamos el offset de su "ultima posicion", ya que se almacenan de atras hacia adelante
            return this.offset-(this.size*4);
        }
    }
    @Override
    public String toString() {
        return "VarLocation{" +"name="+ id +", type=" + type + ", expr=" + expr + ", size=" + size + '}';
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }

    //metodo que dado el nombre de una varlocation busca su declaracion
    private VarLocation search(String id){
        System.out.println("buscado: "+id);
        for(VarLocation v : vars){
            System.out.println("actual "+v);
            //si el id es el mismo y es una definicion
            if(v.getId().equals(id) && v.getExpr()==null){
                return v;
            }
        }
        return null;
    }

    //Metodo que dada una expression aritmetica (String) devuelve su resultado en forma de un Int
    public int evaluateExpression(String expr){ 
        //creamos los stacks para operandos y operadores
        Stack<Integer> op  = new Stack<Integer>();
        Stack<Double> val = new Stack<Double>();
        //creamos stacks temporales para operandos y operadores
        Stack<Integer> optmp  = new Stack<Integer>();
        Stack<Double> valtmp = new Stack<Double>();
        //obtenemos la expression
        String input = expr;
        input = "0" + input;
        input=input.trim();
        input = input.replaceAll("-","+-");
        //guardamos operandos y operadores en sus respectivas stacks
        String temp = "";
        for (int i = 0;i < input.length();i++)
        {
            char ch = input.charAt(i);
            if (ch == '-')
                temp = "-" + temp;
            else if (ch != '+' &&  ch != '*' && ch != '/')
               temp = temp + ch;
            else
            {
                val.push(Double.parseDouble(temp));
                op.push((int)ch);
                temp = "";
            }
        }
        val.push(Double.parseDouble(temp));
        //creamos un arreglo de operandos por presedencia
        /* -ve sign is already taken care of while storing */
        char operators[] = {'/','*','+'};
        /* Evaluacion de la expression */
        for (int i = 0; i < 3; i++)
        {
            boolean it = false;
            while (!op.isEmpty())
            {
                int optr = op.pop();
                double v1 = val.pop();
                double v2 = val.pop();
                if (optr == operators[i])
                {
                    /*si el operador concuerda lo evaluamos y almacenamos*/
                    if (i == 0)
                    {
                        valtmp.push(v2 / v1);
                        it = true;
                        break;
                    }
                    else if (i == 1)
                    {
                        valtmp.push(v2 * v1);
                        it = true;
                        break;
                    }
                    else if (i == 2)
                    {
                        valtmp.push(v2 + v1);
                        it = true;
                        break;
                    }                                        
                }
                else
                {
                    valtmp.push(v1);
                    val.push(v2);
                    optmp.push(optr);
                }                
            }    
            /* trasladamos todo elemento de los stacks temporales a los stacks originales */            
            while (!valtmp.isEmpty())
                val.push(valtmp.pop());
            while (!optmp.isEmpty())
                op.push(optmp.pop());
            /* iteramos de nuevos sobre el mismo operador */
            if (it)
                i--;                            
        }   
        //se realiza un redondeo a int del resultado de la expression
        int valueInt=val.pop().intValue();
        System.out.println("\nResult = "+valueInt);  
        return valueInt;     
    }
}