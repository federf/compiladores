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
    private Expression index;

    public ArrayLiteral(String id, Expression index, Type t) {
        this.id = id;
        this.index = index;
        this.type=t;
    }
    
    @Override
    public Type getType() {
        return type;
    }
    
    public void setType(Type t){
        this.type=t;
    }

    public String getId(){
        return this.id;
    }

    public Expression getIndex(){
        return this.index;
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }

    @Override
    public String toString() {
        return "ArrayLiteral{" + "id=" + id + ", index=" + index + '}';
    }
    
    
}
