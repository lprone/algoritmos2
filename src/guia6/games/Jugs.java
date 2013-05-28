/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    }

    /**
     *
     */
    public static void solveWithBFS() {
        AbstractSearchProblem j = new JugsProblem();
        AbstractSearchEngine b = new BFS();
        b.setProblem(j);
        System.out.println(b.performSearch());
    }

    /**
     *
     */
    public static void solveWithID() {
        AbstractSearchProblem j = new JugsProblem();
        AbstractSearchEngine i = new ID();
        i.setProblem(j);
        System.out.println(i.performSearch());
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

    public static void main(String[] args) {
        System.out.println("BFS");
        solveWithBFS();
    }
}
