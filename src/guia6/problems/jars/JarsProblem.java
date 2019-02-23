package guia6.problems.jars;

import guia6.problems.State;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lprone
 */
public class JarsProblem implements guia6.problems.SearchProblem {

    /**
     *
     * @return
     */
    @Override
    public State initialState() {
        return new JarsState(0, 0);
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean success(State s) {
        return s.equals(new JarsState(2, 0));
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public List<State> getSuccessors(State s) {
        List<State> ret = new ArrayList<>();
        int j1 = ((JarsState) s).getJ1(), j2 = ((JarsState) s).getJ2();
        ret.add(new JarsState(0, j2));
        ret.add(new JarsState(j1, 0));
        ret.add(new JarsState(4, j2));
        ret.add(new JarsState(j1, 3));

        while (j1 > 0 && j2 < 3) {
            j1--;
            j2++;
        }

        ret.add(new JarsState(j1, j2));

        j1 = ((JarsState) s).getJ1();
        j2 = ((JarsState) s).getJ2();

        while (j1 < 4 && j2 > 0) {
            j1++;
            j2--;
        }

        ret.add(new JarsState(j1, j2));

        return ret;
    }
}
