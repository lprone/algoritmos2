/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.problems.jugs;

import guia6.problems.State;

/**
 *
 * @author lprone
 */
public class JugsState implements State {

    /**
     *
     */
    private int j1, j2;

    /**
     *
     * @param j1
     * @param j2
     */
    public JugsState(int j1, int j2) {
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
        return this.j1 == ((JugsState) other).j1 && this.j2 == ((JugsState) other).j2;
    }

//    @Override
//    public boolean equals(Object obj) {
//        return equals((State)obj);
//    }
    
    

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.j1 + " - " + this.j2;
    }
}
