package guia6.games;

import guia6.engines.*;
import guia6.problems.*;
import guia6.problems.jars.*;

/**
 *
 * @author lprone
 */
public class Jars {

    /**
     *
     */
    private static void solveWithDFS() {
        JarsProblem j = new JarsProblem();
        SearchEngine d = new DFS();
        d.setProblem(j);
        System.out.println(d.performSearch());
        d.report();
    }

    /**
     *
     */
    public static void solveWithBFS() {
        SearchProblem j = new JarsProblem();
        SearchEngine b = new BFS();
        b.setProblem(j);
        System.out.println(b.performSearch());
        b.report();
    }

    /**
     *
     */
    public static void solveWithID() {
        SearchProblem j = new JarsProblem();
        SearchEngine i = new ID(6);
        i.setProblem(j);
        System.out.println(i.performSearch());
        i.report();
    }

    /**
     *
     */
    public static void solveWithBestFS() {
        SearchProblem j = new JarsProblem();
        SearchEngine b = new BestFS();
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