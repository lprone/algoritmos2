/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.problems.jarsFB;

import guia6.problems.State;
import guia6.problems.jars.JarsState;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lprone
 */
public class JarsFBProblem implements guia6.problems.SearchProblem {

    @Override
    public State initialState() {
        return new JarsFBState(8, 0, 0);
    }

    @Override
    public List<State> getSuccessors(State s) {
        JarsFBState js = (JarsFBState) s;
        List<State> ret = new ArrayList<>();
        int j1 = ((JarsFBState) s).getJ1(), j2 = ((JarsFBState) s).getJ2(), j3 = ((JarsFBState) s).getJ3();

        if ((j1 - 5) + (j2 + 5) + (j3) == 8) {
            ret.add(new JarsFBState(j1 - 5, j2 + 5, j3));
        }

        if ((j1 - 3) + (j2) + (j3 + 3) == 8) {
            ret.add(new JarsFBState(j1 - 3, j2, j3 + 3));
        }

        if ((j1 - 8) + (j2 + 5) + (j3 + 3) == 8) {
            ret.add(new JarsFBState(j1 - 8, j2 + 5, j3 + 3));
        }

        if ((j1 + 5) + (j2 - 5) + (j3) == 8) {
            ret.add(new JarsFBState(j1 + 5, j2 - 5, j3));
        }
        if ((j1) + (j2 - 3) + (j3+3) == 8) {
            ret.add(new JarsFBState(j1 + 5, j2 - 5, j3));
        }

        return ret;
    }

    @Override
    public boolean success(State s) {
        return s.equals(new JarsState(2, 0));
    }

}
