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
public class StringLiteral  extends Literal{
	private String value;
	
	/*
	 * Constructor for int literal that takes a string as an input
	 * @param: String integer
	 */
	public StringLiteral(String val){
		value = val;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

    @Override
    public Type getType() {
        return Type.STRING;
    }

    @Override
    public String toString() {
        return "StringLiteral{" + "value=" + value + '}';
    }
    
    
}
