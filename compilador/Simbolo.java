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
    int offset;

    // constructor de clase
    public Simbolo(Type type, String name, String value, int size, int offset) {
        this.type = type;
        this.name = name;
        this.value = value;
        this.size = size;
        this.offset=offset;
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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int o) {
        this.offset=o;
    }

    @Override
    public String toString() {
        return "Simbolo{" + "type=" + type.toString() + ", name=" + name + ", value=" + value + ", size=" + size +", offset="+ offset +'}';
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
        if(this.size!=other.size){
            return false;
        }
        if(this.offset!=other.offset){
            return false;
        }
        return true;
    }

}
