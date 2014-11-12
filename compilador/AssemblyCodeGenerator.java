import java.util.*;
import ir.ast.*;
public class AssemblyCodeGenerator{
	public AssemblyCodeGenerator(){

	}
	//nro de label que se utilizara en la generacion de Or y And
	int OrAndlabelInt;

	public void incLabelOrAnd(){
		OrAndlabelInt=OrAndlabelInt+1;
	}

	public void resetLabelOrAnd(){
		OrAndlabelInt=0;
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
        //si la expresion pasada contiene una division por 0 se retorna 0
        if(input.contains("%0")){
        	return 0;
        }
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
        return valueInt;     
    }

	//cadena generada
	String result="";
	
	public void ASM_Add(TripletCode t){

		VarLocation res = (VarLocation)t.getResult();
		int ResOff = res.getOffset();

		//si el 1er operando es varlocation
		if(t.getFirstDir() instanceof VarLocation){
			VarLocation  x = (VarLocation)t.getFirstDir();
			if(x.getId().contains("factor")){
				if(x.getExpr() instanceof VarLocation){
					VarLocation e=(VarLocation)x.getExpr();
					result+="    movl " + e.getOffset() + "(%ebp) , %eax \n";	
				}else{
					result+="    movl $" + x.getExpr()+", %eax \n";	
				}
			}else{
				int XOff=x.getOffset();
				result+="    movl " + XOff + "(%ebp) , %eax \n";	
			}
			
		}else{
			//sino, si es intliteral
			if(t.getFirstDir() instanceof IntLiteral){
				IntLiteral x=(IntLiteral) t.getFirstDir();
				result+="    movl $" + x.getStringValue() + ", %eax \n";
			}else{

				//si el operando es una operacion binaria o unaria
				if(t.getFirstDir() instanceof BinOpExpr || t.getFirstDir() instanceof UnaryOpExpr){
					//valor del operando en caso de ser un operacion binaria o unaria
					int firstOpValue=0;
					//si el 1er operando es una exp binaria, calculamos su valor
					if(t.getFirstDir() instanceof BinOpExpr){

						//la obtenemos como operacion binaria
						BinOpExpr primer=(BinOpExpr) t.getFirstDir();	
						//obtenemos el operador
						BinOpType operator=primer.getOperator();

						//primer y segundo operandos de la expression
						Expression primExpr=primer.getLeftOperand();
						Expression segExpr=primer.getRightOperand();

						//vemos que ambos operandos de la operacion binaria sean enteros
						if(primExpr.getType().equals(Type.INT) && segExpr.getType().equals(Type.INT)){
							firstOpValue=evaluateExpression(primer.toString());
							result+="    movl $" + firstOpValue + ", %eax \n";
						}else{
							//System.outprintln("{ADD1}CASO BinOpExpr entre "+primExpr.getType()+" y "+segExpr.getType()+" pendiente");
						}

						
					}else{//caso contrario
						if(t.getFirstDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)

							UnaryOpExpr primer=(UnaryOpExpr) t.getFirstDir();

							if(primer.getType().equals(Type.INT) ){
								firstOpValue=evaluateExpression(primer.toString());
								result+="    movl $" + firstOpValue + ", %eax \n";
							}else{
								//System.outprintln("{ADD1}CASO UnaryOpExpr de "+primer.getType()+" pendiente");
							}
							
						}
					}
				}else{
				//caso floatliteral
					//System.outprintln("{ADD1} CASO "+t.getFirstDir().getClass()+" PENDIENTE");
				}
			}
		}

		//si el 2do operando es varlocation
		if(t.getSecondDir() instanceof VarLocation){

			VarLocation  y = (VarLocation)t.getSecondDir();
			if(y.getId().contains("factor")){
				if(y.getExpr() instanceof VarLocation){
					VarLocation e=(VarLocation)y.getExpr();
					result+="    movl " + e.getOffset() + "(%ebp) , %edx \n";
				}else{
					result+="    movl $"+ y.getExpr()+", %edx \n";
				}
			}else{
				result+="    movl "+ y.getOffset()+"(%ebp), %edx \n";
			}
			result+="    addl %eax, %edx \n";
		}else{
			//sino, si es intliteral
			if(t.getSecondDir() instanceof IntLiteral){
				IntLiteral y=(IntLiteral) t.getSecondDir();
				result+="    movl $" + y.getStringValue() + ", %edx \n";
				result+="    addl %eax, %edx \n";
			}else{
				//si el operando es una operacion binaria o unaria
				if(t.getSecondDir() instanceof BinOpExpr || t.getSecondDir() instanceof UnaryOpExpr){
					//valor del operando en caso de ser un operacion binaria o unaria
					int secondOpValue=0;
					//si el 1er operando es una exp binaria, calculamos su valor
					if(t.getSecondDir() instanceof BinOpExpr){
						//la obtenemos como operacion binaria
						BinOpExpr segunda=(BinOpExpr) t.getSecondDir();	


						//primer y segundo operandos de la expression
						Expression primExpr=segunda.getLeftOperand();
						Expression segExpr=segunda.getRightOperand();

						//vemos que ambos operandos de la operacion binaria sean enteros
						if(primExpr.getType().equals(Type.INT) && segExpr.getType().equals(Type.INT)){
							secondOpValue=evaluateExpression(segunda.toString());
							result+="    movl $" +secondOpValue+", %edx \n";
							result+="    addl %eax, %edx \n";
						}else{
							//System.outprintln("{ADD2}CASO BinOpExpr entre "+primExpr.getType()+" y "+segExpr.getType()+" pendiente");
						}
						
					}else{//caso contrario es una expresion unaria
						if(t.getSecondDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							UnaryOpExpr segunda=(UnaryOpExpr) t.getSecondDir();
							if(segunda.getType().equals(Type.INT)){
								secondOpValue=evaluateExpression(segunda.toString());
								result+="    movl $" +secondOpValue+", %edx \n";
								result+="    addl %eax, %edx \n";
							}else{
								//System.outprintln("{ADD2}CASO UnaryOpExpr de "+segunda.getType()+" pendiente");
							}
						}
					}
				}else{
				//caso float
				//System.outprintln("{ADD2} CASO "+t.getSecondDir().getClass()+" PENDIENTE");
				}
			}
		}

		result+="    movl %edx," + ResOff + "(%ebp) \n";

	}
	

	public void ASM_Sub(TripletCode t){

		VarLocation res = (VarLocation)t.getResult();
		int ResOff = res.getOffset();

		//si el 1er operando es varlocation
		if(t.getFirstDir() instanceof VarLocation){
			VarLocation  x = (VarLocation)t.getFirstDir();
			if(x.getId().contains("factor")){
				if(x.getExpr() instanceof VarLocation){
					VarLocation e=(VarLocation)x.getExpr();
					result+="    movl $" + e.getOffset() + "(%ebp) , %eax \n";
				}else{
					result+="    movl $" + x.getExpr() + ", %eax \n";
				}
			}else{
				result+="    movl " + x.getOffset() + "(%ebp) , %eax \n";
			}
		}else{
			//sino, si es intliteral
			if(t.getFirstDir() instanceof IntLiteral){
				IntLiteral x=(IntLiteral) t.getFirstDir();
				result+="    movl $" + x.getStringValue() + ", %eax \n";
			}else{
				//si el operando es una operacion binaria o unaria
				if(t.getFirstDir() instanceof BinOpExpr || t.getFirstDir() instanceof UnaryOpExpr){
					//valor del operando en caso de ser un operacion binaria o unaria
					int firstOpValue=0;
					//si el 1er operando es una exp binaria, calculamos su valor
					if(t.getFirstDir() instanceof BinOpExpr){
						//la obtenemos como operacion binaria
						BinOpExpr primer=(BinOpExpr) t.getFirstDir();	

						//primer y segundo operandos de la expression
						Expression primExpr=primer.getLeftOperand();
						Expression segExpr=primer.getRightOperand();

						//si ambos operandos son enteros
						if(segExpr.getType().equals(Type.INT) && primExpr.getType().equals(Type.INT)){
							firstOpValue=evaluateExpression(primer.toString());
							result+="    movl $" + firstOpValue + ", %eax \n";
						}else{
							//System.outprintln("{SUB1}CASO BinOpExpr entre "+primExpr.getType()+" y "+segExpr.getType()+" pendiente");
						}
						
					}else{//caso contrario
						if(t.getFirstDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							UnaryOpExpr primer=(UnaryOpExpr) t.getFirstDir();
							if(primer.getType().equals(Type.INT)){
								firstOpValue=evaluateExpression(primer.toString());
								result+="    movl $" + firstOpValue + ", %eax \n";
							}else{
								//System.outprintln("{SUB1}CASO UnaryOpExpr "+primer.getType()+" pendiente");	
							}
						}
					}
				}else{
				//caso floatliteral
					//System.outprintln("{SUB1} CASO "+t.getFirstDir().getClass()+" PENDIENTE");
				}
			}
		}
		//si el 2do operando es varlocation
		if(t.getSecondDir() instanceof VarLocation){
			VarLocation  y = (VarLocation)t.getSecondDir();
			if(y.getId().contains("factor")){
				if(y.getExpr() instanceof VarLocation){
					VarLocation e=(VarLocation)y.getExpr();
					result+="    movl " + e.getOffset() + "(%ebp) , %edx \n";	
				}else{
					result+="    movl $" + y.getExpr() + " , %edx \n";		
				}
			}else{
				int YOff=y.getOffset();
				result+="    movl " + YOff + "(%ebp) , %edx \n";	
			}
			
			result+="    subl %eax, %edx \n";
		}else{
			//sino, si es intliteral
			if(t.getSecondDir() instanceof IntLiteral){
				IntLiteral y=(IntLiteral) t.getSecondDir();
				result+="    movl $" + y.getStringValue() + ", %edx \n";
				result+="    subl %eax, %edx \n";
			}else{
				//si el operando es una operacion binaria o unaria
				if(t.getSecondDir() instanceof BinOpExpr || t.getSecondDir() instanceof UnaryOpExpr){
					//valor del operando en caso de ser binopexpr o unaryopexpr
					int secondOpValue=0;
					//si el 2do operando es una exp binaria, calculamos su valor
					if(t.getSecondDir() instanceof BinOpExpr){
						//la obtenemos como operacion binaria
						BinOpExpr segunda=(BinOpExpr) t.getFirstDir();

						//primer y segundo operandos de la expression
						Expression primExpr=segunda.getLeftOperand();
						Expression segExpr=segunda.getRightOperand();

						if(primExpr.getType().equals(Type.INT) && segExpr.getType().equals(Type.INT)){
							secondOpValue=evaluateExpression(segunda.toString());
							result+="    movl $" +secondOpValue+", %edx \n";
							result+="    subl %edx, %eax \n";
						}else{
							//System.outprintln("{SUB2}CASO BinOpExpr entre "+primExpr.getType()+" y "+segExpr.getType()+" pendiente");
						}
					}else{//caso contrario
						if(t.getSecondDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							UnaryOpExpr segunda=(UnaryOpExpr) t.getSecondDir();
							if(segunda.getType().equals(Type.INT)){
								secondOpValue=evaluateExpression(segunda.toString());
								result+="    movl $" +secondOpValue+", %edx \n";
								result+="    subl %edx, %eax \n";
							}else{
								//System.outprintln("{SUB2}CASO UnaryOpExpr "+segunda.getType()+" pendiente");
							}

                        }
                    }
				}else{
				//caso float
				//System.outprintln("{SUB2} CASO "+t.getSecondDir().getClass()+" PENDIENTE");
				}
			}
		}

		result+="    movl %eax," + ResOff + "(%ebp) \n";

	}
	
	public void ASM_Imul(TripletCode t){
		VarLocation res = (VarLocation)t.getResult();
		int ResOff = res.getOffset();

		//si el 1er operando es varlocation
		if(t.getFirstDir() instanceof VarLocation){
			VarLocation  x = (VarLocation)t.getFirstDir();
			if(x.getId().contains("factor")){
				if(x.getExpr() instanceof VarLocation){
					VarLocation e=(VarLocation)x.getExpr();
					result+="    movl " + e.getOffset() + "(%ebp) , %eax \n";
				}else{
					result+="    movl $" +x.getExpr() + " , %eax \n";
				}
			}else{
				int XOff=x.getOffset();
				result+="    movl " + XOff + "(%ebp) , %eax \n";
			}
		
		}else{
			//sino, si es intliteral
			if(t.getFirstDir() instanceof IntLiteral){
				IntLiteral x=(IntLiteral) t.getFirstDir();
				result+="    movl $" + x.getStringValue() + ", %eax \n";
			}else{
				//si el operando es una operacion binaria o unaria
				if(t.getFirstDir() instanceof BinOpExpr || t.getFirstDir() instanceof UnaryOpExpr){
					//valor del operando en caso de ser un operacion binaria o unaria
					int firstOpValue=0;
					//si el 1er operando es una exp binaria, calculamos su valor
					if(t.getFirstDir() instanceof BinOpExpr){
						//la obtenemos como operacion binaria
						BinOpExpr primer=(BinOpExpr) t.getFirstDir();	

						//primer y segundo operandos de la expression
						Expression primExpr=primer.getLeftOperand();
						Expression segExpr=primer.getRightOperand();

						//vemos que ambos operandos de la operacion binaria sean enteros
						if(primExpr.getType().equals(Type.INT) && segExpr.getType().equals(Type.INT)){
							firstOpValue=evaluateExpression(primer.toString());
							result+="    movl $" + firstOpValue + ", %eax \n";
						}else{
							//System.outprintln("{IMUL1}CASO BinOpExpr entre "+primExpr.getType()+" y "+segExpr.getType()+" pendiente");
						}

					}else{//caso contrario
						if(t.getFirstDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							UnaryOpExpr primer=(UnaryOpExpr) t.getFirstDir();
							//si la expression es entera
							if(primer.getType().equals(Type.INT)){
								firstOpValue=evaluateExpression(primer.toString());
								result+="    movl $" + firstOpValue + ", %eax \n";
							}else{
								//System.outprintln("{IMUL1}CASO UnaryOpExpr de "+primer.getType()+" pendiente");
							}
											
						}
					}
				}else{
				//caso floatliteral
					//System.outprintln("{IMUL1} CASO "+t.getFirstDir().getClass()+" PENDIENTE");
				}
			}
		}
		//si el 2do operando es varlocation
		if(t.getSecondDir() instanceof VarLocation){
			
			VarLocation  y = (VarLocation)t.getSecondDir();
			if(y.getId().contains("factor")){
				if(y.getExpr() instanceof VarLocation){
					VarLocation e=(VarLocation)y.getExpr();
					result+="    movl " + e.getOffset() + "(%ebp) , %edx \n";	
				}else{
					result+="    movl $" + y.getExpr() + ", %edx \n";	
				}
			}else{
				int YOff=y.getOffset();
				result+="    movl " + YOff + "(%ebp) , %edx \n";	
			}
			result+="    imull %edx, %eax \n";
		}else{
			//sino, si es intliteral
			if(t.getSecondDir() instanceof IntLiteral){
				IntLiteral y=(IntLiteral) t.getSecondDir();
				result+="    movl $" + y.getStringValue() + ", %edx \n";
				result+="    imull %edx, %eax \n";
			}else{
				//si el operando es una operacion binaria o unaria
				if(t.getSecondDir() instanceof BinOpExpr || t.getSecondDir() instanceof UnaryOpExpr){
					//valor del operando en caso de ser binopexpr o unaryopexpr
					int secondOpValue=0;
					//si el 2do operando es una exp binaria, calculamos su valor
					if(t.getSecondDir() instanceof BinOpExpr){
						//la obtenemos como operacion binaria
						BinOpExpr segunda=(BinOpExpr) t.getFirstDir();	

						//primer y segundo operandos de la expression
						Expression primExpr=segunda.getLeftOperand();
						Expression segExpr=segunda.getRightOperand();

						//vemos que ambos operandos de la operacion binaria sean enteros
						if(primExpr.getType().equals(Type.INT) && segExpr.getType().equals(Type.INT)){
							secondOpValue=evaluateExpression(segunda.toString());
							result+="    movl $" +secondOpValue+", %edx \n";
							result+="    imull %edx, %eax \n";
						}else{
							//System.outprintln("{IMUL2}CASO BinOpExpr entre "+primExpr.getType()+" y "+segExpr.getType()+" pendiente");
						}
						
					}else{//caso contrario es una expresion unaria
						if(t.getSecondDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							UnaryOpExpr segunda=(UnaryOpExpr) t.getSecondDir();
							if(segunda.getType().equals(Type.INT)){
								secondOpValue=evaluateExpression(segunda.toString());
								result+="    movl $" +secondOpValue+", %edx \n";
								result+="    imull %edx, %eax \n";
							}else{
								//System.outprintln("{IMUL2}CASO UnaryOpExpr de "+segunda.getType()+" pendiente");
							}

						}
					}
				}else{
				//caso float
				//System.outprintln("{IMUL2} CASO "+t.getSecondDir().getClass()+" PENDIENTE");
				}
			}
		}

		result+="    movl %eax," + ResOff + "(%ebp) \n";

	}	

	public void ASM_Idiv(TripletCode t){

		VarLocation res = (VarLocation)t.getResult();
		int ResOff = res.getOffset();

		//si el 1er operando es varlocation
		if(t.getFirstDir() instanceof VarLocation){
			VarLocation  x = (VarLocation)t.getFirstDir();
			if(x.getId().contains("factor")){
				if(x.getExpr() instanceof VarLocation){
					VarLocation e=(VarLocation)x.getExpr();
					result+="    movl " + e.getOffset() + "(%ebp) , %eax \n";	
				}else{
					result+="    movl $" + x.getExpr() + " , %eax \n";	
				}
			}else{
				int XOff=x.getOffset();
				result+="    movl " + XOff + "(%ebp) , %eax \n";	
			}
			
		}else{
			//sino, si es intliteral
			if(t.getFirstDir() instanceof IntLiteral){
				IntLiteral x=(IntLiteral) t.getFirstDir();
				result+="    movl $" + x.getStringValue() + ", %eax \n";
			}else{
				//si el operando es una operacion binaria o unaria
				if(t.getFirstDir() instanceof BinOpExpr || t.getFirstDir() instanceof UnaryOpExpr){
					//valor del operando en caso de ser un operacion binaria o unaria
					int firstOpValue=0;
					//si el 1er operando es una exp binaria, calculamos su valor
					if(t.getFirstDir() instanceof BinOpExpr){
						//la obtenemos como operacion binaria
						BinOpExpr primer=(BinOpExpr) t.getFirstDir();	
						//obtenemos el operador
						BinOpType operator=primer.getOperator();

						//primer y segundo operandos de la expression
						Expression primExpr=primer.getLeftOperand();
						Expression segExpr=primer.getRightOperand();

						//si ambos operandos son int
						if(primExpr.getType().equals(Type.INT) && segExpr.getType().equals(Type.INT)){
							firstOpValue=evaluateExpression(primer.toString());
							result+="    movl $" + firstOpValue + ", %eax \n";
						}else{
							//System.outprintln("{DIV1} CASO "+primExpr.getType()+" y "+ segExpr.getType()+" PENDIENTE");
						}
						
					}else{//caso contrario
						if(t.getFirstDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							UnaryOpExpr primer=(UnaryOpExpr) t.getFirstDir();
							firstOpValue=evaluateExpression(primer.toString());

							result+="    movl $" + firstOpValue + ", %eax \n";
						}
					}
				}else{
				//caso floatliteral
					//System.outprintln("{DIV1} CASO "+t.getFirstDir().getClass()+" PENDIENTE");
				}
			}
		}
		//si el 2do operando es varlocation
		if(t.getSecondDir() instanceof VarLocation){
			VarLocation  y = (VarLocation)t.getSecondDir();
			if(y.getId().contains("factor")){
				if(y.getExpr() instanceof VarLocation){
					VarLocation e=(VarLocation)y.getExpr();
					result+="    movl " + e.getOffset() + "(%ebp) , %ecx\n";	
				}else{
					result+="    movl $" + y.getExpr() + " , %ecx\n";	
				}
			}else{
				int YOff=y.getOffset();
				result+="    movl " + YOff + "(%ebp) , %ecx\n";	
			}
			
			result+="	 cltd\n"; 
			result+="    idiv %ecx\n";
		}else{
			//sino, si es intliteral
			if(t.getSecondDir() instanceof IntLiteral){
				IntLiteral y=(IntLiteral) t.getSecondDir();
				result+="    movl $" + y.getStringValue() + ", %ecx \n";
				result+="	 cltd\n"; 
				result+="    idiv %ecx\n";
			}else{
				//si el operando es una operacion binaria o unaria
				if(t.getSecondDir() instanceof BinOpExpr || t.getSecondDir() instanceof UnaryOpExpr){
					//valor del operando en caso de ser binopexpr o unaryopexpr
					int secondOpValue=0;
					//si el 2do operando es una exp binaria, calculamos su valor
					if(t.getSecondDir() instanceof BinOpExpr){
						
						//la obtenemos como operacion binaria
						BinOpExpr segunda=(BinOpExpr) t.getFirstDir();	
						//obtenemos el operador
						BinOpType operator=segunda.getOperator();

						//primer y segundo operandos de la expression
						Expression primExpr=segunda.getLeftOperand();
						Expression segExpr=segunda.getRightOperand();

						//si ambos operandos son int
						if(primExpr.getType().equals(Type.INT) && segExpr.getType().equals(Type.INT)){
							secondOpValue=evaluateExpression(segunda.toString());
							result+="    movl $" +secondOpValue+", %ecx \n";
							result+="	 cltd\n";
							result+="    idiv %ecx\n";
						}else{
							//System.outprintln("{DIV2} CASO "+primExpr.getType()+" y "+ segExpr.getType()+" PENDIENTE");
						}
						
					}else{//caso contrario es una expresion unaria
						if(t.getSecondDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							UnaryOpExpr segunda=(UnaryOpExpr) t.getSecondDir();
							secondOpValue=evaluateExpression(segunda.toString());
							result+="    movl $" +secondOpValue+", %ecx \n";
							result+="	 cltd\n"; 
							result+="    idiv %ecx\n";

						}
					}
				}else{
				//caso float
				//System.outprintln("{DIV2} CASO "+t.getSecondDir().getClass()+" PENDIENTE");
				}
			}
		}

		result+="    movl %ecx," + ResOff + "(%ebp) \n";
	}

	//metodo que dado un codigo de 3 direcciones de una comparacion logica GE, GEQ, LE o LEQ, CEQ o NEQ
	//genera el codigo assembly correspondiente
	public void ASM_logic(TripletCode t, TripletOperator logic){
		VarLocation res=(VarLocation) t.getResult();

			        //si el primer operando es una VarLocation
			        if(t.getFirstDir() instanceof VarLocation){
			        	//obtenemos su offset
			        	VarLocation op=(VarLocation) t.getFirstDir();
			        	int offset1=op.getOffset();
			        	result += "    movl	" + offset1 + "(%ebp), %eax\n";	
			        }else{ //caso contrario debe ser Int o Float
			        	//caso int
			        	if(t.getFirstDir() instanceof IntLiteral){
			        		IntLiteral op1=(IntLiteral) t.getFirstDir();
			        		result += "    movl	$" + op1.getRawValue() + ", %eax\n";
			        	}else{//caso float
			        		if(t.getFirstDir() instanceof FloatLiteral){
			        			FloatLiteral op1=(FloatLiteral) t.getFirstDir();
			        			result += "    movl	$" + op1.getRawValue() + ", %eax\n";	
			        		}else{
			        			//System.outprintln("{logic} FALTA CASO (1er param)" + t.getFirstDir().getClass());
			        		}
			        		
			        	}
			        }

			        //si el 2do operando es una VarLocation
			        if(t.getSecondDir() instanceof VarLocation){
			        	//obtenemos su offset
			        	VarLocation op=(VarLocation) t.getSecondDir();
			        	int offset2=op.getOffset();
			        	result += "    cmpl	" + offset2 + "(%ebp), %eax\n";	
			        }else{ //caso contrario debe ser Int o Float
			        	//caso int
			        	if(t.getSecondDir() instanceof IntLiteral){
			        		IntLiteral op2=(IntLiteral) t.getSecondDir();
			        		result += "    cmpl	$" + op2.getRawValue() + ", %eax\n";
			        	}else{//caso float
			        		if(t.getSecondDir() instanceof FloatLiteral){
			        			FloatLiteral op2=(FloatLiteral) t.getSecondDir();
			        			result += "    cmpl	$" + op2.getRawValue() + ", %eax\n";
			        		}else{
			        			//System.outprintln("{logic} FALTA CASO (2do param)" + t.getSecondDir().getClass());
			        		}
			        		
			        	}
			        }
			        //case de la operacion logica 
			        switch(logic){
			        	case LE:
			        		result += "    setl	%al\n";
			        		break;
			        	case LEQ:
			        		result += "    setle %al\n";
			        		break;
			        	case GE:
			        		result += "    setg	%al\n";
			        		break;
			        	case GEQ:
			        		result += "    setge %al\n";
			        		break;
			        	case CEQ:
			        		result += "    sete %al\n";
			        		break;
			        	case NEQ:
			        		result += "    setgne %al\n";
			        		break;
			        }
					result += "    movlzbl %al, %eax\n";
					result += "    movl	%eax, " + res.getOffset() + "(%ebp)\n";
	}

	public void ASM_Non(TripletCode t){
		//si el operando es una VarLocation
        if(t.getFirstDir() instanceof VarLocation){
     		VarLocation op=(VarLocation) t.getFirstDir();
        	VarLocation res=(VarLocation) t.getResult();
        	//obtenemos sus offset y con el mismo trabajamos
        	int operandOffSet=op.getOffset();
        	int resOffSet=res.getOffset();

	        result += "    cmpl $0, " + operandOffSet + "(%ebp) \n";
			result += "    sete %al \n";
			result += "    movlzbl %al, %eax \n";
			result += "    movl %eax, " + resOffSet + "(%ebp) \n";

        }else{ //caso contrario debe ser un BoolLiteral
        	BoolLiteral op=(BoolLiteral) t.getFirstDir();
        	VarLocation res=(VarLocation) t.getResult();
        	//obtenemos sus offset y con el mismo trabajamos
        	int resOffSet=res.getOffset();
        	if (op.toString().equals("true")){//por convencion tomaremos 1 como true y 0 como false
        		result += "    cmpl $0, " + 1 + "(%ebp) \n";	
        	}else{
        		result += "    cmpl $0, " + 0 + "(%ebp) \n";
        	}
	        
			result += "    sete	%al \n";
			result += "    movlzbl %al, %eax \n";
			result += "    movl %eax, " + resOffSet + "(%ebp) \n";
        }
	}

	public void ASM_Unary_Minus(TripletCode t){
		//caso de que el operando sea una VarLocation
	    if(t.getFirstDir() instanceof VarLocation){
	    	VarLocation op=(VarLocation) t.getFirstDir();
	    	VarLocation res=(VarLocation) t.getResult();
	    	//obtenemos sus offset y con el mismo trabajamos
	    	int operandOffSet=op.getOffset();
	    	int resOffSet=res.getOffset();

	        result += "    movl	" + operandOffSet + "(%ebp), %eax \n";
			result += "    negl	%eax \n";
			result += "    movl	%eax, " + resOffSet + "(%ebp) \n";

	    }else{ //caso contrario debe ser un Numero (int o float)
	    	VarLocation res=(VarLocation) t.getResult();
	    	//POR AHORA SOLO IMPLEMENTADO PARA INT
	    	if(t.getFirstDir() instanceof IntLiteral){
	    		IntLiteral op=(IntLiteral) t.getFirstDir();	
	        	//obtenemos sus offset y con el mismo trabajamos
	        	int resOffSet=res.getOffset();
	        	result += "    movl	$" + op.getRawValue() + ", %eax \n";
				result += "	   negl	%eax \n";
				result += "    movl	%eax, " + resOffSet + "(%ebp) \n";
	    	}else{
	    		//System.outprintln("{Unary_Minus}IMPLEMENTAR CASO -(FLOAT)");
	    	}    	
	    	
	    }
	}

	public void ASM_Mod(TripletCode t){

		//si el 2do operando es una varlocation obtenemos su offset
		if(t.getSecondDir() instanceof VarLocation){
			VarLocation secOp=(VarLocation) t.getSecondDir();
			result += "    movl	" + secOp.getOffset() + "(%ebp), %eax \n";
		}else{
			//si es una operacion binaria o unaria
			if(t.getSecondDir() instanceof BinOpExpr || t.getSecondDir() instanceof UnaryOpExpr){
				//valor del operando en caso de ser binopexpr o unaryopexpr
				int secondOpValue=0;
				//si el 2do operando es una exp binaria, calculamos su valor
				if(t.getSecondDir() instanceof BinOpExpr){
					BinOpExpr segunda=(BinOpExpr) t.getSecondDir();	
					BinOpType operator=segunda.getOperator();
					String partes[]=segunda.toString().split("\\"+operator.toString());
					int primerValor=evaluateExpression(partes[0].trim());
					int segundoValor=evaluateExpression(partes[1].trim());
					switch(operator){
						case PLUS:
							secondOpValue=(primerValor)+(segundoValor);
							break;
						case MINUS:
							secondOpValue=(primerValor)-(segundoValor);
							break;
						case MULTIPLY:
							secondOpValue=primerValor*segundoValor;
							break;
						case DIVIDE:
							secondOpValue=(primerValor)/(segundoValor);
							break;
						case MOD:
							secondOpValue=(primerValor)%(segundoValor);
							break;
					}
					result+="    movl $" +secondOpValue+", %eax \n";
				}else{//caso contrario es una expresion unaria
					if(t.getSecondDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
						UnaryOpExpr segunda=(UnaryOpExpr) t.getSecondDir();
						secondOpValue=evaluateExpression(segunda.toString());
						result+="    movl $" +secondOpValue+", %eax \n";
					}
				}
			}
			//sino, debe ser un intliteral
			IntLiteral secOp=(IntLiteral) t.getSecondDir();
			result += "    movl	$" + secOp.getRawValue() + ", %eax \n";
		}
		result += "    cltd\n";
		//si el 1er operando es una varlocation obtenemos su offset
		if(t.getFirstDir() instanceof VarLocation){
			VarLocation firstOp=(VarLocation) t.getFirstDir();
			result += "    idivl " + firstOp.getOffset() + "(%ebp)\n";
		}else{
			//si el operando es una operacion binaria o unaria
			if(t.getFirstDir() instanceof BinOpExpr || t.getFirstDir() instanceof UnaryOpExpr){
				//valor del operando en caso de ser un operacion binaria o unaria
				int firstOpValue=0;
				//si el 1er operando es una exp binaria, calculamos su valor
				if(t.getFirstDir() instanceof BinOpExpr){
					BinOpExpr primer=(BinOpExpr) t.getFirstDir();	
					BinOpType operator=primer.getOperator();
					String partes[]=primer.toString().split("\\"+operator.toString());
					int primerValor=evaluateExpression(partes[0].trim());
					int segundoValor=evaluateExpression(partes[1].trim());
					switch(operator){
						case PLUS:
							firstOpValue=(primerValor)+(segundoValor);
							break;
						case MINUS:
							firstOpValue=(primerValor)-(segundoValor);

							break;
						case MULTIPLY:
							firstOpValue=primerValor*segundoValor;
							break;
						case DIVIDE:
							firstOpValue=(primerValor)/(segundoValor);
							break;
						case MOD:
							firstOpValue=(primerValor)%(segundoValor);
							break;
					}
					result+="    idivl $" + firstOpValue + "\n";
				}else{//caso contrario
					if(t.getFirstDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
						UnaryOpExpr primer=(UnaryOpExpr) t.getFirstDir();
						firstOpValue=evaluateExpression(primer.toString());

						result+="    idivl $" + firstOpValue + "\n";
					}
				}
			}else{
			//sino, debe ser un intliteral
			IntLiteral firstOp=(IntLiteral) t.getFirstDir();
			result += "    idivl $" + firstOp.getRawValue() + " \n";
			}
		}
		//obtenemos la varlocation resultado
		VarLocation res=(VarLocation) t.getResult();
		result += "    movl	%edx, " + res.getOffset() + "(%ebp)\n";//en edx queda el resto de la division

	}

	public void ASM_Assing(TripletCode t){
		
		//al tratarse de una asignacion, el tercer parametro siempre sera VarLocation
		//por lo tanto solo nos fijamos que es el 1er parametro
		//obtenemos la variable en que se guardara
		VarLocation res=(VarLocation) t.getResult();
		if(t.getFirstDir() instanceof VarLocation){
			//obtenemos el valor a asignar
			VarLocation firstOp=(VarLocation) t.getFirstDir();	
			//si se trata de un factor (es un temporal)
			if(firstOp.getId().contains("factor")){
				if(firstOp.getExpr() instanceof VarLocation){
					VarLocation e=(VarLocation) firstOp.getExpr();
					result=result+"    movl $"+e.getExpr()+","+res.getOffset() +"(%ebp)\n";	
				}else{
					if(firstOp.getExpr() instanceof MethodCallExpr){
						//si se trata de una llamada a un metodo como factor de una operacion, obtenemos su resultado
						//que siempre se guarda en eax y lo movemos a donde se necesita
						result=result+"    movl %eax,"+res.getOffset() +"(%ebp)\n";	
					}else{
						if(firstOp.getExpr() instanceof BoolLiteral){
							BoolLiteral b=(BoolLiteral) firstOp.getExpr();
							if(b.getValue()){
								result=result+"    movl $1,"+res.getOffset() +"(%ebp)\n";				
							}else{
								result=result+"    movl $0,"+res.getOffset() +"(%ebp)\n";				
							}
						}else{
							if(firstOp.getExpr() instanceof ExternInvkExpr){
								ExternInvkExpr mc=(ExternInvkExpr)firstOp.getExpr();
								if(mc.getType().equals(Type.INT)){
						   			result+= "    movl %eax,"+res.getOffset() +"(%ebp) \n";	
						   		}else{
						   			////System.outprintln("EXTERNINVK CASO "+mc.getType()+" PENDIENTE");
						   		}
							}else{
								result=result+"    movl $"+firstOp.getExpr()+","+res.getOffset() +"(%ebp)\n";			
							}
							
						}
						
					}
					
				}
			}else{//caso contrario, es otra VarLocation
				result=result+"    movl " + firstOp.getOffset() + "(%ebp)"+",%eax\n";	
				result=result+"    movl %eax, "+res.getOffset() +"(%ebp)\n";
			}
		}else{
			//si el valor proviene de una llamada a un metodo
			if(t.getFirstDir() instanceof MethodCallExpr || t.getFirstDir() instanceof ExternInvkExpr){
				result+="    movl %eax, "+res.getOffset()+"(%ebp)";	
			}else{//si no proviene de una llamada a un metodo
				//si se trata de una operacion binaria
				if(t.getFirstDir() instanceof BinOpExpr){
					//la obtenemos como operacion binaria
					BinOpExpr primer=(BinOpExpr) t.getFirstDir();

					BinOpType operator=primer.getOperator();
					//primer y segundo operandos de la expression
					Expression primExpr=null;
					if(primer.getLeftOperand() instanceof VarLocation){
						primExpr=primer.getLeftOperand().getExpr();
					}else{
						primExpr=primer.getLeftOperand();	
					}

					Expression segExpr=null;
					if(primer.getRightOperand() instanceof VarLocation){
						segExpr=primer.getRightOperand().getExpr();
					}else{
						segExpr=primer.getRightOperand();	
					}
					String expresion=primExpr.toString()+""+operator.toString()+""+segExpr.toString();
					expresion=expresion.replaceAll("--","+");

					//vemos que ambos operandos de la operacion binaria sean enteros
					if(primExpr.getType().equals(Type.INT) && segExpr.getType().equals(Type.INT)){
						int firstOpValue=evaluateExpression(expresion);
						result=result+"    movl $" +firstOpValue + ", "+res.getOffset()+"(%ebp)\n";		
					}else{
						//System.outprintln("{ASSIGN}CASO BinOpExpr entre "+primExpr.getType()+" y "+segExpr.getType()+" pendiente");
					}
				}else{//sino, debe tratarse de una operacion unaria
					if(t.getFirstDir() instanceof UnaryOpExpr){
						UnaryOpExpr uop=(UnaryOpExpr) t.getFirstDir();
						int opValue=evaluateExpression(uop.toString());
						result=result+"    movl $" +opValue+ ", "+res.getOffset()+"(%ebp)\n";		
					}else{
						//si se trata de un IntLiteral
						if(t.getFirstDir() instanceof IntLiteral){
							IntLiteral i=(IntLiteral) t.getFirstDir();
							result=result+"    movl $" +i.getValue()+ ", "+res.getOffset()+"(%ebp)\n";			
						}else{//sino
							//si se trata de un acceso de a un arreglo
							if(t.getFirstDir() instanceof ArrayLiteral){
								ArrayLiteral arr=(ArrayLiteral) t.getFirstDir();
								//buscamos el offset de la declaracion del arreglo
								VarLocation v=res.search(arr.getId());
								//System.outprintln("{ASSIGN} ArrayLiteral expr: "+arr.getIndex()+" , "+arr.getIndex().getClass());
								int index=evaluateExpression(arr.getIndex().getExpr().toString());
								//System.outprintln("expr evaluada: "+index);
								result=result+"    movl " +(v.getOffset()-((v.getSize()-index)*4))+ "(%ebp), %eax\n";
								result=result+"    movl %eax,"+res.getOffset()+"(%ebp)\n";
							}else{//sino
								//si es un BoolLiteral
								if(t.getFirstDir() instanceof BoolLiteral){
									BoolLiteral b=(BoolLiteral)t.getFirstDir();
									if(b.getValue()){
										result=result+"    movl $1, "+res.getOffset()+"(%ebp)\n";			
									}else{
										result=result+"    movl $0, "+res.getOffset()+"(%ebp)\n";			
									} 
								}else{
									//System.outprintln("{ASSIGN}2 FALTA CASO "+t.getFirstDir().getClass());		
								}
							}
						}
					}
				}
			}			
		}
	}

	public void ASM_Label(TripletCode t){
		String res=(String)t.getResult();
    	//ignoramos las label que marcan inicio de declaracion de metodos
    	if(!res.contains("BeginMethod")){
	    	//si la label marca el fin de un metodo (de su declaracion) agregamos un leave y ret
	    	if(res.contains("EndMethod")){
	    		result += "    leave\n";
	    		result=result+ "    ret\n";
	    		result += "\n";
	    	}else{
	    		result=result+ "."+t.getResult()+":\n"; 
	    	}
	    }
	}

	public void ASM_Cmp(TripletCode t){
		if(t.getSecondDir() instanceof VarLocation){
			VarLocation secondOp=(VarLocation)t.getSecondDir();
			result += "    movl " + secondOp.getOffset() + "(%ebp), %eax\n";	
		}else{
			if(t.getSecondDir() instanceof IntLiteral){
				IntLiteral i=(IntLiteral) t.getSecondDir();
				result += "    movl $" +i.getStringValue() + ", %eax\n";	
			}else{
				if(t.getSecondDir() instanceof BoolLiteral){
					BoolLiteral b=(BoolLiteral) t.getSecondDir();
					if(b.getValue()){
						result += "    movl $ 1, %eax\n";	
					}else{
						result += "    movl $ 0, %eax\n";	
					}
				}else{
					if(t.getSecondDir() instanceof Boolean){
						Boolean b=(Boolean) t.getSecondDir();
						if(b){
							result += "    movl $ 1, %eax\n";	
						}else{
							result += "    movl $ 0, %eax\n";	
						}
					}else{
						//System.outprintln("{CMP} FALTA CASO "+t.getSecondDir().getClass());	
					}
					
				}
			}
		}
		if(t.getFirstDir() instanceof VarLocation){
			VarLocation firstOp=(VarLocation)t.getFirstDir();
			result += "    cmpl " + firstOp.getOffset() + "(%ebp), %eax\n";
		}else{
			result += "    cmpl " + t.getFirstDir() + "(%ebp), %eax\n";
		}
	}

	public void ASM_Method_Decl(TripletCode t){
		Metodo m=(Metodo)t.getFirstDir();
		result += "    .text\n";
		result += "    .globl	" + m.getName() + "\n";
		result += "    .type	" + m.getName() + ", @function \n";			
		result += m.getName() + ": \n";	
		/*Dejamos espacio para los parametros del metodo*/
		if(m.getParametros().size()>0){
			result += "    enter   $("+4 * m.getParametros().size() + "), $0 \n";	
		}
		result += "    pushl	%ebp\n";
		result += "    movl %esp, %ebp\n";
	}

	public void ASM_Or(TripletCode t){
		if(t.getFirstDir() instanceof VarLocation && t.getSecondDir() instanceof VarLocation){
			VarLocation op1=(VarLocation)t.getFirstDir();
			VarLocation op2=(VarLocation)t.getSecondDir();
			VarLocation res=(VarLocation)t.getResult();

			int label1=OrAndlabelInt;
			incLabelOrAnd();
			int label2=OrAndlabelInt;
			incLabelOrAnd();
			//label final
			int label3=OrAndlabelInt;
			incLabelOrAnd();

			result += "    cmpl	$0, " + op1.getOffset() + "(%ebp)\n";
			result += "    jne .L" +label1  + "\n";		
			result += "    cmpl	$0, " + op2.getOffset() + "(%ebp)\n";
			result += "    je .L" + label1 + "\n";
			result += "    movl	$1, %eax\n";
			result += "    jmp .L" + label2 + "\n";
			result += ".L" + label1 + ":\n";
			result += "    movl	$0, %eax\n";
			result += "    jmp .L" + label3 + "\n";
			result += ".L" + label2 + ":\n";
			result += "    movl	%eax, " + res.getOffset() + "(%ebp)\n";
			result += ".L"+label3+":\n";
		}else{
			//System.outprintln("{Or}TRATAMIENTO PARA " + t.getFirstDir().getClass()+ " y "+ t.getSecondDir().getClass()+" PENDIENTE");
		}
		
	}

	public void ASM_And(TripletCode t){
		if(t.getFirstDir() instanceof VarLocation && t.getSecondDir() instanceof VarLocation){
			VarLocation op1=(VarLocation)t.getFirstDir();
			VarLocation op2=(VarLocation)t.getSecondDir();
			VarLocation res=(VarLocation)t.getResult();

			int label1=OrAndlabelInt;
			incLabelOrAnd();
			int label2=OrAndlabelInt;
			incLabelOrAnd();
			//label final
			int label3=OrAndlabelInt;
			incLabelOrAnd();

			result += "    cmpl	$0, " + op1.getOffset() + "(%ebp)\n";
			result += "    je .L" +label1  + "\n";		
			result += "    cmpl	$0, " + op2.getOffset() + "(%ebp)\n";
			result += "    je .L" + label1 + "\n";
			result += "    movl	$1, %eax\n";
			result += "    jmp .L" + label2 + "\n";
			result += ".L" + label1 + ":\n";
			result += "    movl	$0, %eax\n";
			result += "    jmp .L" + label3 + "\n";
			result += ".L" + label2 + ":\n";
			result += "    movl	%eax, " + res.getOffset() + "(%ebp)\n";
			result += ".L"+label3+":\n";

		}else{
			//System.outprintln("{And}TRATAMIENTO PARA " + t.getFirstDir().getClass()+ " y "+ t.getSecondDir().getClass()+" PENDIENTE");
		}
		
	}

	//registro de parametros de llamada a metodo
	public void ASM_Params(TripletCode t){
		//obtenemos la lista de parametros del metodo llamado
    	LinkedList<Expression> params=(LinkedList<Expression>) t.getResult();
    	//si tiene parametros
    	if(params.size()!=0){
    		//los parametros de agregan en orden inverso
	    	for(int i=params.size()-1; i>=0; i--){

	    		//si el parametro es una VarLocation obtenemos su offset
	    		if(params.get(i) instanceof VarLocation){
	    			VarLocation v=(VarLocation) params.get(i);
	    			if(i!=0){
	    				result+="    movl "+v.getOffset()+"(%esp) , %eax\n";		
	    				result+="    movl %eax,"+(((i+2))*4)+"(%esp)\n";
	    			}else{
	    				result+="    movl "+v.getOffset()+"(%esp) , 8(%esp)\n";	
	    			}
	    			
	    		}else{//sino, debe ser un Literal o una llamada a metodo
	    			//si no es una llamada a metodo (deberia ser un literal entonces)
	    			if(!(params.get(i) instanceof MethodCallExpr)){
	    				//caso IntLiteral
	    				if(params.get(i) instanceof IntLiteral){
	    					IntLiteral p=(IntLiteral) params.get(i);
	   
	    					if(i!=0){
	    						result+="    movl $"+evaluateExpression(p.toString())+" , "+(((i+2))*4)+"(%esp)\n";	
	    					}else{
	    						result+="    movl $"+evaluateExpression(p.toString())+" , 8(%esp)\n";	
	    					}
	    					
	    				}else{
	    					//caso BoolLiteral
		    				if(params.get(i) instanceof BoolLiteral){
		   
		    					BoolLiteral p=(BoolLiteral) params.get(i);
		    					if(i!=0){
		    						if(p.getValue()){
		    							result+="    movl $"+1+" , "+((i-1)*4)+"(%esp)";		
		    						}else{
		    							result+="    movl $"+0+" , "+((i-1)*4)+"(%esp)";	
		    						}
		    						
		    					}else{
		    						if(p.getValue()){
		    							result+="    movl $"+1+" , (%esp)";	
		    						}else{
		    							result+="    movl $"+0+" , (%esp)";
		    						}
		    						
		    					}
		    					
		    				}else{
		    					//caso FloatLiteral
		    					if(params.get(i) instanceof FloatLiteral){
		    						//System.outprintln("{PARAM} CASO FLAOTLITERAL PENDIENTE");
		    					}else{
		    						//si el parametro es una operacion binaria
		    						if(params.get(i) instanceof BinOpExpr){
		    	
		    							BinOpExpr b=(BinOpExpr) params.get(i);
		    							Expression firstOp=b.getLeftOperand();
		    							Expression secOp=b.getRightOperand();
		    							//si es una binaria entre enteros
		    							if(firstOp.getType().equals(Type.INT) && secOp.getType().equals(Type.INT)){
		    								//la evaluamos
		    								//System.outprintln("{PARAMS} expr: "+b.toString());
		    								int opValue=evaluateExpression(b.toString());
		    								if(i!=0){
					    						result+="    movl $"+opValue+" , "+((i-1)*4)+"(%esp)";	
					    					}else{
					    						result+="    movl $"+opValue+" , (%esp)";
					    					}
		    							}
		    						}else{
		    							//si es una operacion binaria
		    							if(params.get(i) instanceof UnaryOpExpr){
		    		
		    								UnaryOpExpr uop=(UnaryOpExpr)params.get(i);
											if(uop.getType().equals(Type.INT)){
												int opValue=evaluateExpression(uop.toString());
												if(i!=0){
						    						result+="    movl $"+opValue+" , "+((i-1)*4)+"(%esp)";	
						    					}else{
						    						result+="    movl $"+opValue+" , (%esp)";
						    					}
											}else{
												//System.outprintln("{PARAM} FALTA CASO UnaryOpExpr "+uop.getType());		
											}				
		    							}else{
		    								//demas casos
	    									//System.outprintln("{PARAM} FALTA CASO "+params.get(i).getClass());	
		    							}
		    							
		    						}
		    						
		    					}
		    					
		    				}
	    				}
	    			}else{
	    				//System.outprintln("{PARAM} CASO METHODCALL ");
	    			}		    			
	    		}
	    	}
    	}
    	
	}



	public void ASM_Increment(TripletCode t){
		VarLocation res=(VarLocation) t.getResult();
    	//si la expresion es un entero
    	if(t.getFirstDir() instanceof IntLiteral){
    		IntLiteral i=(IntLiteral) t.getFirstDir();
    		int opValue=evaluateExpression(i.getStringValue());
    		result+="    addl $"+opValue+", "+res.getOffset()+"(%ebp)\n";
    	}else{//sino
    		//si es un VarLocation
    		if(t.getFirstDir() instanceof VarLocation){
    			VarLocation v=(VarLocation) t.getFirstDir();
    			result+="    movl "+v.getOffset()+"(%ebp), %eax\n";
    			result+="    addl %eax, "+res.getOffset()+"(%ebp)\n";
    		}else{
    			//si es una operacion Binaria
    			if(t.getFirstDir() instanceof BinOpExpr){
    				BinOpExpr bop=(BinOpExpr)t.getFirstDir();
    				//obtenemos ambos operandos
    				Expression firstOp=bop.getLeftOperand();
    				Expression secOp=bop.getRightOperand();
    				//si ambos son enteros
    				if(firstOp.getType().equals(Type.INT) && secOp.getType().equals(Type.INT)){
    					int opValue=evaluateExpression(bop.toString());
    					result+="    addl $"+opValue+", "+res.getOffset()+"(%ebp)\n";	
    				}else{
    					//System.outprintln("{INCREMENT} FALTA CASO BinOpExpr entre "+firstOp.getType()+" y "+secOp.getType());
    				}
    			}else{
    				//System.outprintln("{INCREMENT} FALTA CASO "+t.getFirstDir().getClass());	
    			}
    			
    		}

    	}
	}

	public void ASM_Decrement(TripletCode t){
		VarLocation res=(VarLocation) t.getResult();
		//si la expresion es un entero
		if(t.getFirstDir() instanceof IntLiteral){
			IntLiteral i=(IntLiteral) t.getFirstDir();
			int opValue=evaluateExpression(i.getStringValue());
			result+="    subl $"+opValue+", "+res.getOffset()+"(%ebp)\n";
		}else{//sino
			//si es un VarLocation
			if(t.getFirstDir() instanceof VarLocation){
				VarLocation v=(VarLocation) t.getFirstDir();
				result+="    movl "+v.getOffset()+"(%ebp), %eax\n";
				result+="    subl %eax, "+res.getOffset()+"(%ebp)\n";
			}else{
				//si es una operacion Binaria
    			if(t.getFirstDir() instanceof BinOpExpr){
    				BinOpExpr bop=(BinOpExpr)t.getFirstDir();
    				//obtenemos ambos operandos
    				Expression firstOp=bop.getLeftOperand();
    				Expression secOp=bop.getRightOperand();
    				//si ambos son enteros
    				if(firstOp.getType().equals(Type.INT) && secOp.getType().equals(Type.INT)){
    					int opValue=evaluateExpression(bop.toString());
    					result+="    subl $"+opValue+", "+res.getOffset()+"(%ebp)\n";	
    				}else{
    					//System.outprintln("{DECREMENT} FALTA CASO BinOpExpr entre "+firstOp.getType()+" y "+secOp.getType());
    				}
    			}else{
    				//System.outprintln("{DECREMENT} FALTA CASO "+t.getFirstDir().getClass());	
    			}
			}

		}
	}

	//metodo que dada una lista de codigos de 3 direcciones genera el codigo assembly correspondiente
	public String generate(LinkedList<TripletCode> list){
		OrAndlabelInt=0;
		for(TripletCode t: list){
			//System.outprintln("");
			//System.outprintln("procesando: "+t);
			switch(t.getOperator()){
				
				case PLUS:
					result+="\n";
					ASM_Add(t);
					break;

				case MINUS:
					result+="\n";
					ASM_Sub(t);
					break;

			    case MULTIPLY:
			    	result+="\n";
			        ASM_Imul(t); 
			        break;

			    case DIVIDE:
			    	result+="\n";
			        ASM_Idiv(t);
			        break;
			    case MOD:
			    	result+="\n";
			        ASM_Mod(t);
			        break;
			    case LE:
			    	result+="\n";
			      	ASM_logic(t, t.getOperator());	
			        break;
			    case LEQ:
			    	result+="\n";
			        ASM_logic(t, t.getOperator());	
			        break;
			    case GE:
			    	result+="\n";
			        ASM_logic(t, t.getOperator());	
			        break;
			    case GEQ:
			    	result+="\n";
			        ASM_logic(t, t.getOperator());	
			        break;
			    case NON: 
			    	result+="\n";
			    	ASM_Non(t);
			        break;
				case UNARYMINUS:
					result+="\n";
			        ASM_Unary_Minus(t);
			        break;
			    case AND:
			    	result+="\n";
			        ASM_And(t);
			        break;
			    case CEQ:
			    	result+="\n";
			        ASM_logic(t, t.getOperator());
			        break;
			    case NEQ:
			    	result+="\n";
			        ASM_logic(t, t.getOperator());
			        break;
				case ASSIGN:
					result+="\n";
					ASM_Assing(t);
			        break;
			    case INCREMENT:
			    	result+="\n";

			    	ASM_Increment(t);

			    	break;
			    case DECREMENT:
			    	result+="\n";
					
					ASM_Decrement(t);

			    	break;
			    case LABEL:
			    	result+="\n";
			    	ASM_Label(t);
			    	break;
				case RETURN:
					result+="\n";
					if (t.getResult() != null){
						//si el resultado esta almacenado en una varlocation
						if(t.getResult() instanceof VarLocation){
							VarLocation v=(VarLocation) t.getResult();
							int offset=v.getOffset();
							//si es un literal (factor)
							if(v.getId().contains("factor")){
								//si es un ArrayLiteral
								if(v.getExpr() instanceof ArrayLiteral){

									ArrayLiteral arr=(ArrayLiteral) v.getExpr();
									//buscamos el offset en que se declaro
									VarLocation res=v.search(arr.getId());
									if(res!=null){
										//System.outprintln("{RETURN} ArrayLiteral expr: "+arr.getIndex()+" , "+arr.getIndex().getClass());
										int index=evaluateExpression(arr.getIndex().getExpr().toString());
										//System.outprintln("expr evaluada: "+index);
										offset=(res.getOffset()-((res.getSize()-index)*4));
										result += "    movl " + offset + "(%ebp), %eax\n";
									}else{	
										//System.outprintln("ArrayLiteral no encontrado");
									}
								}else{
									result += "    movl $" + v.getExpr() + ", %eax\n";	
								}
							}else{
								result += "    movl " + offset + "(%ebp), %eax\n";	
							}
						}else{
							if(t.getResult() instanceof IntLiteral){
								IntLiteral i=(IntLiteral) t.getResult();
								result += "    movl $" +i.getStringValue() + ", %eax\n";	
							}else{
								//System.outprintln("{RETURN} FALTA CASO "+t.getResult().getClass());
							}
				 		}
				 	}else {
						result += "    movl $0, %eax\n";
					}
				 	
			    	break;
			    case PARAM:
			    	result+="\n";
			    	ASM_Params(t);

			    	break;
			    case CMP:
			    	result+="\n";
			    	ASM_Cmp(t);
			    	break;
			 	case JMP:
			 		result+="\n";
			    	result=result+ "    jmp "+t.getResult()+"\n"; 
			    	break;
			    case OR:
			    	result+="\n";
			    	ASM_Or(t);
			    	break;
			    case ARRAYLABEL:
			    	result+="\n";
			    	result=result+ "array[]\n"; 
			    	break;
			   	case JNE:
			   		result+="\n";
			   		result=result+ "    jne "+t.getResult()+"\n"; 
			   		break;
			   	case JNL:
			   		result+="\n";
			   		result=result+ "    jnl "+t.getResult()+"\n"; 
			   		break;
			   	case METHODCALL:
			   		result+="\n";
			   		result += "    call " + t.getFirstDir() + "\n";		
			   		break;
			   	case EXTERNINVK:
			   		result+="\n";
			   		ExternInvkExpr mc=(ExternInvkExpr) t.getFirstDir();
			   		String id=mc.getId().substring(1, mc.getId().length()-1);
			   		if(id.equals("printf")){
			   			result += "    call imprimir\n";
			   		}else{
			   			result += "    call " + id + "\n";
			   		}
			   		
			   		
			   		break;
			   	case METHODDECL:
			   		result+="\n";
		   			ASM_Method_Decl(t);
		   			break;
		   		case GLOBAL:
		   			result+="\n";
		   			if(t.getResult() instanceof Integer){
		   				int y=(int) t.getResult();
			   			if(y==0){
			   				result+="    .comm "+t.getSecondDir()+","+4+"\n";	
			   			}else{
			   				int res=(int)t.getResult();
			   				result+="    .comm "+t.getSecondDir()+","+(4*y)+"\n";
			   			}	   			
		   			}else{
		   				//System.outprintln("{GLOBAL} "+t);
		   				//System.outprintln("{GLOBAL} FALTA CASO "+t.getResult().getClass());
		   			}
		   			break;
			}
			//System.outprintln("finalizado");
		}
		return result;
	}
}
