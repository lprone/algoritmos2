package guia6.problems.caballo;

import guia6.problems.State;
import java.util.Arrays;

/**
 *
 * @author lprone
 */
public class CaballoState implements State {

    final int[][] tablero;
    final int x;
    final int y;

    /**
     *
     * @param tablero
     * @param x
     * @param y
     */
    public CaballoState(int[][] tablero, int x, int y) {
        this.tablero = tablero;
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(State o) {
        return this.x == ((CaballoState) o).x
                && this.y == ((CaballoState) o).y
                && Arrays.deepEquals(tablero, ((CaballoState) o).tablero);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return x + " - " + y + " - " + Arrays.deepToString(tablero);
    }
}
