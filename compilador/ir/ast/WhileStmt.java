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
public class WhileStmt extends LoopStmt {
    private Expression condition;
	
	public WhileStmt(Expression cond, Block block) {
		this.condition = cond;
		this.block = (Block) block;
	}

	public Expression getCondition() {
		return condition;
	}

	public void setCondition(Expression condition) {
		this.condition = condition;
	}
	
	@Override
	public String toString() {
		String rtn = "while " + condition + '\n' + block.toString();
		
		return rtn;
	}

	//@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
