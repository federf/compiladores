/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ir.ast.*;
/**
 *
 * @author fede
 */
public class TripletCode {
    
    //primer y segunda direccion
    protected Object firstDir, secondDir;
    //direccion de retorno
    protected VarLocation result;
    //operador
    protected TripletOperator operator;

    
 
public TripletCode(TripletOperator op, Object fD, Object sD, VarLocation res) {

 	operator = op;
 	firstDir = fD;
 	secondDir = sD;
 	result = res;

}

@Override
public String toString() {
 	
 	return "Operator: "+operator.toString() + ", firstOperator: "+ firstDir+", secondOperator: "+ secondDir + ", Result: "+ result.getId();
 
 }

}
