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
public enum UnaryOpType {
    MINUS, // - expr
    NON; // ! expr

    @Override
    public String toString() {
        switch(this){
            case MINUS:
                return "-";
            case NON:
                return "!";
        }
        return null;
    }
    
    
}
