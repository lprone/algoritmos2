/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.games;

import guia6.engines.*;
import guia6.problems.*;
import guia6.problems.ochoReinas.OchoReinasProblem;

/**
 *
 * @author lprone
 */
public class OchoReinas {

    /**
     *
     */
    public static void solveWithDFS() {
        AbstractSearchProblem or = new OchoReinasProblem();
        AbstractSearchEngine d = new DFS();
        d.setProblem(or);
        System.out.println(d.performSearch());
        d.report();
    }

    /**
     *
     */
    public static void solveWithBFS() {
        AbstractSearchProblem or = new OchoReinasProblem();
        AbstractSearchEngine b = new BFS();
        b.setProblem(or);
        System.out.println(b.performSearch());
    }

    /**
     *
     */
    public static void solveWithID() {
        AbstractSearchProblem or = new OchoReinasProblem();
        AbstractSearchEngine i = new ID();
        i.setProblem(or);
        System.out.println(i.performSearch());
        i.report();
    }

    /**
     *
     */
    public static void solveWithBestFS() {
        AbstractSearchProblem or = new OchoReinasProblem();
        AbstractSearchEngine b = new BestFS();
        b.setProblem(or);
        System.out.println(b.performSearch());
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        solveWithBFS();
    }
}
