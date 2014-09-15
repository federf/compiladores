package ir.ast;

import ir.ASTVisitor;

public class VarLocation extends Location {

    Type type;
    String value;
    int size;

    public VarLocation(String id, Type type, String value, int size) {
        this.id=id;
        this.type = type;
        this.value = value;
        this.size = size;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    

    @Override
    public String toString() {
        return "VarLocation{" +"name="+ id +"type=" + type + ", value=" + value + ", size=" + size + '}';
    }

    

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
}
