package guia6.games;

import guia6.engines.*;
import guia6.problems.*;
import guia6.problems.jugs.*;

/**
 *
 * @author lprone
 */
public class Jugs {

    /**
     *
     */
    public static void solveWithDFS() {
        AbstractSearchProblem j = new JugsProblem();
        AbstractSearchEngine d = new DFS();
        d.setProblem(j);
        System.out.println(d.performSearch());
        d.report();
    }

    /**
     *
     */
    public static void solveWithBFS() {
        AbstractSearchProblem j = new JugsProblem();
        AbstractSearchEngine b = new BFS();
        b.setProblem(j);
        System.out.println(b.performSearch());
        b.report();
    }

    /**
     *
     */
    public static void solveWithID() {
        AbstractSearchProblem j = new JugsProblem();
        AbstractSearchEngine i = new ID(6);
        i.setProblem(j);
        System.out.println(i.performSearch());
        i.report();
    }

    /**
     *
     */
    public static void solveWithBestFS() {
        AbstractSearchProblem j = new JugsProblem();
        AbstractSearchEngine b = new BestFS();
        b.setProblem(j);
        System.out.println(b.performSearch());
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        long time_start, time_end;

        time_start = System.currentTimeMillis();
        solveWithDFS();
        time_end = System.currentTimeMillis();
        System.out.println("the task has taken " + (time_end - time_start) / 1000 + " seconds");
    }
}
