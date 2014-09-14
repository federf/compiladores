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
public class BoolLiteral extends Literal {

    private boolean value;

    public BoolLiteral(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (value) {
            return "true";
        } else {
            return "false";
        }
    }
    
    @Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

    @Override
    public Type getType() {
        return Type.BOOLEAN; //To change body of generated methods, choose Tools | Templates.
    }

}
