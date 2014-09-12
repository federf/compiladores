/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ir.ast;
import ir.ASTVisitor;

/**
 *
 * @author fede
 */


public class BreakStmt extends Statement {

	@Override
	public String toString() {
			return "break";
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
