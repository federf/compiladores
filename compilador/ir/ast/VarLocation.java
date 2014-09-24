package ir.ast;

import ir.ASTVisitor;

public class VarLocation extends Location {

    Type type;
    int size;

    public VarLocation(String id, Type type, Expression expr, int size) {
        this.id=id;
        this.type = type;
        this.expr = expr;
        this.size = size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    public Type getType(){
        return this.type;
    }

    public void setType(Type t){
        this.type=t;
    }

    @Override
    public String toString() {
        return "VarLocation{" +"name="+ id +", type=" + type + ", expr=" + expr + ", size=" + size + '}';
    }

    

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
}