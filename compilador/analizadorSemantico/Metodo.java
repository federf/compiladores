/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.analizadorSemantico;

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

    // constructor de clase
    public Metodo(String returns, String name) {
        if (returns.equals("void")) {
            this.return_not_void = false;
        } else {
            this.return_not_void = true;
        }
        this.typeReturn = returns;
        this.name = name;
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

    @Override
    public String toString() {
        return "Metodo{" + " name=" + name + ", return_not_void=" + return_not_void  + ", typeReturn=" + typeReturn + '}';
    }

    public boolean equals(Metodo obj) {
        if (obj == null) {
            return false;
        }
        final Metodo other = (Metodo) obj;
        if (this.return_not_void != other.return_not_void) {
            return false;
        }
        if (!this.name.equals(other.name)) {
            return false;
        }
        if(!this.typeReturn.equals(other.typeReturn)){
            return false;
        }
        return true;
    }

}
