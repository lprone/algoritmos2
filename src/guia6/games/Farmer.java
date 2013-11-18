package guia6.games;

import guia6.engines.*;
import guia6.problems.*;
import guia6.problems.farmer.*;

/**
 *
 * @author lprone
 */
public class Farmer {

    /**
     *
     */
    public static void solveWithDFS() {
        AbstractSearchProblem f = new FarmerProblem();
        AbstractSearchEngine d = new DFS();
        d.setProblem(f);
        System.out.println(d.performSearch());
        d.report();
    }

    /**
     *
     */
    public static void solveWithBFS() {
        AbstractSearchProblem f = new FarmerProblem();
        AbstractSearchEngine b = new BFS();
        b.setProblem(f);
        System.out.println(b.performSearch());
        b.report();
    }

    /**
     *
     */
    public static void solveWithID() {
        AbstractSearchProblem f = new FarmerProblem();
        AbstractSearchEngine i = new ID(4);
        i.setProblem(f);
        System.out.println(i.performSearch());
        i.report();
    }

    /**
     *
     */
    public static void solveWithBestFS() {
        AbstractSearchProblem f = new FarmerProblem();
        AbstractSearchEngine b = new BestFS();
        b.setProblem(f);
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
