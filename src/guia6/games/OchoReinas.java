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
        SearchProblem or = new OchoReinasProblem();
        SearchEngine d = new DFS();
        d.setProblem(or);
        System.out.println(d.performSearch());
        d.report();
    }

    /**
     *
     */
    private static void solveWithBFS() {
        SearchProblem or = new OchoReinasProblem();
        SearchEngine b = new BFS();
        b.setProblem(or);
        System.out.println(b.performSearch());
    }

    /**
     *
     */
    public static void solveWithID() {
        SearchProblem or = new OchoReinasProblem();
        SearchEngine i = new ID();
        i.setProblem(or);
        System.out.println(i.performSearch());
        i.report();
    }

    /**
     *
     */
    public static void solveWithBestFS() {
        SearchProblem or = new OchoReinasProblem();
        SearchEngine b = new BestFS();
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
