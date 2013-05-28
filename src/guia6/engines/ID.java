/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.engines;

import guia6.problems.State;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lprone
 */
public class ID extends AbstractSearchEngine {

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
        return false;
    }
}
