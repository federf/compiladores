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

			"mov" + XOff + "(%ebp) , %eax \n"+
			"mov" + YOff + "(%ebp), %edx \n"+
			"add %eax, %edx \n"+
			"mov %edx," + ResOff + "%(ebp) \n");

		}

		if (t.getFirstDir() instanceof VarLocation && !(t.getSecondDir() instanceof VarLocation)) {
			VarLocation  x = (VarLocation)t.getFirstDir();
			IntLiteral  y = (IntLiteral)t.getSecondDir();

			int XOff = x.getOffset();

			result = result +(

			"mov" + XOff + "(%ebp) , %eax \n"+
			"add $" +y.getStringValue() + ", %eax \n"+
			"mov %edx," + ResOff + "%(ebp) \n");

		}

		if ((t.getFirstDir() instanceof VarLocation) && t.getSecondDir() instanceof VarLocation) {
			IntLiteral  x = (IntLiteral)t.getFirstDir();
			VarLocation  y = (VarLocation)t.getSecondDir();

			int YOff = y.getOffset();

			result = result +(

			"mov" + YOff + "(%ebp), %eax \n"+
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

			"mov" + XOff + "(%ebp) , %eax \n"+
			"mov" + YOff + "(%ebp), %edx \n"+
			"sub %eax, %edx \n"+
			"mov %edx," + ResOff + "%(ebp) \n");

		}

		if (t.getFirstDir() instanceof VarLocation && !(t.getSecondDir() instanceof VarLocation)) {
			VarLocation  x = (VarLocation)t.getFirstDir();
			IntLiteral  y = (IntLiteral)t.getSecondDir();

			int XOff = x.getOffset();

			result = result +(

			"mov" + XOff + "(%ebp) , %eax \n"+
			"mov $" + y.getStringValue() + ", %edx\n"+
			"sub %edx, %eax \n"+
			"mov %edx," + ResOff + "%(ebp) \n");

		}

		if ((t.getFirstDir() instanceof VarLocation) && t.getSecondDir() instanceof VarLocation) {
			IntLiteral  x = (IntLiteral)t.getFirstDir();
			VarLocation  y = (VarLocation)t.getSecondDir();

			int YOff = y.getOffset();

			result = result +(

			"mov" + YOff + "(%ebp), %eax \n"+
			"mov $" + x.getStringValue() + ", %edx\n"+
			"sub %edx, %eax \n"+
			"mov %edx," + ResOff + "%(ebp) \n");

		}

		if (!(t.getFirstDir() instanceof VarLocation) && !(t.getSecondDir() instanceof VarLocation)) {
			IntLiteral  x = (IntLiteral)t.getFirstDir();
			IntLiteral  y = (IntLiteral)t.getSecondDir();

			result = result +(

			"mov $" + x.getStringValue() + "%eax \n"+
			"mov $" + y.getStringValue() + "%edx \n"+
			"sub %eax, %edx \n"+
			"mov %edx," + ResOff + "%(ebp) \n");

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
			        result=result+ "MULTIPLY(*)"; 
			        break;
			    case DIVIDE:
			        result=result+ "DIVIDE(/)"; 
			        break;
			    case MOD:
			        result=result+ "MOD(%)"; 
			        break;
			    case LE:
			        result=result+ "LE(<)"; 
			        break;
			    case LEQ:
			        result=result+ "LEQ(<=)"; 
			        break;
			    case GE:
			        result=result+ "GE(>)"; 
			        break;
			    case GEQ:
			        result=result+ "GEQ(>=)"; 
			        break;
			    case NON:
			        result=result+ "NON(!)"; 
			        break;
				case UNARYMINUS:
			        result=result+ "UNARYMINUS(-expr)"; 
			        break;
			    case AND:
			        result=result+ "AND(&&)"; 
			        break;
			    case CEQ:
			        result=result+ "CEQ(==)"; 
			        break;
			    case NEQ:
			        result=result+ "NEQ(!=)"; 
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
			   		result=result+ "METHODCALL"; 
			   		break;
			   	case EXTERNINVK:
			   		result=result+ "EXTERNINVK"; 
			   		break;
			   	case ARRAYACCESS:
			   		result=result+ "ARRAYACCESS"; 
			   		break;
			}
		}
		return result;
	}
}
