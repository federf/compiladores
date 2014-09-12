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
public class ForStmt extends LoopStmt{
    private Expression assignExpr;
	private Expression condition;
	private String id;
		
	public ForStmt( String id, Expression cond, Expression ass, Block block) {
		this.condition = cond;
		this.block = block;
		this.assignExpr = ass;
		this.id = id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public Expression getCondition() {
		return condition;
	}

	public void setCondition(Expression condition) {
		this.condition = condition;
	}

	public Expression getAssignExpr() {
		return assignExpr;
	}

	public void setAssignExpr(Expression assign) {
		this.assignExpr = assign;
	}
	
	@Override
	public String toString() {
		String forS = "for " + id + "=" + assignExpr + ", " + condition + '\n' + block.toString();
		
		return forS;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
