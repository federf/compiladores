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
public class Metodo {

    //variable que indica si el metodo retorna o no algo como resultado de su ejecucion
    boolean return_not_void;
    // nombre del metodo
    String name;
    //tipo de retorno (puede ser void o no)
    String typeReturn;
    //lista de parametros (simbolos) del metodo
    LinkedList<Simbolo> parametros;

    // constructor de clase
    public Metodo(String returns, String name) {
        if (returns.equals("void")) {
            this.return_not_void = false;
        } else {
            this.return_not_void = true;
        }
        this.typeReturn = returns;
        this.name = name;
        this.parametros = new LinkedList();
    }

    //constructor alternativo
    public Metodo(String returns, String name, LinkedList<Simbolo> param) {
        if (returns.equals("void")) {
            this.return_not_void = false;
        } else {
            this.return_not_void = true;
        }
        this.typeReturn = returns;
        this.name = name;
        this.parametros = param;
    }

    public boolean isReturn_not_void() {
        return return_not_void;
    }

    public void setReturn_not_void(boolean return_not_void) {
        this.return_not_void = return_not_void;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeReturn() {
        return typeReturn;
    }

    public void setTypeReturn(String typeReturn) {
        this.typeReturn = typeReturn;
    }

    public LinkedList<Simbolo> getParametros() {
        return parametros;
    }

    public void setParametros(LinkedList<Simbolo> parametros) {
        this.parametros = parametros;
    }

    //metodo que permite agregar un simbolo a la lista de parametros del metodo actual
    public void addParametro(Simbolo s) {
        //primero se verifica si el simbolo no fue declarado como parametro aun
        boolean agregar = true;
        for (int i = 0; i < this.parametros.size(); i++) {
            if (this.parametros.get(i).equals(s)) {
                agregar = false;
                i = this.parametros.size();
            }
        }
        //si no fue declarado como parametro
        if (agregar) {
            //se lo agrega a la lista
            this.parametros.add(s);
        }
    }

    @Override
    public String toString() {
        System.out.println("");
        return "Metodo{" + " name=" + this.name + ", return_not_void=" + this.return_not_void + ", typeReturn=" + this.typeReturn + '}';
    }

    public boolean equals(Metodo obj) {
        if (obj == null) {
            return false;
        }
        final Metodo other = (Metodo) obj;
        if (this.return_not_void != other.return_not_void) {
            return false;
        }
        //si no se llaman igual no son el mismo metodo
        if (!this.name.equals(other.name)) {
            return false;
        }
        //si no retornan lo mismo no son el mismo metodo
        if (!this.typeReturn.equals(other.typeReturn)) {
            return false;
        }
        //si no tienen los mismos parametros no son el mismo metodo
        if (!this.mismosParametros(other)) {
            return false;
        }
        return true;
    }

    //metodo que dados dos metodos verifica si ambos tienen los mismos parametros
    public boolean mismosParametros(Metodo m) {
        boolean mismosParam = true;
        //si no tienen la misma cantidad de parametros devolvemos false
        if (this.parametros.size() != m.parametros.size()) {
            return false;
        } else {
            //sino verificamos que cada parametro de uno de los metodos es parametro del otro
            for (int i = 0; i < this.parametros.size(); i++) {
                boolean esta = false;
                for (int j = 0; j < m.parametros.size(); j++) {
                    esta = esta || this.parametros.get(i).equals(m.parametros.get(j));
                }
                mismosParam = mismosParam && esta;
            }
        }
        return mismosParam;
    }
}
