/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.games;

import guia6.engines.AbstractSearchEngine;
import guia6.engines.BFS;
import guia6.engines.BestFS;
import guia6.engines.DFS;
import guia6.engines.ID;
import guia6.problems.caballo.CaballoProblem;

/**
 *
 * @author lprone
 */
public class Caballo {

    /**
     *
     */
    public static void solveWithDFS(int x, int y) {
        CaballoProblem c = new CaballoProblem(x, y);
        AbstractSearchEngine d = new DFS();
        d.setProblem(c);
        System.out.println(d.performSearch());
//        d.report();
    }

    /**
     *
     */
    public static void solveWithBFS(int x, int y) {
        CaballoProblem c = new CaballoProblem(x, y);
        AbstractSearchEngine b = new BFS();
        b.setProblem(c);
        System.out.println(b.performSearch());
//        b.report();
    }

    /**
     *
     */
    public static void solveWithID(int x, int y) {
        CaballoProblem c = new CaballoProblem(x, y);
        AbstractSearchEngine i = new ID(20);
        i.setProblem(c);
        System.out.println(i.performSearch());
//        i.report();
    }

    /**
     *
     */
    public static void solveWithBestFS(int x, int y) {
        CaballoProblem c = new CaballoProblem(x, y);
        AbstractSearchEngine b = new BestFS();
        b.setProblem(c);
        System.out.println(b.performSearch());
    }

    public static void main(String[] args) {

        long time_start, time_end;

        time_start = System.currentTimeMillis();
        solveWithBFS(4, 0);
        time_end = System.currentTimeMillis();
        System.out.println("the task has taken " + (time_end - time_start) / 1000 + " seconds");

    }
}
