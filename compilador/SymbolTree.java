/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fede
 */
public class SymbolTree {

    //raiz del arbol
    Node raiz;
    //nodo corriente que se esta examinando
    Node corriente;

    //constructor de clase
    public SymbolTree() {
        this.raiz = new Node();
        this.corriente = this.raiz;
    }

    //metodo que retorna el nodo raiz del arbol, es decir, el entorno global de la clase que se esta
    //implementando
    public Node getRaiz() {
        return raiz;
    }

    //metodo que retorna el nodo corriente
    public Node getCorriente() {
        return corriente;
    }

    //metodo que agrega un nuevo nivel (ya sea por la declaracion de un metodo o porque se ingreso
    // en una estructura condicional)
    public void agregarNivel() {
        //creamos un nuevo nivel (nodo) cuyo padre era el nivel anterior
        Node nivelNuevo = new Node(this.corriente);
        //vinculamos el nuevo nodo con su padre
        this.corriente.AddHijo(nivelNuevo);
        //y cambiamos el nodo corriente al nodo creado
        this.corriente = nivelNuevo;
    }

    //metodo que regresa a un nivel anterior (se utiliza cuando se acaba un condicional o un metodo)
    public void subirNivel() {
        if (this.corriente != null) {
            this.corriente = this.corriente.getPadre();
        }else{
            System.out.println("No es posible subir mas dentro del árbol");
        }
    }

    //metodo que agrega un simbolo al nivel corriente
    public void addSimbolo(Tipo type, String name, String value, int size) {
        Simbolo nuevo = new Simbolo(type, name, value, size);
        //si el simbolo no existe en el nivel corriente
        if (this.corriente.getSimbolo(nuevo)==null) {
            //se lo agrega
            this.corriente.addVariable(nuevo);
        }//caso contrario no se realiza ninguna accion
    }

    //metodo que agrega un metodo al nivel corriente
    public void addMetodo(Tipo returns, String name) {
        Metodo nuevo = new Metodo(returns, name);
        //si el metodo no existe en el nivel corriente
        if (this.corriente.getMetodo(nuevo)==null) {
            //se lo agrega
            this.corriente.addMetodo(nuevo);
        }//caso contrario no se realiza ninguna accion
    }
  
}
