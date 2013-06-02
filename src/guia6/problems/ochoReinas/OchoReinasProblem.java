/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.problems.ochoReinas;

import guia6.problems.State;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lprone
 */
public class OchoReinasProblem implements guia6.problems.AbstractSearchProblem {

    /**
     *
     * @return
     */
    @Override
    public State initialState() {
        return new OchoReinasState(-1, -1, -1, -1, -1, -1, -1, -1);
    }

    /**
     *
     * @param s
     * @return
     */
    private boolean validateCol(State s) {
        for (int i = 0; i < ((OchoReinasState) s).tablero.length; i++) {
            for (int j = i + 1; j < ((OchoReinasState) s).tablero.length; j++) {
                if (((OchoReinasState) s).tablero[i] == ((OchoReinasState) s).tablero[j]) {
                    return false;
                }
            }
        }
        return false;

//        return s.equals(new OchoReinasState(
//                ((OchoReinasState) s).tablero[0],
//                ((OchoReinasState) s).tablero[1],
//                ((OchoReinasState) s).tablero[2],
//                ((OchoReinasState) s).tablero[3],
//                ((OchoReinasState) s).tablero[4],
//                ((OchoReinasState) s).tablero[5],
//                ((OchoReinasState) s).tablero[6],
//                ((OchoReinasState) s).tablero[7]));
    }

    /**
     *
     * @param s
     * @return
     */
    private boolean validateDiagPri(State s) {
        for (int i = 0; i < ((OchoReinasState) s).tablero.length; i++) {
            for (int j = i + 1; j < ((OchoReinasState) s).tablero.length; j++) {
                if (((OchoReinasState) s).tablero[i] == ((OchoReinasState) s).tablero[j]) {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param s
     * @return
     */
    private boolean validateDiagSec(State s) {
        for (int i = 0; i < ((OchoReinasState) s).tablero.length; i++) {
            for (int j = i+1; j < ((OchoReinasState) s).tablero.length; j++) {
                if (((OchoReinasState) s).tablero[i-j+1] == ((OchoReinasState) s).tablero[j]) {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean success(State s) {
        return validateCol(s) && validateDiagPri(s) && validateDiagSec(s);
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public List<State> getSuccessors(State s) {
        int t0 = ((OchoReinasState) s).tablero[0],
                t1 = ((OchoReinasState) s).tablero[0],
                t2 = ((OchoReinasState) s).tablero[1],
                t3 = ((OchoReinasState) s).tablero[2],
                t4 = ((OchoReinasState) s).tablero[3],
                t5 = ((OchoReinasState) s).tablero[4],
                t6 = ((OchoReinasState) s).tablero[5],
                t7 = ((OchoReinasState) s).tablero[6];

        List<State> sucesores = new ArrayList();
        sucesores.add(new OchoReinasState(
                new Double(Math.random() * 8).intValue(),
                new Double(Math.random() * 8).intValue(),
                new Double(Math.random() * 8).intValue(),
                new Double(Math.random() * 8).intValue(),
                new Double(Math.random() * 8).intValue(),
                new Double(Math.random() * 8).intValue(),
                new Double(Math.random() * 8).intValue(),
                new Double(Math.random() * 8).intValue()));
        return sucesores;
    }
    /* pinoluz
     * cepillo
     * canasta
     */
}
