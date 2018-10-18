package guia6.games;

import guia6.engines.SearchEngine;
import guia6.engines.BFS;
import guia6.engines.BestFS;
import guia6.engines.DFS;
import guia6.engines.ID;
import guia6.problems.darCambio.DarCambioProblem;
import guia6.problems.SearchProblem;

/**
 *
 * @author lprone
 */
public class DarCambio {

    /**
     *
     * @param n
     */
    public static void solveWithDFS(int n) {
        SearchProblem dc = new DarCambioProblem(n);
        SearchEngine d = new DFS();
        d.setProblem(dc);
        System.out.println(d.performSearch());
//        d.report();
    }

    /**
     *
     * @param n
     */
    private static void solveWithBFS(int n) {
        SearchProblem dc = new DarCambioProblem(n);
        SearchEngine b = new BFS();
        b.setProblem(dc);
        System.out.println(b.performSearch());
        b.report();
    }

    /**
     *
     * @param n
     */
    public static void solveWithID(int n) {
        SearchProblem dc = new DarCambioProblem(n);
        SearchEngine i = new ID(20);
        i.setProblem(dc);
        System.out.println(i.performSearch());
//        i.report();
    }

    /**
     *
     * @param n
     */
    public static void solveWithBestFS(int n) {
        SearchProblem dc = new DarCambioProblem(n);
        SearchEngine b = new BestFS();
        b.setProblem(dc);
        System.out.println(b.performSearch());
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        long time_start, time_end;

        time_start = System.currentTimeMillis();
        solveWithBFS(68);
        time_end = System.currentTimeMillis();
        System.out.println("the task has taken " + (time_end - time_start) / 1000 + " seconds");

    }
}
