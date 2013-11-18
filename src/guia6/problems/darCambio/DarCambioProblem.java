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
    LinkedList<Integer> monedas = new LinkedList();
//    private int m1 = 10000, m2 = 1000, m3 = 500, m4 = 100, m5 = 10;
//    private int m1 = 1, m2 = 2, m3 = 5, m4 = 10, m5 = 25;

    /**
     *
     * @param total
     */
    public DarCambioProblem(int total) {
        this.total = total;
        monedas.add(1);
        monedas.add(2);
        monedas.add(5);
        monedas.add(10);
        monedas.add(25);
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
        return ((DarCambioState) s).equals(new DarCambioState(0));
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public List<State> getSuccessors(State s) {
        int total = ((DarCambioState) s).total;
        List<State> sucesores = new LinkedList();
        for (Integer p : monedas) {
            sucesores.add(new DarCambioState(total - p));
        }
        Collections.reverse(sucesores);
        return sucesores;
    }
}
