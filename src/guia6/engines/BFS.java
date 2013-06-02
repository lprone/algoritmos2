/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.engines;

import guia6.problems.State;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
     * @param s
     * @param e
     * @return
     */
    private boolean in(Set<State> s, State e) {
        for (State state : s) {
            if (state.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean performSearch() {
        Set<State> visitados = new LinkedHashSet();
        Queue<State> estados = new LinkedList();
        estados.add(problem.initialState());
        while (!estados.isEmpty()) {
            visitados.add(estados.peek());
//            System.out.println(estados.peek().toString());
            if (problem.success(estados.peek())) {
                System.out.println(estados.peek().toString());
                return true;
            } else {
                State s = estados.peek();
                List<State> aux = problem.getSuccessors(estados.poll());
                for (State state : aux) {
                    if (!in(visitados, state) && !s.equals(state)) {
                        estados.add(state);
                    }
                }
//                estados.addAll(problem.getSuccessors(estados.poll()));
            }
        }
        return false;
    }
}
