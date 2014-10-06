import java.util.*;
public class AssemblyCodeGenerator{
	public AssemblyCodeGenerator(){

	}

	//metodo que dada una lista de codigos de 3 direcciones genera el codigo assembly correspondiente
	public String generate(LinkedList<TripletCode> list){
		String result="";
		for(TripletCode t: list){
			switch(t.getOperator()){
				case PLUS:
					result=result+ "PLUS(+)"; 
					break;
				case MINUS:
					result=result+ "MINUS(-)"; 
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
			        result=result+ "ASSIGN(=)"; 
			        break;
			    case INCREMENT:
			    	result=result+ "INCREMENT(+=)"; 
			    	break;
			    case DECREMENT:
			    	result=result+ "DECREMENT(-=)"; 
			    	break;
			    case LABEL:
			    	result=result+ "LABEL"; 
			    	break;
				case RETURN:
			    	result=result+ "RETURN"; 
			    	break;
			    case PARAM:
			    	result=result+ "PARAM"; 
			    	break;
			    case CMP:
			    	result=result+ "CMP"; 
			    	break;
			    case JMP:
			    	result=result+ "JMP"; 
			    	break;
			    case OR:
			    	result=result+ "OR(||)"; 
			    	break;
			    case ARRAYLABEL:
			    	result=result+ "array[]"; 
			    	break;
			   	case JNE:
			   		result=result+ "JNE"; 
			   		break;
			   	case JNL:
			   		result=result+ "JNL"; 
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