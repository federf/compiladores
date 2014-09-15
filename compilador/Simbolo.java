/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 clase que implementa los simbolos (variables/constantes) que son declaradas por el usuario
 */

import ir.ast.*;

/**
 *
 * @author fede
 */
public class Simbolo {

    Type type;//tipo de simbolo
    String name;//nombre del simbolo
    String value;//valor (no estoy seguro que sea necesario)
    int size; //para el caso de arreglos

    // constructor de clase
    public Simbolo(Type type, String name, String value, int size) {
        this.type = type;
        this.name = name;
        this.value = value;
        this.size = 0;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Simbolo{" + "type=" + type.toString() + ", name=" + name + ", value=" + value + ", size=" + size + '}';
    }

    public boolean equals(Simbolo obj) {
        if (obj == null) {
            return false;
        }
        final Simbolo other = obj;
        if (!this.type.equals(other.type)) {
            return false;
        }
        if (!this.name.equals(other.name)) {
            return false;
        }
        /* creo no hace falta
         if (!this.value.equals(other.value)) {
         return false;
         }*/
        return true;
    }

}
