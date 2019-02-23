package guia6.problems.farmer;

import guia6.problems.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lprone
 */
public class FarmerProblem implements SearchProblem {

    /**
     *
     * @return
     */
    @Override
    public State initialState() {
        return new FarmerState(0, 0, 0, 0);
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean success(State s) {
        return s.equals(new FarmerState(1, 1, 1, 1));
    }

    /**
     *
     * @param x
     * @return
     */
    private int cruzar(int x) {
        return (x == 0) ? 1 : 0;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private boolean mismoLado(int x, int y) {
        return x == y;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private boolean mismoLado(int x, int y, int z) {
        return (x == y) && (y == z);
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private boolean mismoLado(int x, int y, int z, int w) {
        return (x == y) && (y == z) && (z == w);
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public List<State> getSuccessors(State s) {
        int granjero = ((FarmerState) s).granjero,
                zorro = ((FarmerState) s).zorro,
                gallina = ((FarmerState) s).gallina,
                maiz = ((FarmerState) s).maiz;

        List<State> sucesores = new ArrayList<>();


        /*
         * > gr ga
         * gr
         * > gr ma
         * gr ga
         * > gr zo
         * gr
         * > gr ga
         * 
         * 
         * 0 0 0 0
         * 1 0 1 0
         * 
         */

 /*-------------------------------*/
        if (mismoLado(granjero, zorro, gallina, maiz)) {
            sucesores.add(new FarmerState(cruzar(granjero), zorro, cruzar(gallina), maiz));
        }

        if (mismoLado(granjero, gallina) && mismoLado(zorro, maiz) && !mismoLado(granjero, maiz)) {
            sucesores.add(new FarmerState(cruzar(granjero), zorro, gallina, maiz));
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, cruzar(gallina), maiz));
        }

        if (mismoLado(granjero, zorro, maiz) && !mismoLado(granjero, gallina)) {
            sucesores.add(new FarmerState(cruzar(granjero), cruzar(zorro), gallina, maiz));
            sucesores.add(new FarmerState(cruzar(granjero), zorro, gallina, cruzar(maiz)));
        }

        if (mismoLado(granjero, zorro, gallina) && !mismoLado(granjero, maiz)) {
            sucesores.add(new FarmerState(cruzar(granjero), zorro, cruzar(gallina), maiz));
            sucesores.add(new FarmerState(cruzar(granjero), cruzar(zorro), gallina, maiz));
        }

        if (mismoLado(granjero, gallina, maiz) && !mismoLado(granjero, zorro)) {
            sucesores.add(new FarmerState(cruzar(granjero), zorro, gallina, cruzar(maiz)));
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, cruzar(gallina), maiz));
        }

        if (mismoLado(granjero, zorro, gallina) && !mismoLado(granjero, maiz)) {
            sucesores.add(new FarmerState(cruzar(granjero), cruzar(zorro), gallina, maiz));
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, cruzar(gallina), maiz));
        }

        if (mismoLado(granjero, zorro, maiz) && !mismoLado(granjero, gallina)) {
            sucesores.add(new FarmerState(cruzar(granjero), zorro, gallina, maiz));
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, cruzar(gallina), maiz));
        }

        if (mismoLado(granjero, gallina) && !mismoLado(granjero, zorro, maiz)) {
            sucesores.add(new FarmerState(cruzar(granjero), zorro, cruzar(gallina), maiz));
        }

        /*-------------------------------*/
//        if (mismoLado(granjero, zorro, gallina, maiz)) {
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, cruzar(gallina), maiz));
//        }
//
//        if (mismoLado(granjero, gallina) && mismoLado(zorro, maiz) && !mismoLado(granjero, maiz)) {
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, gallina, maiz));
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, cruzar(gallina), maiz));
//        }
//
//        if (mismoLado(granjero, zorro) && mismoLado(granjero, maiz)) {
//            sucesores.add(new FarmerState(cruzar(granjero), cruzar(zorro), gallina, maiz));
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, gallina, cruzar(maiz)));
//        }
//
//        if (mismoLado(granjero, zorro, gallina)) {
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, cruzar(gallina), maiz));
//        }
//
//        if (mismoLado(granjero, gallina, maiz)) {
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, gallina, cruzar(maiz)));
//        }
//
//        if (mismoLado(granjero, zorro, maiz)) {
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, gallina, maiz));
//            sucesores.add(new FarmerState(cruzar(granjero), cruzar(zorro), gallina, maiz));
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, gallina, cruzar(maiz)));
//        }
//
//
//
//        if (mismoLado(zorro, gallina, maiz)) {
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, cruzar(gallina), maiz));
//        }
//
//        if (mismoLado(gallina, maiz)) {
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, cruzar(gallina), maiz));
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, gallina, cruzar(maiz)));
//        }
//
//        if (mismoLado(zorro, gallina)) {
//            sucesores.add(new FarmerState(cruzar(granjero), cruzar(zorro), gallina, maiz));
//            sucesores.add(new FarmerState(cruzar(granjero), cruzar(zorro), gallina, maiz));
//            sucesores.add(new FarmerState(cruzar(granjero), zorro, cruzar(gallina), maiz));
//        }
        return sucesores;
    }
}
