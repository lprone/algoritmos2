/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.problems;

import guia6.State;
import java.util.ArrayList;
import java.util.List;

class JugsState implements State {

    private int j1, j2;

    public JugsState(int j1, int j2) {
        this.j1 = j1;
        this.j2 = j2;
    }

    public int getJ1() {
        return j1;
    }

    public int getJ2() {
        return j2;
    }

    @Override
    public boolean equals(State other) {
        return this.j1 == ((JugsState) other).j1 && this.j2 == ((JugsState) other).j2;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}

/**
 *
 * @author lprone
 */
public class Jugs implements guia6.AbstractSearchProblem {

    public Jugs() {
    }

    @Override
    public State initialState() {
        return new JugsState(0, 0);
    }

    @Override
    public boolean success(State s) {
        return ((JugsState) s).equals(new JugsState(4, 3));
    }

    @Override
    public List<State> getSuccessors(State s) {
        List<State> ret = new ArrayList();
        ret.add(new JugsState(0, ((JugsState) s).getJ2()));
        ret.add(new JugsState(((JugsState) s).getJ1(), 0));
        ret.add(new JugsState(4, ((JugsState) s).getJ2()));
        ret.add(new JugsState(((JugsState) s).getJ1(), 3));

        return ret;
    }
}
