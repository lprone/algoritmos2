package guia6.engines;

import guia6.problems.State;

import java.util.*;

/**
 * @author lprone
 */
public class DFS extends SearchEngine {

    /**
     *
     */
    private final LinkedList<State> path = new LinkedList<>();

    /**
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
        for (State state : path) {
            System.out.println(state.toString());
        }
    }

    /**
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
     * @return
     */
    @Override
    public boolean performSearch() {
        Set<State> visitados = new LinkedHashSet<>();
        Stack<State> estados = new Stack<>();
        estados.add(problem.initialState());
        while (!estados.isEmpty()) {
            visitados.add(estados.peek());
            path.add(estados.peek());
//            System.out.println(estados.peek().toString());
            if (problem.success(estados.peek())) {
//                System.out.println(estados.peek().toString());
                return true;
            } else {
                State s = estados.peek();
                List<State> aux = problem.getSuccessors(estados.pop());
                for (State state : aux) {
                    if (!in(visitados, state) && !s.equals(state)) {
                        estados.add(state);
                    }
                }
            }
        }
        return false;
    }
}
