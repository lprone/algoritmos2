/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.problems.jarsFB;

import guia6.problems.State;

/**
 * @author lprone
 */
public class JarsFBState implements State {

    /**
     *
     */
    private final int j1, j2, j3;

    /**
     * @param j1
     * @param j2
     * @param j3
     */
    public JarsFBState(int j1, int j2, int j3) {
        this.j1 = j1;
        this.j2 = j2;
        this.j3 = j3;
    }

    /**
     * @return
     */
    public int getJ1() {
        return j1;
    }

    /**
     * @return
     */
    public int getJ2() {
        return j2;
    }

    /**
     * @return
     */
    public int getJ3() {
        return j3;
    }

    /**
     * @param other
     * @return
     */
    @Override
    public boolean equals(State other) {
        return this.j1 == ((JarsFBState) other).j1 && this.j2 == ((JarsFBState) other).j2 && this.j3 == ((JarsFBState) other).j3;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return this.j1 + " - " + this.j2 + " - " + this.j3;
    }
}
