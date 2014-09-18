/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ir.ast;
import ir.ASTVisitor;
import java.util.LinkedList;

/**
 *
 * @author fede
 */
public class MethodCallExpr extends Expression{

    String name;
	private LinkedList<Expression> args;
	
    //constructor de clase, recibe como parametros el nombre y tipo de retorno del metodo
    //junto a los parametros actuales
	public MethodCallExpr( String name, LinkedList<Expression> a) {
        this.name=name;
		this.args = a;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Expression> getArgs() {
        return args;
    }

    public void setArgs(LinkedList<Expression> args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "MethodCallExpr{" + "name=" + name + ", args=" + args + '}';
    }
	
	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}
