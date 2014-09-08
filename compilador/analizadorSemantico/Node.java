/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * clase que implementa un nodo para el arbol que implementara la tabla de simbolos del analizador 
 * semantico
 */
package compilador.analizadorSemantico;

import java.util.LinkedList;

/**
 * @author fede
 */
public class Node {

    //lista que registra las variables declaradas
    LinkedList<Simbolo> variables;
    //lista que registra informacion de los metodos declarados
    LinkedList<Metodo> metodos;
    //lista de hijos (niveles declarados dentro del mismo)
    LinkedList<Node> hijos;
    //nodo padre del nodo corriente
    Node padre;

    // constructor de clase para raiz
    public Node() {
        variables = new LinkedList();
        metodos = new LinkedList();
        hijos = new LinkedList();
        padre = null;
    }

    //constructor alternativo
    public Node(Node p) {
        variables = new LinkedList();
        metodos = new LinkedList();
        hijos = new LinkedList();
        padre = p;
    }

    public LinkedList<Simbolo> getVariables() {
        return variables;
    }

    public LinkedList<Metodo> getMetodos() {
        return metodos;
    }

    public LinkedList<Node> getHijos() {
        return hijos;
    }

    public Node getPadre() {
        return padre;
    }

    public void setPadre(Node padre) {
        this.padre = padre;
    }

    //metodo que dado un nodo lo agrega como hijo del nodo corriente
    public void AddHijo(Node n) {
        this.hijos.add(n);
    }

    //metodo que retorna true si el nodo corriente es una hoja (no tiene hijos)
    public boolean esHoja() {
        return (this.hijos.size() == 0);
    }

    //metodo que retorna true si el nodo corriente es nodo raiz (no tiene nodo padre)
    public boolean esRaiz() {
        return this.padre == null;
    }

    @Override
    public String toString() {
        String result = "Nodo: \nVariables: ";
        for (int i = 0; i < variables.size(); i++) {
            result = result + " " + variables.get(i).toString();
        }
        result = result + "\nMetodos: ";
        for (int i = 0; i < metodos.size(); i++) {
            result = result + " " + metodos.get(i).toString();
        }
        return result;
    }

    //metodo que permite agregar un metodo a la lista de metodos del nodo
    public void addMetodo(Metodo m) {
        if (m != null) {
            this.metodos.add(m);
        }
    }

    //metodo que permite agregar una variable a la lista de variables del nodo
    public void addVariable(Simbolo s) {
        if (s != null) {
            this.variables.add(s);
        }
    }
    
    //metodo que dado un simbolo verifica si existe o no en el nodo corriente, y en caso de existir lo retornar
    public Simbolo getSimbolo(Simbolo s) {
        Simbolo exists = null;
        for (int i = 0; i < this.variables.size(); i++) {
            Simbolo actual=this.variables.get(i);
            if(actual.equals(s)){
                exists=actual;
                i=this.variables.size();
            }
        }
        return exists;
    }
    
    //metodo que dado un metodo verifica si existe o no en el nodo corriente, y en caso de existir lo retorna
    public Metodo getMetodo(Metodo m) {
        Metodo exists = null;
        for (int i = 0; i < this.metodos.size(); i++) {
            Metodo actual=this.metodos.get(i);
            if(actual.equals(m)){
                exists=actual;
                i=this.metodos.size();
            }
        }
        return exists;
    }
}
