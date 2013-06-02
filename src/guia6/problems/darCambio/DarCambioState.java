/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.problems.darCambio;

import guia6.problems.State;
import java.util.LinkedList;

/**
 *
 * @author lprone
 */
public class DarCambioState implements State {

    int total;
    String cambio = "";

    /**
     *
     * @param total
     * @param retornado
     */
    public DarCambioState(int total) {
        this.total = total;
    }
    
    public DarCambioState(int total, String moneda) {        
        this.total = total;
        this.cambio+=moneda+" ";
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(State o) {
        return this.total == ((DarCambioState) o).total && this.cambio == ((DarCambioState)o).cambio;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        
        return total+" - "+cambio;
    }
}
