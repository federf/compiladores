/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ir.ast;

import ir.ASTVisitor;
import java.util.LinkedList;

/**
 *
 * @author fede
 */
public class ExternInvkExpr extends MethodCall{
    protected LinkedList<Expression> parameters;
	
    //constructor de clase, recibe el id, los parametros del metodo invocado y el tipo que retorna
	public ExternInvkExpr (String id, LinkedList<Expression> par, Type t){
	    this.id = id;	
	    type = t;
	    parameters = par;
	}
    
	public void setParameters(LinkedList<Expression> par) {
		this.parameters = par;
	}
	
	public LinkedList<Expression> getParameters() {
		return parameters;
	}
	
	public void addParamaters(Expression e) {
	    parameters.add(e);
	}
	
	@Override
	public String toString() {
		String methodString = id+"(";
		
	    for (Expression e: parameters) {
			methodString += e.toString()+", ";
		}
		
		if (methodString.length() > 0) methodString = methodString.substring(0, methodString.length() - 2); // remove last comma
		methodString += ")";
		return methodString; 
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}