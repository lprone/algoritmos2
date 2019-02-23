package guia6.problems.jars;

import guia6.problems.State;

/**
 *
 * @author lprone
 */
public class JarsState implements State {

    /**
     *
     */
    private final int j1, j2;

    /**
     *
     * @param j1
     * @param j2
     */
    public JarsState(int j1, int j2) {
        this.j1 = j1;
        this.j2 = j2;
    }

    /**
     *
     * @return
     */
    public int getJ1() {
        return j1;
    }

    /**
     *
     * @return
     */
    public int getJ2() {
        return j2;
    }

    /**
     *
     * @param other
     * @return
     */
    @Override
    public boolean equals(State other) {
        return this.j1 == ((JarsState) other).j1 && this.j2 == ((JarsState) other).j2;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.j1 + " - " + this.j2;
    }
}
