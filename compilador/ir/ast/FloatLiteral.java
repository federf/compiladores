/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ir.ast;

import ir.ASTVisitor;

/**
 *
 * @author fede NO ESTOY SEGURO SI HACE FALTA
 */
public class FloatLiteral extends Literal{

    private String rawValue;
	private Float value;
	
	/*
	 * Constructor for int literal that takes a string as an input
	 * @param: String float
	 */
	public FloatLiteral(String val){
		rawValue = val; // Will convert to int value in semantic check
		value = null;
	}

	public String getStringValue() {
		return rawValue;
	}

	public void setStringValue(String stringValue) {
		this.rawValue = stringValue;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
	public String getRawValue() {
		return rawValue;
	}

	public void setRawValue(String rawValue) {
		this.rawValue = rawValue;
	}

	@Override
	public String toString() {
		return rawValue;
	}
    

    @Override
    public Type getType() {
        return Type.FLOAT;
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
