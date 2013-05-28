/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.engine;

import guia6.State;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lprone
 */
public class DFS extends AbstractSearchEngine {

    /**
     *
     * @return
     */
    @Override
    public List getPath() {
        List path = new ArrayList();
        return path;
    }

    /**
     *
     */
    @Override
    public void report() {
    }

    /**
     *
     * @return
     */
    @Override
    public boolean performSearch() {
        ArrayList<State> estados = new ArrayList();
        estados.add(problem.initialState());
        while (!estados.isEmpty()) {
            if (problem.success(estados.get(0))) {
                return true;
            } else {
                for (State state : problem.getSuccessors(estados.get(0))) {
                    estados.add(state);
                }
                estados.remove(0);
            }
        }
        return false;
    }
}
