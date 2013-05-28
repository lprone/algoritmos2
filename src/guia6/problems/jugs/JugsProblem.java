/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.problems.jugs;

import guia6.problems.State;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lprone
 */
public class JugsProblem implements guia6.problems.AbstractSearchProblem {

    /**
     *
     * @return
     */
    @Override
    public State initialState() {
        return new JugsState(0, 0);
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean success(State s) {
        return ((JugsState) s).getJ1() == 2 || ((JugsState) s).getJ2() == 2;
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public List<State> getSuccessors(State s) {
        List<State> ret = new ArrayList();
        int j1 = ((JugsState) s).getJ1(), j2 = ((JugsState) s).getJ2();
        ret.add(new JugsState(0, j2));
        ret.add(new JugsState(j1, 0));
        ret.add(new JugsState(4, j2));
        ret.add(new JugsState(j1, 3));

        while (j1 > 0 && j2 < 3) {
            j1--;
            j2++;
        }

        ret.add(new JugsState(j1, j2));

        j1 = ((JugsState) s).getJ1();
        j2 = ((JugsState) s).getJ2();

        while (j1 < 4 && j2 > 0) {
            j1++;
            j2--;
        }

        ret.add(new JugsState(j1, j2));

        return ret;
    }
}
