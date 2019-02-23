package guia6.engines;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lprone
 */
public class BestFS extends SearchEngine {

    /**
     *
     */
    private final List path = new LinkedList<>();

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
