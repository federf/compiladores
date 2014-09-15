package ir.ast;

public enum Type {

    INT,
    INTARRAY,
    FLOAT,
    FLOATARRAY,
    BOOLEAN,
    BOOLARRAY,
    VOID,
    STRING,
    STRINGARRAY,
    UNDEFINED;

    @Override
    public String toString() {
        switch (this) {
            case INT:
                return "int";
            case VOID:
                return "void";
            case UNDEFINED:
                return "undefined";
            case INTARRAY:
                return "int[]";
            case FLOAT:
                return "float";
            case FLOATARRAY:
                return "float[]";
            case BOOLEAN:
                return "boolean";
            case BOOLARRAY:
                return "boolean[]";
            case STRING:
                return "string";
            case STRINGARRAY:
                return "string[]";
        }

        return null;
    }

    public boolean isArray() {
        if ((this == Type.INTARRAY) || (this == Type.FLOATARRAY) || (this == Type.BOOLARRAY) || (this == Type.STRINGARRAY)) {
            return true;
        }

        return false;
    }
    
    public boolean equals(Type t){
        return (this==t);
    }
}
