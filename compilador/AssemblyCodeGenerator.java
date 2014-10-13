import java.util.*;
import ir.ast.*;
public class AssemblyCodeGenerator{
	public AssemblyCodeGenerator(){

	}

	String result="";

	public void ASM_Add(TripletCode t){
		
		VarLocation res = (VarLocation)t.getResult();
		int ResOff = res.getOffset();

		if (t.getFirstDir() instanceof VarLocation && t.getSecondDir() instanceof VarLocation) {
			VarLocation  x = (VarLocation)t.getFirstDir();
			VarLocation  y = (VarLocation)t.getSecondDir();

			int XOff = x.getOffset();
			int YOff = y.getOffset();

			result = result +(

			"mov " + XOff + "(%ebp) , %eax \n"+
			"mov " + YOff + "(%ebp), %edx \n"+
			"add %eax, %edx \n"+
			"mov %edx," + ResOff + "%(ebp) \n");

		}

		if (t.getFirstDir() instanceof VarLocation && !(t.getSecondDir() instanceof VarLocation)) {
			VarLocation  x = (VarLocation)t.getFirstDir();
			IntLiteral  y = (IntLiteral)t.getSecondDir();

			int XOff = x.getOffset();

			result = result +(

			"mov " + XOff + "(%ebp) , %eax \n"+
			"add $" +y.getStringValue() + ", %eax \n"+
			"mov %edx," + ResOff + "%(ebp) \n");

		}

		if ((t.getFirstDir() instanceof VarLocation) && t.getSecondDir() instanceof VarLocation) {
			IntLiteral  x = (IntLiteral)t.getFirstDir();
			VarLocation  y = (VarLocation)t.getSecondDir();

			int YOff = y.getOffset();

			result = result +(

			"mov " + YOff + "(%ebp), %eax \n"+
			"add $" +x.getStringValue() + ", %eax \n"+
			"mov %edx," + ResOff + "%(ebp) \n");

		}

		if (!(t.getFirstDir() instanceof VarLocation) && !(t.getSecondDir() instanceof VarLocation)) {
			IntLiteral  x = (IntLiteral)t.getFirstDir();
			IntLiteral  y = (IntLiteral)t.getSecondDir();

			result = result +(

			"mov $" + x.getStringValue() + "%eax \n"+
			"mov $" + y.getStringValue() + "%edx \n"+
			"add %eax, %edx \n"+
			"mov %edx," + ResOff + "%(ebp) \n");
		}
	}

	public void ASM_Sub(TripletCode t){

		VarLocation res = (VarLocation)t.getResult();
		int ResOff = res.getOffset();
		
		if (t.getFirstDir() instanceof VarLocation && t.getSecondDir() instanceof VarLocation) {
			VarLocation  x = (VarLocation)t.getFirstDir();
			VarLocation  y = (VarLocation)t.getSecondDir();

			int XOff = x.getOffset();
			int YOff = y.getOffset();

			result = result +(

			"mov " + XOff + "(%ebp) , %eax \n"+
			"mov " + YOff + "(%ebp), %edx \n"+
			"sub %eax, %edx \n"+
			"mov %edx," + ResOff + "%(ebp) \n");

		}

		if (t.getFirstDir() instanceof VarLocation && !(t.getSecondDir() instanceof VarLocation)) {
			VarLocation  x = (VarLocation)t.getFirstDir();
			IntLiteral  y = (IntLiteral)t.getSecondDir();

			int XOff = x.getOffset();

			result = result +(

			"mov " + XOff + "(%ebp) , %eax \n"+
			"mov $" + y.getStringValue() + ", %edx\n"+
			"sub %edx, %eax \n"+
			"mov %edx," + ResOff + "%(ebp) \n");

		}

		if ((t.getFirstDir() instanceof VarLocation) && t.getSecondDir() instanceof VarLocation) {
			IntLiteral  x = (IntLiteral)t.getFirstDir();
			VarLocation  y = (VarLocation)t.getSecondDir();

			int YOff = y.getOffset();

			result = result +(

			"mov " + YOff + "(%ebp), %eax\n"+
			"mov $" + x.getStringValue() + ", %edx\n"+
			"sub %edx, %eax\n"+
			"mov %edx," + ResOff + "%(ebp)\n");

		}

		if (!(t.getFirstDir() instanceof VarLocation) && !(t.getSecondDir() instanceof VarLocation)) {
			IntLiteral  x = (IntLiteral)t.getFirstDir();
			IntLiteral  y = (IntLiteral)t.getSecondDir();

			result = result +(

			"mov $" + x.getStringValue() + "%eax\n"+
			"mov $" + y.getStringValue() + "%edx\n"+
			"sub %eax, %edx\n"+
			"mov %edx," + ResOff + "%(ebp)\n");

		}
	}
	
	public void ASM_Imul(TripletCode t){

		VarLocation res = (VarLocation)t.getResult();
		int ResOff = res.getOffset();
		
		if (t.getFirstDir() instanceof VarLocation && t.getSecondDir() instanceof VarLocation) {
			VarLocation  x = (VarLocation)t.getFirstDir();
			VarLocation  y = (VarLocation)t.getSecondDir();

			int XOff = x.getOffset();
			int YOff = y.getOffset();

			result = result +(

			"mov " + XOff + "(%ebp) , %eax \n"+
			"imul" + YOff + "(%ebp), %eax \n"+
			"mov %eax," + ResOff + "%(ebp) \n");

		}

		if (t.getFirstDir() instanceof VarLocation && !(t.getSecondDir() instanceof VarLocation)) {
			VarLocation  x = (VarLocation)t.getFirstDir();
			IntLiteral  y = (IntLiteral)t.getSecondDir();

			int XOff = x.getOffset();

			result = result +(

			"mov " + XOff + "(%ebp) , %eax \n"+
			"mov $" + y.getStringValue() + ", %edx\n"+
			"imul %edx, %eax \n"+
			"mov %eax," + ResOff + "%(ebp) \n");

		}

		if ((t.getFirstDir() instanceof VarLocation) && t.getSecondDir() instanceof VarLocation) {
			IntLiteral  x = (IntLiteral)t.getFirstDir();
			VarLocation  y = (VarLocation)t.getSecondDir();

			int YOff = y.getOffset();

			result = result +(

			"mov " + YOff + "(%ebp), %eax\n"+
			"mov $" + x.getStringValue() + ", %edx\n"+
			"imul %edx, %eax\n"+
			"mov %eax," + ResOff + "%(ebp)\n");

		}

		if (!(t.getFirstDir() instanceof VarLocation) && !(t.getSecondDir() instanceof VarLocation)) {
			IntLiteral  x = (IntLiteral)t.getFirstDir();
			IntLiteral  y = (IntLiteral)t.getSecondDir();

			result = result +(

			"mov $" + x.getStringValue() + "%eax\n"+
			"mov $" + y.getStringValue() + "%edx\n"+
			"imul %edx, %eax\n"+
			"mov %eax," + ResOff + "%(ebp)\n");

		}
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
			        	result += "movl	" + offset1 + "(%rbp), %eax\n";	
			        }else{ //caso contrario debe ser Int o Float
			        	//caso int
			        	if(t.getFirstDir() instanceof IntLiteral){
			        		IntLiteral op1=(IntLiteral) t.getFirstDir();
			        		result += "movl	" + op1.getRawValue() + "(%rbp), %eax\n";
			        	}else{//caso float
			        		FloatLiteral op1=(FloatLiteral) t.getFirstDir();
			        		result += "movl	" + op1.getRawValue() + "(%rbp), %eax\n";
			        	}
			        }

			        //si el 2do operando es una VarLocation
			        if(t.getSecondDir() instanceof VarLocation){
			        	//obtenemos su offset
			        	VarLocation op=(VarLocation) t.getSecondDir();
			        	int offset2=op.getOffset();
			        	result += "cmpl	" + offset2 + "(%rbp), %eax\n";	
			        }else{ //caso contrario debe ser Int o Float
			        	//caso int
			        	if(t.getSecondDir() instanceof IntLiteral){
			        		IntLiteral op2=(IntLiteral) t.getSecondDir();
			        		result += "cmpl	" + op2.getRawValue() + "(%rbp), %eax\n";
			        	}else{//caso float
			        		FloatLiteral op2=(FloatLiteral) t.getSecondDir();
			        		result += "cmpl	" + op2.getRawValue() + "(%rbp), %eax\n";
			        	}
			        }
			        //case de la operacion logica 
			        switch(logic){
			        	case LE:
			        		result += "setl	%al\n";
			        		break;
			        	case LEQ:
			        		result += "setle %al\n";
			        		break;
			        	case GE:
			        		result += "setg	%al\n";
			        		break;
			        	case GEQ:
			        		result += "setge %al\n";
			        		break;
			        	case CEQ:
			        		result += "sete %al\n";
			        		break;
			        	case NEQ:
			        		result += "setgne %al\n";
			        		break;
			        }
					result += "movzbl %al, %eax\n";
					result += "movl	%eax, " + res.getOffset() + "(%rbp)\n";
	}

	public void ASM_Non(TripletCode t){
		//si el operando es una VarLocation
        if(t.getFirstDir() instanceof VarLocation){
     		VarLocation op=(VarLocation) t.getFirstDir();
        	VarLocation res=(VarLocation) t.getResult();
        	//obtenemos sus offset y con el mismo trabajamos
        	int operandOffSet=op.getOffset();
        	int resOffSet=res.getOffset();

	        result += "cmp $0, " + operandOffSet + "(%rbp) \n";
			result += "sete %al \n";
			result += "movzbl %al, %eax \n";
			result += "mov %eax, " + resOffSet + "(%rbp) \n";

        }else{ //caso contrario debe ser un BoolLiteral
        	BoolLiteral op=(BoolLiteral) t.getFirstDir();
        	VarLocation res=(VarLocation) t.getResult();
        	//obtenemos sus offset y con el mismo trabajamos
        	int resOffSet=res.getOffset();

	        result += "cmp $0, " + op.toString() + "(%rbp) \n";
			result += "sete	%al \n";
			result += "movzbl %al, %eax \n";
			result += "mov %eax, " + resOffSet + "(%rbp) \n";
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

	        result += "movl	" + operandOffSet + "(%rbp), %eax \n";
			result += "negl	%eax \n";
			result += "movl	%eax, " + resOffSet + "(%rbp) \n";

	    }else{ //caso contrario debe ser un Numero (int o float)
	    	VarLocation res=(VarLocation) t.getResult();
	    	//POR AHORA SOLO IMPLEMENTADO PARA INT
	    	if(t.getFirstDir() instanceof IntLiteral){
	    		IntLiteral op=(IntLiteral) t.getFirstDir();	
	        	//obtenemos sus offset y con el mismo trabajamos
	        	int resOffSet=res.getOffset();
	        	result += "movl	" + op.getRawValue() + "(%rbp), %eax \n";
				result += "negl	%eax \n";
				result += "movl	%eax, " + resOffSet + "(%rbp) \n";
	    	}else{
	    		System.out.println("IMPLEMENTAR CASO -(FLOAT)");
	    	}
	    	/*
	    	if(t.getFirstDir() instanceof FloatLiteral){
	    		FloatLiteral op=(FloatLiteral) t.getFirstDir();	
	        	//obtenemos sus offset y con el mismo trabajamos
	        	int resOffSet=res.getOffset();
	        	result += "movl		" + op.getRawValue() + "(%rbp), %eax \n";
				result += "negl		%eax \n";
				result += "movl		%eax, " + resOffSet + "(%rbp) \n";
	    	}*/
	    	
	    	
	    }
	}
	//metodo que dada una lista de codigos de 3 direcciones genera el codigo assembly correspondiente
	public String generate(LinkedList<TripletCode> list){
	
		for(TripletCode t: list){

			switch(t.getOperator()){
				
				case PLUS:

					ASM_Add(t);
					break;

				case MINUS:

					ASM_Sub(t);
					break;

			    case MULTIPLY:
			        ASM_Imul(t); 
			        break;

			    case DIVIDE:
			        result=result+ "DIVIDE(/)"; 
			        break;
			    case MOD:
			        result=result+ "MOD(%)"; 
			        break;
			    case LE:
			      	ASM_logic(t, t.getOperator());	
			        break;
			    case LEQ:
			        ASM_logic(t, t.getOperator());	
			        break;
			    case GE:
			        ASM_logic(t, t.getOperator());	
			        break;
			    case GEQ:
			        ASM_logic(t, t.getOperator());	
			        break;
			    case NON: 
			    	ASM_Non(t);
			        break;
				case UNARYMINUS:
			        ASM_Unary_Minus(t);
			        break;
			    case AND:
			        result=result+ "AND(&&)"; 
			        break;
			    case CEQ:
			        ASM_logic(t, t.getOperator());
			        break;
			    case NEQ:
			        ASM_logic(t, t.getOperator());
			        break;
				case ASSIGN:
			        result=result+"mov " + t.getFirstDir() + "(%rbp), %eax\n"+
								"mov %eax, " + t.getResult() + "(%rbp)\n";
			        break;
			    case INCREMENT:
			    	result=result+ "INCREMENT(+=)"; 
			    	break;
			    case DECREMENT:
			    	result=result+ "DECREMENT(-=)"; 
			    	break;
			    case LABEL:
			    	result=result+ "."+t.getResult()+"\n"; 
			    	break;
				case RETURN:
					if (t.getResult() != null) 
				 		result += "mov " + t.getResult() + "(%rbp), %eax\n";
				 	else 
						result += "mov $0, %eax\n";
				 	result += "leave\n";
					result += "ret\n";
			    	break;
			    case PARAM:
			    	result=result+ "PARAM"; 
			    	break;
			    case CMP:
			    	result += "mov " + t.getSecondDir() + "(%rbp), %eax\n";
					result += "cmp " + t.getFirstDir() + "(%rbp), %eax\n";
			    	break;
			 	case JMP:
			    	result=result+ "jmp "+t.getResult()+"\n"; 
			    	break;
			    case OR:
			    	result=result+ "OR(||)"; 
			    	break;
			    case ARRAYLABEL:
			    	result=result+ "array[]"; 
			    	break;
			   	case JNE:
			   		result=result+ "jne "+t.getResult()+"\n"; 
			   		break;
			   	case JNL:
			   		result=result+ "jnl "+t.getResult()+"\n"; 
			   		break;
			   	case METHODCALL:
			   		result += "call 	" + t.getFirstDir() + "\n";		
				  	if (t.getResult() != null)
				  		result += "movl 	%eax, " + t.getResult() + "(%rbp) \n";

			   		break;
			   	case EXTERNINVK:
			   		result=result+ "EXTERNINVK"; 
			   		break;
			   	case ARRAYACCESS:
			   		result=result+ "ARRAYACCESS"; 
			   		break;
			   	case METHODDECL:
		   			result=result+ "METHODDECL";

		   			Metodo m=(Metodo)t.getFirstDir();

		   			result += ".globl	" + m.getName() + "\n";
					result += ".type	" + m.getName() + ", @function \n";			
					result += m.getName() + ": \n";	
					/*Dejamos espacio para los parametros del metodo*/
					result += "enter   $(4 * " + m.getParametros().size() + "), $0 \n";
					result += "push	%rbp\n";
					result += "mov %rsp, %rbp\n";
		   			break;
			}
		}
		return result;
	}
}
