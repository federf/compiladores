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
public class ArrayLiteral extends Literal{
    
    private String id;
    private int size;

    public ArrayLiteral(String id, int size, Type t) {
        this.id = id;
        this.size = size;
        this.type=t;
    }
    
    @Override
    public Type getType() {
        return type;
    }
    
    public void setType(Type t){
        this.type=t;
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
