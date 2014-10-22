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

	//cadena generada
	String result="";
	
	public void ASM_Add(TripletCode t){

		VarLocation res = (VarLocation)t.getResult();
		int ResOff = res.getOffset();

		//si el 1er operando es varlocation
		if(t.getFirstDir() instanceof VarLocation){
			//System.out.println("varlocation1");
			VarLocation  x = (VarLocation)t.getFirstDir();
			int XOff=x.getOffset();
			result+="    mov " + XOff + "(%ebp) , %eax \n";
		}else{
			//sino, si es intliteral
			if(t.getFirstDir() instanceof IntLiteral){
				//System.out.println("int");
				IntLiteral x=(IntLiteral) t.getFirstDir();
				result+="    mov $" + x.getStringValue() + ", %eax \n";
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
							result+="    mov $" + firstOpValue + ", %eax \n";
						}else{
							System.out.println("{ADD1}CASO BinOpExpr entre "+primExpr.getType()+" y "+segExpr.getType()+" pendiente");
						}

						
					}else{//caso contrario
						if(t.getFirstDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)

							UnaryOpExpr primer=(UnaryOpExpr) t.getFirstDir();

							if(primer.getType().equals(Type.INT) ){
								firstOpValue=evaluateExpression(primer.toString());
								result+="    mov $" + firstOpValue + ", %eax \n";
							}else{
								//System.out.println("nada1 "+primer.getType());
								System.out.println("{ADD1}CASO UnaryOpExpr de "+primer.getType()+" pendiente");
							}
							
						}
					}
				}else{
				//caso floatliteral
					System.out.println("{ADD1} CASO "+t.getFirstDir().getClass()+" PENDIENTE");
				}
			}
		}

		//si el 2do operando es varlocation
		if(t.getSecondDir() instanceof VarLocation){
			System.out.println("VarLocation2");
			VarLocation  y = (VarLocation)t.getSecondDir();
			int YOff=y.getOffset();
			result+="    mov " + YOff + "(%ebp) , %edx \n";
		}else{
			//sino, si es intliteral
			if(t.getSecondDir() instanceof IntLiteral){
				//System.out.println("int2");
				IntLiteral y=(IntLiteral) t.getSecondDir();
				result+="    mov $" + y.getStringValue() + ", %edx \n";
			}else{
				//si el operando es una operacion binaria o unaria
				if(t.getSecondDir() instanceof BinOpExpr || t.getSecondDir() instanceof UnaryOpExpr){
					//valor del operando en caso de ser un operacion binaria o unaria
					int secondOpValue=0;
					//si el 1er operando es una exp binaria, calculamos su valor
					if(t.getSecondDir() instanceof BinOpExpr){
						//System.out.println("binop2");
						//la obtenemos como operacion binaria
						BinOpExpr segunda=(BinOpExpr) t.getSecondDir();	


						//primer y segundo operandos de la expression
						Expression primExpr=segunda.getLeftOperand();
						Expression segExpr=segunda.getRightOperand();

						//vemos que ambos operandos de la operacion binaria sean enteros
						if(primExpr.getType().equals(Type.INT) && segExpr.getType().equals(Type.INT)){
							secondOpValue=evaluateExpression(segunda.toString());
							result+="    mov $" +secondOpValue+", %edx \n";
							result+="    add %eax, %edx \n";
						}else{
							System.out.println("{ADD2}CASO BinOpExpr entre "+primExpr.getType()+" y "+segExpr.getType()+" pendiente");
						}
						
					}else{//caso contrario es una expresion unaria
						if(t.getSecondDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							//System.out.println("unary2");
							UnaryOpExpr segunda=(UnaryOpExpr) t.getSecondDir();
							if(segunda.getType().equals(Type.INT)){
								secondOpValue=evaluateExpression(segunda.toString());
								result+="    mov $" +secondOpValue+", %edx \n";
								result+="    add %eax, %edx \n";
							}else{
								System.out.println("{ADD2}CASO UnaryOpExpr de "+segunda.getType()+" pendiente");
							}
						}
					}
				}else{
				//caso float
				System.out.println("{ADD2} CASO "+t.getSecondDir().getClass()+" PENDIENTE");
				}
			}
		}

		result+="    mov %edx," + ResOff + "%(ebp) \n";

	}
	

	public void ASM_Sub(TripletCode t){

		VarLocation res = (VarLocation)t.getResult();
		int ResOff = res.getOffset();

		//si el 1er operando es varlocation
		if(t.getFirstDir() instanceof VarLocation){
		VarLocation  x = (VarLocation)t.getFirstDir();
		int XOff=x.getOffset();
		result+="    mov " + XOff + "(%ebp) , %eax \n";
		}else{
			//sino, si es intliteral
			if(t.getFirstDir() instanceof IntLiteral){
				IntLiteral x=(IntLiteral) t.getFirstDir();
				result+="    mov $" + x.getStringValue() + ", %eax \n";
			}else{
				//si el operando es una operacion binaria o unaria
				if(t.getFirstDir() instanceof BinOpExpr || t.getFirstDir() instanceof UnaryOpExpr){
					//valor del operando en caso de ser un operacion binaria o unaria
					int firstOpValue=0;
					//si el 1er operando es una exp binaria, calculamos su valor
					//System.out.println("1er operacion es: -. . "+t.getFirstDir());
					if(t.getFirstDir() instanceof BinOpExpr){
						//la obtenemos como operacion binaria
						BinOpExpr primer=(BinOpExpr) t.getFirstDir();	

						//primer y segundo operandos de la expression
						Expression primExpr=primer.getLeftOperand();
						Expression segExpr=primer.getRightOperand();

						//si ambos operandos son enteros
						if(segExpr.getType().equals(Type.INT) && primExpr.getType().equals(Type.INT)){
							firstOpValue=evaluateExpression(primer.toString());
							result+="    mov $" + firstOpValue + ", %eax \n";
						}else{
							System.out.println("{SUB1}CASO BinOpExpr entre "+primExpr.getType()+" y "+segExpr.getType()+" pendiente");
						}
						
					}else{//caso contrario
						if(t.getFirstDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							UnaryOpExpr primer=(UnaryOpExpr) t.getFirstDir();
							if(primer.getType().equals(Type.INT)){
								firstOpValue=evaluateExpression(primer.toString());
								result+="    mov $" + firstOpValue + ", %eax \n";
							}else{
								System.out.println("{SUB1}CASO UnaryOpExpr "+primer.getType()+" pendiente");	
							}
						}
					}
				}else{
				//caso floatliteral
					System.out.println("{SUB1} CASO "+t.getFirstDir().getClass()+" PENDIENTE");
				}
			}
		}
		//si el 2do operando es varlocation
		if(t.getSecondDir() instanceof VarLocation){
			VarLocation  y = (VarLocation)t.getSecondDir();
			int YOff=y.getOffset();
			result+="    mov " + YOff + "(%ebp) , %edx \n";
		}else{
			//sino, si es intliteral
			if(t.getSecondDir() instanceof IntLiteral){
				IntLiteral y=(IntLiteral) t.getSecondDir();
				result+="    mov $" + y.getStringValue() + ", %edx \n";
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
							result+="    mov $" +secondOpValue+", %edx \n";
							result+="    sub %eax, %edx \n";
						}else{
							System.out.println("{SUB2}CASO BinOpExpr entre "+primExpr.getType()+" y "+segExpr.getType()+" pendiente");
						}
					}else{//caso contrario
						if(t.getSecondDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							UnaryOpExpr segunda=(UnaryOpExpr) t.getSecondDir();
							if(segunda.getType().equals(Type.INT)){
								secondOpValue=evaluateExpression(segunda.toString());
								result+="    mov $" +secondOpValue+", %edx \n";
								result+="    sub %eax, %edx \n";
							}else{
								System.out.println("{SUB2}CASO UnaryOpExpr "+segunda.getType()+" pendiente");
							}

                        }
                    }
				}else{
				//caso float
				System.out.println("{SUB2} CASO "+t.getSecondDir().getClass()+" PENDIENTE");
				}
			}
		}

		result+="    mov %edx," + ResOff + "%(ebp) \n";

	}
	
	public void ASM_Imul(TripletCode t){
		VarLocation res = (VarLocation)t.getResult();
		int ResOff = res.getOffset();

		//si el 1er operando es varlocation
		if(t.getFirstDir() instanceof VarLocation){
			//System.out.println("varlocation1");
			VarLocation  x = (VarLocation)t.getFirstDir();
			int XOff=x.getOffset();
			result+="    mov " + XOff + "(%ebp) , %eax \n";
		}else{
			//sino, si es intliteral
			if(t.getFirstDir() instanceof IntLiteral){
				//System.out.println("int1");
				IntLiteral x=(IntLiteral) t.getFirstDir();
				result+="    mov $" + x.getStringValue() + ", %eax \n";
			}else{
				//si el operando es una operacion binaria o unaria
				if(t.getFirstDir() instanceof BinOpExpr || t.getFirstDir() instanceof UnaryOpExpr){
					//valor del operando en caso de ser un operacion binaria o unaria
					int firstOpValue=0;
					//si el 1er operando es una exp binaria, calculamos su valor
					if(t.getFirstDir() instanceof BinOpExpr){
						//System.out.println("binop1");
						//la obtenemos como operacion binaria
						BinOpExpr primer=(BinOpExpr) t.getFirstDir();	

						//primer y segundo operandos de la expression
						Expression primExpr=primer.getLeftOperand();
						Expression segExpr=primer.getRightOperand();

						//vemos que ambos operandos de la operacion binaria sean enteros
						if(primExpr.getType().equals(Type.INT) && segExpr.getType().equals(Type.INT)){
							firstOpValue=evaluateExpression(primer.toString());
							result+="    mov $" + firstOpValue + ", %eax \n";
						}else{
							System.out.println("{IMUL1}CASO BinOpExpr entre "+primExpr.getType()+" y "+segExpr.getType()+" pendiente");
						}

					}else{//caso contrario
						if(t.getFirstDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							//System.out.println("unary1");
							UnaryOpExpr primer=(UnaryOpExpr) t.getFirstDir();
							//si la expression es entera
							if(primer.getType().equals(Type.INT)){
								firstOpValue=evaluateExpression(primer.toString());
								result+="    mov $" + firstOpValue + ", %eax \n";
							}else{
								//System.out.println("nada1");
								System.out.println("{IMUL1}CASO UnaryOpExpr de "+primer.getType()+" pendiente");
							}
											
						}
					}
				}else{
				//caso floatliteral
					System.out.println("{IMUL1} CASO "+t.getFirstDir().getClass()+" PENDIENTE");
				}
			}
		}
		//si el 2do operando es varlocation
		if(t.getSecondDir() instanceof VarLocation){
			//System.out.println("varlocation2");
			VarLocation  y = (VarLocation)t.getSecondDir();
			int YOff=y.getOffset();
			result+="    mov " + YOff + "(%ebp) , %edx \n";
		}else{
			//sino, si es intliteral
			if(t.getSecondDir() instanceof IntLiteral){
				//System.out.println("int2");
				IntLiteral y=(IntLiteral) t.getSecondDir();
				result+="    mov $" + y.getStringValue() + ", %edx \n";
			}else{
				//si el operando es una operacion binaria o unaria
				if(t.getSecondDir() instanceof BinOpExpr || t.getSecondDir() instanceof UnaryOpExpr){
					//valor del operando en caso de ser binopexpr o unaryopexpr
					int secondOpValue=0;
					//si el 2do operando es una exp binaria, calculamos su valor
					if(t.getSecondDir() instanceof BinOpExpr){
						//System.out.println("binop2");
						//la obtenemos como operacion binaria
						BinOpExpr segunda=(BinOpExpr) t.getFirstDir();	

						//primer y segundo operandos de la expression
						Expression primExpr=segunda.getLeftOperand();
						Expression segExpr=segunda.getRightOperand();

						//vemos que ambos operandos de la operacion binaria sean enteros
						if(primExpr.getType().equals(Type.INT) && segExpr.getType().equals(Type.INT)){
							secondOpValue=evaluateExpression(segunda.toString());
							result+="    mov $" +secondOpValue+", %edx \n";
							result+="    imul %edx, %eax \n";
						}else{
							System.out.println("{IMUL2}CASO BinOpExpr entre "+primExpr.getType()+" y "+segExpr.getType()+" pendiente");
						}
						
					}else{//caso contrario es una expresion unaria
						if(t.getSecondDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							//System.out.println("unary2");
							UnaryOpExpr segunda=(UnaryOpExpr) t.getSecondDir();
							if(segunda.getType().equals(Type.INT)){
								secondOpValue=evaluateExpression(segunda.toString());
								result+="    mov $" +secondOpValue+", %edx \n";
								result+="    imul %edx, %eax \n";
							}else{
								//System.out.println("nada2");
								System.out.println("{IMUL2}CASO UnaryOpExpr de "+segunda.getType()+" pendiente");
							}

						}
					}
				}else{
				//caso float
				System.out.println("{IMUL2} CASO "+t.getSecondDir().getClass()+" PENDIENTE");
				}
			}
		}

		result+="    mov %eax," + ResOff + "%(ebp) \n";

	}	

	public void ASM_Idiv(TripletCode t){

		VarLocation res = (VarLocation)t.getResult();
		int ResOff = res.getOffset();

		//si el 1er operando es varlocation
		if(t.getFirstDir() instanceof VarLocation){
		VarLocation  x = (VarLocation)t.getFirstDir();
		int XOff=x.getOffset();
		result+="    mov " + XOff + "(%ebp) , %eax \n";
		}else{
			//sino, si es intliteral
			if(t.getFirstDir() instanceof IntLiteral){
				IntLiteral x=(IntLiteral) t.getFirstDir();
				result+="    mov $" + x.getStringValue() + ", %eax \n";
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
							result+="    mov $" + firstOpValue + ", %eax \n";
						}else{
							System.out.println("{DIV1} CASO "+primExpr.getType()+" y "+ segExpr.getType()+" PENDIENTE");
						}
						
					}else{//caso contrario
						if(t.getFirstDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							UnaryOpExpr primer=(UnaryOpExpr) t.getFirstDir();
							firstOpValue=evaluateExpression(primer.toString());

							result+="    mov $" + firstOpValue + ", %eax \n";
						}
					}
				}else{
				//caso floatliteral
					System.out.println("{DIV1} CASO "+t.getFirstDir().getClass()+" PENDIENTE");
				}
			}
		}
		//si el 2do operando es varlocation
		if(t.getSecondDir() instanceof VarLocation){
			VarLocation  y = (VarLocation)t.getSecondDir();
			int YOff=y.getOffset();
			result+="    mov " + YOff + "(%ebp) , %ecx \n";
		}else{
			//sino, si es intliteral
			if(t.getSecondDir() instanceof IntLiteral){
				IntLiteral y=(IntLiteral) t.getSecondDir();
				result+="    mov $" + y.getStringValue() + ", %ecx \n";
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
							result+="    mov $" +secondOpValue+", %ecx \n";
							result+="	 cltd\n+";
							result+="    idiv %ecx\n";
						}else{
							System.out.println("{DIV2} CASO "+primExpr.getType()+" y "+ segExpr.getType()+" PENDIENTE");
						}
						
					}else{//caso contrario es una expresion unaria
						if(t.getSecondDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
							UnaryOpExpr segunda=(UnaryOpExpr) t.getSecondDir();
							secondOpValue=evaluateExpression(segunda.toString());
							result+="    mov $" +secondOpValue+", %ecx \n";
							result+="	 cltd\n+"; 
							result+="    idiv %ecx\n";

						}
					}
				}else{
				//caso float
				System.out.println("{DIV2} CASO "+t.getSecondDir().getClass()+" PENDIENTE");
				}
			}
		}

		result+="    mov %ecx," + ResOff + "%(ebp) \n";
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
			        	result += "    movl	" + offset1 + "(%rbp), %eax\n";	
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
			        			System.out.println("{logic} FALTA CASO (1er param)" + t.getFirstDir().getClass());
			        		}
			        		
			        	}
			        }

			        //si el 2do operando es una VarLocation
			        if(t.getSecondDir() instanceof VarLocation){
			        	//obtenemos su offset
			        	VarLocation op=(VarLocation) t.getSecondDir();
			        	int offset2=op.getOffset();
			        	result += "    cmpl	" + offset2 + "(%rbp), %eax\n";	
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
			        			System.out.println("{logic} FALTA CASO (2do param)" + t.getSecondDir().getClass());
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
					result += "    movzbl %al, %eax\n";
					result += "    movl	%eax, " + res.getOffset() + "(%rbp)\n";
	}

	public void ASM_Non(TripletCode t){
		//si el operando es una VarLocation
        if(t.getFirstDir() instanceof VarLocation){
     		VarLocation op=(VarLocation) t.getFirstDir();
        	VarLocation res=(VarLocation) t.getResult();
        	//obtenemos sus offset y con el mismo trabajamos
        	int operandOffSet=op.getOffset();
        	int resOffSet=res.getOffset();

	        result += "    cmp $0, " + operandOffSet + "(%rbp) \n";
			result += "    sete %al \n";
			result += "    movzbl %al, %eax \n";
			result += "    mov %eax, " + resOffSet + "(%rbp) \n";

        }else{ //caso contrario debe ser un BoolLiteral
        	BoolLiteral op=(BoolLiteral) t.getFirstDir();
        	VarLocation res=(VarLocation) t.getResult();
        	//obtenemos sus offset y con el mismo trabajamos
        	int resOffSet=res.getOffset();
        	if (op.toString().equals("true")){//por convencion tomaremos 1 como true y 0 como false
        		result += "    cmp $0, " + 1 + "(%rbp) \n";	
        	}else{
        		result += "    cmp $0, " + 0 + "(%rbp) \n";
        	}
	        
			result += "    sete	%al \n";
			result += "    movzbl %al, %eax \n";
			result += "    mov %eax, " + resOffSet + "(%rbp) \n";
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

	        result += "    movl	" + operandOffSet + "(%rbp), %eax \n";
			result += "    negl	%eax \n";
			result += "    movl	%eax, " + resOffSet + "(%rbp) \n";

	    }else{ //caso contrario debe ser un Numero (int o float)
	    	VarLocation res=(VarLocation) t.getResult();
	    	//POR AHORA SOLO IMPLEMENTADO PARA INT
	    	if(t.getFirstDir() instanceof IntLiteral){
	    		IntLiteral op=(IntLiteral) t.getFirstDir();	
	        	//obtenemos sus offset y con el mismo trabajamos
	        	int resOffSet=res.getOffset();
	        	result += "    movl	$" + op.getRawValue() + ", %eax \n";
				result += "	   negl	%eax \n";
				result += "    movl	%eax, " + resOffSet + "(%rbp) \n";
	    	}else{
	    		System.out.println("{Unary_Minus}IMPLEMENTAR CASO -(FLOAT)");
	    	}
	    	/*
	    	if(t.getFirstDir() instanceof FloatLiteral){
	    		FloatLiteral op=(FloatLiteral) t.getFirstDir();	
	        	//obtenemos sus offset y con el mismo trabajamos
	        	int resOffSet=res.getOffset();
	        	result += "    movl		$" + op.getRawValue() + ", %eax \n";
				result += "negl		%eax \n";
				result += "    movl		%eax, " + resOffSet + "(%rbp) \n";
	    	}*/
	    	
	    	
	    }
	}

	public void ASM_Mod(TripletCode t){

		//si el 2do operando es una varlocation obtenemos su offset
		if(t.getSecondDir() instanceof VarLocation){
			VarLocation secOp=(VarLocation) t.getSecondDir();
			result += "    movl	" + secOp.getOffset() + "(%rbp), %eax \n";
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
					//System.out.println("SEGUNDA EXPR "+segunda+" pv: "+primerValor+" sv: "+segundoValor);
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
					result+="    mov $" +secondOpValue+", %eax \n";
				}else{//caso contrario es una expresion unaria
					if(t.getSecondDir() instanceof UnaryOpExpr){//si es una operacion unaria (menos unario)
						UnaryOpExpr segunda=(UnaryOpExpr) t.getSecondDir();
						secondOpValue=evaluateExpression(segunda.toString());
						result+="    mov $" +secondOpValue+", %eax \n";
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
			result += "    idivl " + firstOp.getOffset() + "(%rbp)\n";
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
					//System.out.println("PRIMERA EXPR "+primer+" pv: "+primerValor+" sv: "+segundoValor);
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
		result += "    movl	%edx, " + res.getOffset() + "(%rbp)\n";//en edx queda el resto de la division

	}

	public void ASM_Assing(TripletCode t){
		if(t.getFirstDir() instanceof VarLocation){
			VarLocation firstOp=(VarLocation) t.getFirstDir();
			result=result+"    mov " + firstOp.getOffset() + "(%rbp), %eax\n";
		}else{
			result=result+"    mov " + t.getFirstDir() + "(%rbp), %eax\n";
		}
		if(t.getResult() instanceof VarLocation){
			VarLocation res=(VarLocation) t.getResult();
			result=result+"    mov " + res.getOffset() + "(%rbp), %eax\n";
		}else{
			//casos del resultado, puede ser intliteral, boolliteral o floatliteral
			if(t.getResult() instanceof BoolLiteral){
				BoolLiteral res= (BoolLiteral) t.getResult();
			}
			if(t.getResult() instanceof IntLiteral){
				IntLiteral res= (IntLiteral) t.getResult();
			}
			if(t.getResult() instanceof FloatLiteral){
				FloatLiteral res= (FloatLiteral) t.getResult();
			}
			result=result+"    mov %eax, " + t.getResult() + "(%rbp)\n";
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
	    		result=result+ "."+t.getResult()+"\n"; 
	    	}
	    }
	}

	public void ASM_Cmp(TripletCode t){
		if(t.getSecondDir() instanceof VarLocation){
			VarLocation secondOp=(VarLocation)t.getSecondDir();
			result += "    mov " + secondOp.getOffset() + "(%rbp), %eax\n";	
		}else{
			result += "    mov " + t.getSecondDir() + "(%rbp), %eax\n";	
		}
		if(t.getFirstDir() instanceof VarLocation){
			VarLocation firstOp=(VarLocation)t.getFirstDir();
			result += "    cmp " + firstOp.getOffset() + "(%rbp), %eax\n";
		}else{
			result += "    cmp " + t.getFirstDir() + "(%rbp), %eax\n";
		}
	}

	public void ASM_Method_Decl(TripletCode t){
		Metodo m=(Metodo)t.getFirstDir();
		result += "    .globl	" + m.getName() + "\n";
		result += "    .type	" + m.getName() + ", @function \n";			
		result += m.getName() + ": \n";	
		/*Dejamos espacio para los parametros del metodo*/
		result += "    enter   $("+4 * m.getParametros().size() + "), $0 \n";
		result += "    push	%rbp\n";
		result += "    mov %rsp, %rbp\n";
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

			result += "    cmp	$0, " + op1.getOffset() + "(%rbp)\n";
			result += "    jne .L" +label1  + "\n";		
			result += "    cmp	$0, " + op2.getOffset() + "(%rbp)\n";
			result += "    je .L" + label1 + "\n";
			result += "    mov	$1, %eax\n";
			result += "    jmp .L" + label2 + "\n";
			result += ".L" + label1 + ":\n";
			result += "    movl	$0, %eax\n";
			result += "    jmp .L" + label3 + "\n";
			result += ".L" + label2 + ":\n";
			result += "    movl	%eax, " + res.getOffset() + "(%rbp)\n";
			result += ".L"+label3+":\n";
		}else{
			System.out.println("{Or}TRATAMIENTO PARA " + t.getFirstDir().getClass()+ " y "+ t.getSecondDir().getClass()+" PENDIENTE");
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

			result += "    cmp	$0, " + op1.getOffset() + "(%rbp)\n";
			result += "    je .L" +label1  + "\n";		
			result += "    cmp	$0, " + op2.getOffset() + "(%rbp)\n";
			result += "    je .L" + label1 + "\n";
			result += "    mov	$1, %eax\n";
			result += "    jmp .L" + label2 + "\n";
			result += ".L" + label1 + ":\n";
			result += "    movl	$0, %eax\n";
			result += "    jmp .L" + label3 + "\n";
			result += ".L" + label2 + ":\n";
			result += "    movl	%eax, " + res.getOffset() + "(%rbp)\n";
			result += ".L"+label3+":\n";

		}else{
			System.out.println("{And}TRATAMIENTO PARA " + t.getFirstDir().getClass()+ " y "+ t.getSecondDir().getClass()+" PENDIENTE");
		}
		
	}

	//registro de parametros de llamada a metodo
	public void ASM_Params(TripletCode t){
		//obtenemos la lista de parametros del metodo llamado
    	LinkedList<Expression> params=(LinkedList<Expression>) t.getResult();
    	//los parametros de agregan en orden inverso

    	for(int i=params.size()-1; i>=0; i--){
    		System.out.println("index: "+i+" tamaño: "+params.size());
    		//si el parametro es una VarLocation obtenemos su offset
    		if(params.get(i) instanceof VarLocation){
    			VarLocation v=(VarLocation) params.get(i);
    			if(i!=0){
    				result+="    movl "+v.getOffset()+" , "+((i-1)*4)+"(%esp)";		
    			}else{
    				result+="    movl "+v.getOffset()+" , (%esp)";	
    			}
    			
    		}else{//sino, debe ser un Literal o una llamada a metodo
    			//si no es una llamada a metodo (deberia ser un literal entonces)
    			if(!(params.get(i) instanceof MethodCallExpr)){
    				//caso IntLiteral
    				if(params.get(i) instanceof IntLiteral){
    					IntLiteral p=(IntLiteral) params.get(i);
    					if(i!=0){
    						result+="    movl $"+evaluateExpression(p.toString())+" , "+((i-1)*4)+"(%esp)";	
    					}else{
    						result+="    movl $"+evaluateExpression(p.toString())+" , (%esp)";	
    					}
    					
    				}else{
    					//caso BoolLiteral
	    				if(params.get(i) instanceof BoolLiteral){
	    					BoolLiteral p=(BoolLiteral) params.get(i);
	    					if(i!=0){
	    						result+="    movl $"+p.toString()+" , "+((i-1)*4)+"(%esp)";	
	    					}else{
	    						result+="    movl $"+p.toString()+" , (%esp)";
	    					}
	    					
	    				}else{
	    					//caso FloatLiteral
	    					if(params.get(i) instanceof FloatLiteral){
	    						System.out.println("{PARAM} CASO FLAOTLITERAL PENDIENTE");
	    					}else{
	    						//si el parametro es una operacion binaria
	    						if(params.get(i) instanceof BinOpExpr){
	    							BinOpExpr b=(BinOpExpr) params.get(i);
	    							Expression firstOp=b.getLeftOperand();
	    							Expression secOp=b.getRightOperand();
	    							//si es una binaria entre enteros
	    							if(firstOp.getType().equals(Type.INT) && secOp.getType().equals(Type.INT)){
	    								//la evaluamos
	    								int opValue=evaluateExpression(b.toString());
	    								if(i!=0){
				    						result+="    movl $"+opValue+" , "+((i-1)*4)+"(%esp)";	
				    					}else{
				    						result+="    movl $"+opValue+" , (%esp)";
				    					}
	    							}
	    						}else{
	    							//demas casos
    								System.out.println("{PARAM} FALTA CASO "+params.get(i).getClass());
	    						}
	    						
	    					}
	    					
	    				}
    				}
    			}else{
    				System.out.println("{PARAM} CASO METHODCALL PENDIENTE");
    			}		    			
    		}
    	}
	}
	//metodo que dada una lista de codigos de 3 direcciones genera el codigo assembly correspondiente
	public String generate(LinkedList<TripletCode> list){
		OrAndlabelInt=0;
		for(TripletCode t: list){
			System.out.println("procesando : . . . "+t);
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
			    	result=result+ "INCREMENT(+=)\n"; 
			    	break;
			    case DECREMENT:
			    	result+="\n";
			    	result=result+ "DECREMENT(-=)\n"; 
			    	break;
			    case LABEL:
			    	result+="\n";
			    	ASM_Label(t);
			    	break;
				case RETURN:
					result+="\n";
					if (t.getResult() != null) 
				 		result += "    mov " + t.getResult() + "(%rbp), %eax\n";
				 	else 
						result += "    mov $0, %eax\n";
				 	
			    	break;
			    case PARAM:
			    	result+="\n";
			    	result=result+ "PARAM\n";
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
				  	if (t.getResult() != null)
				  		result += "    movl %eax, " + t.getResult() + "(%rbp) \n";

			   		break;
			   	case EXTERNINVK:
			   		result+="\n";
			   		ExternInvkExpr mc=(ExternInvkExpr) t.getFirstDir();
			   		result += "    call " + mc.getId() + "\n";		
				  	if (t.getResult() != null)
				  		result += "    movl %eax, " + t.getResult() + "(%rbp) \n";

			   		break;
			   	case ARRAYACCESS:
			   		result+="\n";
			   		result=result+ "ARRAYACCESS\n"; 
			   		break;
			   	case METHODDECL:
			   		result+="\n";
		   			ASM_Method_Decl(t);
		   			break;
		   		case GLOBAL:
		   			result+="\n";
		   			if(t.getResult()==0){
		   				result+="    .comm "+t.getSecondDir()+","+4+"\n";	
		   			}else{
		   				int res=(int)t.getResult();
		   				result+="    .comm "+t.getSecondDir()+","+(4*res)+"\n";
		   			}	   			
		   			break;
			}
			System.out.println("finalizado.");
			System.out.println("");
		}
		return result;
	}
}
