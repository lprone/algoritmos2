package guia6.games;

import guia6.engines.*;
import guia6.problems.SearchProblem;
import guia6.problems.farmer.FarmerProblem;

/**
 * @author lprone
 */
public class Farmer {

    /**
     *
     */
    public static void solveWithDFS() {
        SearchProblem f = new FarmerProblem();
        SearchEngine d = new DFS();
        d.setProblem(f);
        System.out.println(d.performSearch());
        d.report();
    }

    /**
     *
     */
    private static void solveWithBFS() {
        SearchProblem f = new FarmerProblem();
        SearchEngine b = new BFS();
        b.setProblem(f);
        System.out.println(b.performSearch());
        b.report();
    }

    /**
     *
     */
    public static void solveWithID() {
        SearchProblem f = new FarmerProblem();
        SearchEngine i = new ID(4);
        i.setProblem(f);
        System.out.println(i.performSearch());
        i.report();
    }

    /**
     *
     */
    public static void solveWithBestFS() {
        SearchProblem f = new FarmerProblem();
        SearchEngine b = new BestFS();
        b.setProblem(f);
        System.out.println(b.performSearch());

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        long time_start, time_end;

        time_start = System.currentTimeMillis();
        solveWithBFS();
        time_end = System.currentTimeMillis();
        System.out.println("the task has taken " + (time_end - time_start) / 1000 + " seconds");
    }
}
