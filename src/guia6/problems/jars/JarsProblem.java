package guia6.problems.jars;

import guia6.problems.SearchProblem;
import guia6.problems.State;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lprone
 */
public class JarsProblem implements SearchProblem {

    /**
     * @return
     */
    @Override
    public State initialState() {
        return new JarsState(0, 0);
    }

    /**
     * @param s
     * @return
     */
    @Override
    public boolean success(State s) {
        return s.equals(new JarsState(2, 0));
    }

    /**
     * @param s
     * @return
     */
    @Override
    public List<State> getSuccessors(State s) {
        List<State> ret = new ArrayList<>();
        int jar1 = ((JarsState) s).getJar1();
        int jar2 = ((JarsState) s).getJar2();

        ret.add(fillJarOne(jar1, jar2));
        ret.add(fillJarTwo(jar1, jar2));
        ret.add(drainJarOne(jar1, jar2));
        ret.add(drainJarTwo(jar1, jar2));
        ret.add(trasferWaterFromJarOneToJarTwo(jar1, jar2));
        ret.add(trasferWaterFromJarTwoToJarOne(jar1, jar2));

        return ret;
    }

    private JarsState fillJarOne(int jar1, int jar2) {
        return new JarsState(4, jar2);
    }

    private JarsState fillJarTwo(int jar1, int jar2) {
        return new JarsState(jar1, 3);
    }

    private JarsState drainJarOne(int jar1, int jar2) {
        return new JarsState(0, jar2);
    }

    private JarsState drainJarTwo(int jar1, int jar2) {
        return new JarsState(jar1, 0);
    }

    private JarsState trasferWaterFromJarOneToJarTwo(int jar1, int jar2) {
        while (jar1 > 0 && jar2 < 3) {
            jar1--;
            jar2++;
        }
        return new JarsState(jar1, jar2);
    }

    private JarsState trasferWaterFromJarTwoToJarOne(int jar1, int jar2) {
        while (jar1 < 4 && jar2 > 0) {
            jar1++;
            jar2--;
        }
        return new JarsState(jar1, jar2);
    }
}
