/*
	TripletOperator es un tipo enumerado que contiene
	los nombres de las operaciones que estan 
	permitidas en el codigo intermedio 
	generado por el compilador.
*/
public enum TripletOperator{
	PLUS, MINUS, MULTIPLY, DIVIDE, MOD, GE, LE, LEQ, GEQ, AND, OR, CEQ, NEQ /*Primer y Segundo parametro: operandos.
		Tercer parametro: Variable para resultado -OPERACIONES BINARIAS*/
 	, NON, UNARYMINUS /* Primer parametro: operando. Tercer parametro: Variable para resultado  - OPERACION UNARIA*/
 	, ASSIGN,INCREMENT,DECREMENT/* Primer parametro: Valor a asignar. Tercer parametro: Variable a ser asignada - ASIGNACIONES*/
 	, LABEL		  /* Tercer parametro: Nombre del label a crear (para las variables declaradas como "Tipo ID") */	
 	, RETURN 	  /* Tercer parametro: Variable con valor a retornar - RETURN*/
 	, PARAM 	  /* Tercer parametro: Variable con valor del parametro - PARAMETRO */
 	, CMP 		  /* Primer parametro: valor a comparar. Segundo parametro: valor a comparar*/
 	, GOTO /* Tercer parametro: Label a saltar - SALTO (GOTO salto incondicional) */
 	, ARRAYLABEL /*Primero parametro: tipo arreglo. Segundo parametro: tamaño. Tercer Parametro: nombre del arreglo.(para las var. declaradas como "Tipo ID[expr]") */;
 	//CREO DEBERIAMOS TENER PARA LAS LLAMADAS A METODOS TANTO EXTERNOS COMO INTERNOS 
 	@Override
	public String toString() {
		switch(this) {
			case PLUS:
				return "PLUS(+)";
			case MINUS:
				return "MINUS(-)";
		    case MULTIPLY:
		        return "MULTIPLY(*)";
		    case DIVIDE:
		        return "DIVIDE(/)";
		    case MOD:
		        return "MOD(%)";
		    case LE:
		        return "LE(<)";
		    case LEQ:
		        return "LEQ(<=)";
		    case GE:
		        return "GE(>)";
		    case GEQ:
		        return "GEQ(>=)";
		    case NON:
		        return "NON(!)";
			case UNARYMINUS:
		        return "UNARYMINUS(-expr)";
		    case AND:
		        return "AND(&&)";
		    case CEQ:
		        return "CEQ(==)";
		    case NEQ:
		        return "NEQ(!=)";
			case ASSIGN:
		        return "ASSIGN(=)";
		    case INCREMENT:
		    	return "INCREMENT(+=)";
		    case DECREMENT:
		    	return "DECREMENT(-=)";
		    case LABEL:
		    	return "LABEL";
			case RETURN:
		    	return "RETURN";
		    case PARAM:
		    	return "PARAM";
		    case CMP:
		    	return "CMP";
		    case GOTO:
		    	return "GOTO";
		    case OR:
		    	return "OR(||)";
		    case ARRAYLABEL:
		    	return "array[]";

		}
		return null;
	}

}