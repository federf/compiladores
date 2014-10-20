package ir.ast;

import ir.ASTVisitor;

public class VarLocation extends Location {

    Type type;
    int size;
    int offset;
    
    static int off = -4;

    public static void resetOffset(){
        off = -4;
    }

    public VarLocation(String id, Type type, Expression expr, int size) {
        this.id=id;
        this.type = type;
        this.expr = expr;
        this.size = size;
        this.offset = off;
        //para el tamaño de los arreglos
        off = off - (size*4) ;
        //cambiamos el offset para el proximo
        off = off - 4;
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
}