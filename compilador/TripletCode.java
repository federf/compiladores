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
    protected Object operator;

    
 
public TripletCode(Object op, Object fD, Object sD, VarLocation res) {

 	operator = op;
 	firstDir = fD;
 	secondDir = sD;
 	result = res;

}

@Override
public String toString() {
 	
 	return "Operator: " + ", firstOperator: "+ firstOperator ", secondOperator: "+ secondOperator + ", Result: "+ result;
 
 }

}
