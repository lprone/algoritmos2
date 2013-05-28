/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.engines;

import guia6.problems.State;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author lprone
 */
public class BFS extends AbstractSearchEngine {

    /**
     * 
     */
    private List path = new LinkedList();

    /**
     *
     * @return
     */
    @Override
    public List getPath() {
        return path;
    }

    /**
     *
     */
    @Override
    public void report() {
        System.out.println(path.toString());
    }

    /**
     *
     * @return
     */
    @Override
    public boolean performSearch() {
        Queue<State> estados = new LinkedList();
        estados.add(problem.initialState());
        while (!estados.isEmpty()) {
            System.out.println(estados.peek().toString());
            if (problem.success(estados.peek())) {
                return true;
            } else {
                estados.addAll(problem.getSuccessors(estados.poll()));
            }
        }
        return false;
    }
}
