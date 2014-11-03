/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import ir.ast.*;

/**
 *
 * @author fede
 */
public class symbolTable {

    SymbolTree TablaDeSimbolos;

    //constructor de clase
    public symbolTable() {
        this.TablaDeSimbolos = new SymbolTree();
    }

    //metodo que permite agregar un simbolo nuevo dentro del nivel corriente
    public void agregarSimbolo(Type type, String name, String value, int size, int offset) {
        this.TablaDeSimbolos.addSimbolo(type, name, value, size, offset);
    }

    //metodo que permite agregar un metodo nuevo dentro del nivel corriente
    public void agregarMetodo(Type returns, String name) {
        this.TablaDeSimbolos.addMetodo(returns, name);
    }

    //metodo que agrega un nuevo nivel (ya sea por la declaracion de un metodo o porque se ingreso
    // en una estructura condicional)
    public void agregarNivel() {
        this.TablaDeSimbolos.agregarNivel();
    }

    //metodo que "sube un nivel" dentro del arbol que representa la tabla de simbolos
    public void SubirNivel() {
        this.TablaDeSimbolos.subirNivel();
    }

    //metodo que dado un simbolo verifica si fue declarado en el mismo o en algun nivel superior
    // (se utilizaria para ver si una variable fue declarada para poder ser usada)
    public boolean simboloDeclarado(Type type, String name, String value, int size, int off) {
        //creamos el simbolo como tal
        Simbolo s = new Simbolo(type, name, value, size, off);
        //variable booleana de resultado
        boolean declarado = false;
        //nos situamos en el nivel corriente dentro del arbol
        Node nivelCorr = this.TablaDeSimbolos.getCorriente();
        //si estamos en el ambiente global (raiz del arbol) verificamos si fue declarado en dicho ambiente
        if (nivelCorr.esRaiz()) {
            declarado = nivelCorr.getSimbolo(s) != null;
        } else {
            //sino verificamos de forma recursiva en el nivel corriente hasta llegas a la raiz o
            //encontrar el simbolo, lo que ocurra primero
            while (nivelCorr.getPadre() != null && (!declarado)) {
                //verificamos si el simbolo fue declarado en el nivel corriente
                declarado = declarado || (nivelCorr.getSimbolo(s) != null);
                //actualizamos el nivel corriente al padre del mismo
                nivelCorr = nivelCorr.getPadre();
            }
        }
        return declarado;
    }

    //metodo que dado un Metodo verifica si fue declarado en el mismo o en algun nivel superior
    // (se utilizaria para ver si una variable fue declarada para poder ser usada)
    public boolean metodoDeclarado(Type result, String name) {
        //creamos el Metodo como tal
        Metodo s = new Metodo(result, name);
        //variable booleana de resultado
        boolean declarado = false;
        //nos situamos en el nivel corriente dentro del arbol
        Node nivelCorr = this.TablaDeSimbolos.getCorriente();
        //si estamos en el ambiente global (raiz del arbol) verificamos si fue declarado en dicho ambiente
        if (nivelCorr.esRaiz()) {
            declarado = nivelCorr.getMetodo(s) != null;
        } else {
            //sino verificamos de forma recursiva en el nivel corriente hasta llegas a la raiz o
            //encontrar el Metodo, lo que ocurra primero
            while (nivelCorr.getPadre() != null && (!declarado)) {
                //verificamos si el Metodo fue declarado en el nivel corriente
                declarado = declarado || (nivelCorr.getMetodo(s) != null);
                //actualizamos el nivel corriente al padre del mismo
                nivelCorr = nivelCorr.getPadre();
            }
        }
        return declarado;
    }

    //metodo que devuelve el ultimo metodo creado
    public Metodo obtenerMetodo() {
        return this.TablaDeSimbolos.corriente.metodos.getLast();
    }

    //metodo que devuelve el ultimo simbolo creado
    public Simbolo obtenerSimbolo() {
        return this.TablaDeSimbolos.corriente.variables.getLast();
    }

    //metodo que dado el nombre de un simbolo lo busca y retorna como resultado
    public Simbolo buscarSimbolo(String id) {
        //nos situamos en el nivel corriente dentro del arbol
        Node nivelCorr = this.TablaDeSimbolos.getCorriente();
        //sino verificamos de forma recursiva en el nivel corriente hasta llegas a la raiz o
        //encontrar el simbolo, lo que ocurra primero
        boolean declarado = false;
        Simbolo result = null;
        while (nivelCorr!=null && (!declarado)) {
            //verificamos si el simbolo fue declarado en el nivel corriente
            declarado = declarado || (nivelCorr.getSimboloByName(id) != null);
            //actualizamos el nivel corriente al padre del mismo
            result = nivelCorr.getSimboloByName(id);
            nivelCorr = nivelCorr.getPadre();
        }
        return result;
    }
    
    //metodo que dado un el nombre, tipo de retorno y la lista de tipos de los parametros de 
    //un metodo verifica si existe alguna coincidencia y la retorna
    public Metodo buscarMetodo(String name, LinkedList<Type>paramTypes) {
        //creamos el metodo como tal para comparar
        LinkedList<Simbolo> params=new LinkedList();
        for(int i=0; i<paramTypes.size(); i++){
            Simbolo actual=new Simbolo(paramTypes.get(i), ""+i+"",null, 0,i);
            params.add(actual);
        }
        //nos situamos en el nivel corriente dentro del arbol
        Node nivelCorr = this.TablaDeSimbolos.getCorriente();
        //sino verificamos de forma recursiva en el nivel corriente hasta llegas a la raiz o
        //encontrar el metodo, lo que ocurra primero
        boolean declarado = false;
        Metodo m=new Metodo(Type.VOID, name, params);
        Metodo result = null;
        while (nivelCorr!=null && (!declarado)) {
            //verificamos si el metodo fue declarado en el nivel corriente
            declarado = declarado || (nivelCorr.buscarMetodo(m) != null);
            //actualizamos el nivel corriente al padre del mismo
            result = nivelCorr.buscarMetodo(m);
            nivelCorr = nivelCorr.getPadre();
        }
        return result;
    }

    public Node getCorriente(){
        return TablaDeSimbolos.getCorriente();
    }
}
