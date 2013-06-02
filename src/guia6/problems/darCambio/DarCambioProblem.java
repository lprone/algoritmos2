/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.problems.darCambio;

import guia6.problems.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lprone
 */
public class DarCambioProblem implements AbstractSearchProblem {

    int total;
    private int m1 = 10000, m2 = 1000, m3 = 500, m4 = 100, m5 = 10;
//    private int m1 = 1, m2 = 2, m3 = 5, m4 = 10, m5 = 25;

    /**
     *
     * @param total
     */
    public DarCambioProblem(int total) {
        this.total = total;
    }

    /**
     *
     * @return
     */
    @Override
    public State initialState() {
        return new DarCambioState(total);
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean success(State s) {
        return ((DarCambioState) s).total == 0;
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public List<State> getSuccessors(State s) {

        int total = ((DarCambioState) s).total;
        String cambio = ((DarCambioState) s).cambio;

        List<State> sucesores = new LinkedList();

        if (total >= m1) {
            sucesores.add(new DarCambioState(total - m1, cambio + m1));
        }

        if (total >= m2) {

            sucesores.add(new DarCambioState(total - m2, cambio + m2));
        }

        if (total >= m3) {

            sucesores.add(new DarCambioState(total - m3, cambio + m3));
        }

        if (total > m4) {

            sucesores.add(new DarCambioState(total - m4, cambio + m4));
        }

        if (total > m5) {

            sucesores.add(new DarCambioState(total - m5, cambio + m5));
        }

        Collections.reverse(sucesores);
        return sucesores;
    }
}
