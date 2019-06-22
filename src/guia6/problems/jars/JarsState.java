package guia6.problems.jars;

import guia6.problems.State;

/**
 * @author lprone
 */
public class JarsState implements State {

    /**
     *
     */
    private final int jar1, jar2;

    /**
     * @param jar1
     * @param jar2
     */
    public JarsState(int jar1, int jar2) {
        this.jar1 = jar1;
        this.jar2 = jar2;
    }

    /**
     * @return
     */
    public int getJar1() {
        return jar1;
    }

    /**
     * @return
     */
    public int getJar2() {
        return jar2;
    }

    /**
     * @param other
     * @return
     */
    @Override
    public boolean equals(State other) {
        return this.jar1 == ((JarsState) other).jar1 && this.jar2 == ((JarsState) other).jar2;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return this.jar1 + " - " + this.jar2;
    }
}
