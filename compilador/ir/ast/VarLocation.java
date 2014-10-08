package ir.ast;

import ir.ASTVisitor;

public class VarLocation extends Location {

    Type type;
    int size;
    int offset;
    
    static int off = -4;

    public static void resetOffset(){
        off = -4;
    }

    public VarLocation(String id, Type type, Expression expr, int size) {
        this.id=id;
        this.type = type;
        this.expr = expr;
        this.size = size;
        this.offset = off;

        off = off - 4;
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

    public int getOffset(){
        return this.offset;
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