/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ast;

import ir.ASTVisitor;
import java.util.Objects;

/**
 *
 * @author fede
 */
public class UnaryOpExpr extends Expression {

    private UnaryOpType operator; //operator in the expr = expr operator expr
	private Expression operand; //right expression
	
	public UnaryOpExpr(UnaryOpType op, Expression r){
		operator = op;
		operand = r;
	}

	
	public UnaryOpType getOperator() {
		return operator;
	}

	public void setOperator(UnaryOpType operator) {
		this.operator = operator;
	}

	public Expression getOperand() {
		return operand;
	}

	public void setOperand(Expression Operand) {
		this.operand = Operand;
	}
	
	@Override
	public String toString() {
		return operator +""+ operand;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
