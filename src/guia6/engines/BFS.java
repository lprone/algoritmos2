package guia6.engines;

import guia6.problems.State;

import java.util.*;

/**
 * @author lprone
 */
class Pair<A, B> {

    private A first;
    private B second;

    /**
     * @param first
     * @param second
     */
    public Pair(A first, B second) {
        super();
        this.first = first;
        this.second = second;
    }

    /**
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        return ((Pair) other).first.equals(first) && ((Pair) other).second.equals(second);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    /**
     * @return
     */
    public A getFirst() {
        return first;
    }

    /**
     * @param first
     */
    public void setFirst(A first) {
        this.first = first;
    }

    /**
     * @return
     */
    public B getSecond() {
        return second;
    }

    /**
     * @param second
     */
    public void setSecond(B second) {
        this.second = second;
    }
}

/**
 * @author lprone
 */
public class BFS extends SearchEngine {

    /**
     *
     */
    private State finalState;
    private final List<State> path = new LinkedList<>();
    private final LinkedList<Pair<State, State>> father = new LinkedList<>();

    /**
     * @return
     */
    @Override
    public List getPath() {
        State aux = finalState;
        while (!Objects.requireNonNull(aux).equals(problem.initialState())) {
            path.add(aux);
            aux = getFather(aux);
        }
        path.add(problem.initialState());
        Collections.reverse(path);
        return path;
    }

    /**
     * @param s
     * @return
     */
    private State getFather(State s) {
        for (Pair<State, State> aFather : father) {
            if (aFather.getSecond().equals(s)) {
                return aFather.getFirst();
            }
        }
        return null;
    }

    /**
     *
     */
    @Override
    public void report() {
        getPath();
        for (State s : path) {
            System.out.println(s.toString());
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
     * @param s
     * @param e
     * @return
     */
    private boolean in(LinkedList<Pair<State, State>> s, Pair e) {
        for (Pair<State, State> pair : s) {
            if (pair.equals(e)) {
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
        Queue<State> estados = new LinkedList<>();
        estados.add(problem.initialState());
        while (!estados.isEmpty()) {
            visitados.add(estados.peek());
//            System.out.println(estados.peek().toString());
            if (problem.success(estados.peek())) {
                finalState = estados.peek();
//                System.out.println(estados.peek().toString());
                return true;
            } else {
                State s = estados.peek();
                List<State> aux = problem.getSuccessors(estados.poll());
                for (State state : aux) {
                    father.add(new Pair<>(s, state));
                    if (!in(visitados, state) && !Objects.requireNonNull(s).equals(state)) {
                        estados.add(state);
                    }
                }
//                estados.addAll(problem.getSuccessors(estados.poll()));
            }
        }
        return false;
    }
}
