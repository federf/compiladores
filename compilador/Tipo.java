/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bruno
 */
public enum Tipo {

    INT,
    FLOAT,
    BOOLEAN,
    VOID,
    INTARRAY,
    BOOLARRAY,
    FLOATARRAY,
    UNDEFINED;

    @Override
    public String toString() {
        switch (this) {
            case INT:
                return "int";
            case FLOAT:
                return "float";
            case BOOLEAN:
                return "boolean";
            case VOID:
                return "void";
            case INTARRAY:
                return "int[]";
            case FLOATARRAY:
                return "float[]";
            case BOOLARRAY:
                return "boolean[]";
            case UNDEFINED:
                return "undefined";
        }
        return null;

    }
}
