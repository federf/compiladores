/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;

/**
 *
 * @author fede
 */
public class SymbolTable {

    SymbolTree TablaDeSimbolos;

    //constructor de clase
    public SymbolTable() {
        this.TablaDeSimbolos = new SymbolTree();
    }

    //metodo que permite agregar un simbolo nuevo dentro del nivel corriente
    public void agregarSimbolo(String type, String name, String value, int size) {
        TablaDeSimbolos.addSimbolo(type, name, value, size);
    }

    //metodo que permite agregar un metodo nuevo dentro del nivel corriente
    public void agregarMetodo(String returns, String name) {
        TablaDeSimbolos.addMetodo(returns, name);
    }

    //metodo que agrega un nuevo nivel (ya sea por la declaracion de un metodo o porque se ingreso
    // en una estructura condicional)
    public void agregarNivel() {
        TablaDeSimbolos.agregarNivel();
    }
    
    //metodo que "sube un nivel" dentro del arbol que representa la tabla de simbolos
    public void SubirNivel(){
        this.TablaDeSimbolos.subirNivel();
    }

    //metodo que dado un simbolo verifica si fue declarado en el mismo o en algun nivel superior
    // (se utilizaria para ver si una variable fue declarada para poder ser usada)
    public Simbolo simboloDeclarado(String type, String name, String value, int size) {
        //creamos el simbolo como tal
        Simbolo s = new Simbolo(type, name, value, size);
        //variable booleana de resultado
        boolean declarado = false;
        //nos situamos en el nivel corriente dentro del arbol
        Node nivelCorr = this.TablaDeSimbolos.getCorriente();
        //si estamos en el ambiente global (raiz del arbol) verificamos si fue declarado en dicho ambiente
        if (nivelCorr.esRaiz()) {
            if(nivelCorr.getSimbolo(s)!=null){
                return nivelCorr.getSimbolo(s);
            }else{
                return null;
            }
                    
        } else {
            //sino verificamos de forma recursiva en el nivel corriente hasta llegas a la raiz o
            //encontrar el simbolo, lo que ocurra primero
            while (nivelCorr.getPadre() != null && (!declarado)) {
                //verificamos si el simbolo fue declarado en el nivel corriente
                declarado = declarado || (nivelCorr.getSimbolo(s)!=null);
                if(declarado){
                    nivelCorr.getSimbolo(s);
                }
                //actualizamos el nivel corriente al padre del mismo
                nivelCorr = nivelCorr.getPadre();
            }
        }
        return null;
    }

    
    //metodo que dado un Metodo verifica si fue declarado en el mismo o en algun nivel superior
    // (se utilizaria para ver si una variable fue declarada para poder ser usada)
    public Metodo metodoDeclarado(String result, String name, LinkedList<Simbolo> parametros) {
        //creamos el Metodo como tal
        Metodo s = new Metodo(result, name, parametros);
        //variable booleana de resultado
        boolean declarado = false;
        //nos situamos en el nivel corriente dentro del arbol
        Node nivelCorr = this.TablaDeSimbolos.getCorriente();
        //si estamos en el ambiente global (raiz del arbol) verificamos si fue declarado en dicho ambiente
        if (nivelCorr.esRaiz()) {
            if(nivelCorr.getMetodo(s)!=null){
                return nivelCorr.getMetodo(s);
            }else{
                return null;
            }
        } else {
            //sino verificamos de forma recursiva en el nivel corriente hasta llegas a la raiz o
            //encontrar el Metodo, lo que ocurra primero
            while (nivelCorr.getPadre() != null && (!declarado)) {
                //verificamos si el Metodo fue declarado en el nivel corriente
                declarado = declarado || (nivelCorr.getMetodo(s)!=null);
                //si lo encuentra lo devuelve
                if(declarado){
                    return nivelCorr.getMetodo(s);
                }
                //actualizamos el nivel corriente al padre del mismo
                nivelCorr = nivelCorr.getPadre();
            }
        }
        return null;
    }
    
        //metodo que devuelve el ultimo metodo creado
    public Metodo obtenerMetodo(){
        return this.TablaDeSimbolos.corriente.metodos.getLast();
    }
    
    //metodo que devuelve el ultimo simbolo creado
    public Simbolo obtenerSimbolo(){
        return this.TablaDeSimbolos.corriente.variables.getLast();
    }
}
