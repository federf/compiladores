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
public abstract class MethodCallExpr extends Expression{
    protected String id;
		
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
