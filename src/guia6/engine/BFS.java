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
public class BFS extends AbstractSearchEngine {

    private List path = new ArrayList();
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
        ArrayList<State> estados = new ArrayList();
        estados.add(problem.initialState());
        while (!estados.isEmpty()) {
            if (problem.success(estados.get(0))) {
                return true;
            } else {
                for (State state : problem.getSuccessors(estados.get(estados.size() - 1))) {
                    estados.add(state);
                }
                estados.remove(0);
            }
        }
        return false;
    }
}
