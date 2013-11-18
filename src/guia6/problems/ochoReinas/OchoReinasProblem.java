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
        return true;
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
        return true;
    }

    /**
     *
     * @param s
     * @return
     */
    private boolean validateDiagSec(State s) {
        for (int i = 0; i < ((OchoReinasState) s).tablero.length; i++) {
            for (int j = i + 1; j < ((OchoReinasState) s).tablero.length; j++) {
                if (((OchoReinasState) s).tablero[i - j + 1] == ((OchoReinasState) s).tablero[j]) {
                    return false;
                }
            }
        }
        return true;
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
}
