/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ir.ast;

/**
 *
 * @author fede
 */

import ir.ASTVisitor;

public class SemiColonStmt extends Statement {
	public SemiColonStmt(){};

	public String toString(){
		return ";\n";		
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
	
}
