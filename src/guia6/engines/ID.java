package guia6.engines;

import guia6.problems.State;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author lprone
 */
public class ID extends AbstractSearchEngine {

    /**
     *
     */
    private int cotaMax;
    private LinkedList<State> path = new LinkedList();

    /**
     *
     * @param cotaMax
     */
    public ID(int cotaMax) {
        this.cotaMax = cotaMax;
    }

    /**
     *
     */
    public ID() {
        this.cotaMax = 2;
    }

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
        for (State state : path) {
            System.out.println(state.toString());
        }
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
        Stack<State> estados = new Stack();
        estados.add(problem.initialState());
        for (int i = 0; i < cotaMax; i++) {
            int n = 0;
            while (!estados.isEmpty() && n < Math.pow(2, i)) {
                visitados.add(estados.peek());
                path.add(estados.peek());
//                System.out.println(estados.peek().toString());
                if (problem.success(estados.peek())) {
                    System.out.println(estados.peek().toString());
                    return true;
                } else {
                    n += problem.getSuccessors(estados.peek()).size();
                    State s = estados.peek();
                    List<State> aux = problem.getSuccessors(estados.pop());
                    for (State state : aux) {
                        if (!in(visitados, state) && !s.equals(state)) {
                            estados.add(state);
                        }
                    }
                }
            }
        }
        while (!estados.isEmpty()) {
//            System.out.println(estados.peek().toString());
            if (problem.success(estados.pop())) {
                return true;
            }
        }
        return false;
    }
}
