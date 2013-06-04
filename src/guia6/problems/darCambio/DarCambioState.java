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
    LinkedList<Integer> monedas = new LinkedList();

    /**
     *
     * @param total
     */
    public DarCambioState(int total) {
        this.total = total;
    }

    

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(State o) {
        return this.total == ((DarCambioState) o).total;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {

        return total + "";
    }
}
