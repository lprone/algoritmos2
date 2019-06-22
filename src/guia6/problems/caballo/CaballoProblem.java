/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.problems.caballo;

import guia6.problems.SearchProblem;
import guia6.problems.State;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lprone
 */
public class CaballoProblem implements SearchProblem {

    private final int x;
    private final int y;

    /**
     * @param x
     * @param y
     */
    public CaballoProblem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return
     */
    @Override
    public State initialState() {
        return new CaballoState(new int[8][8], x, y);
    }

    /**
     * @param s
     * @return
     */
    @Override
    public boolean success(State s) {
        for (int i = 0; i < ((CaballoState) s).tablero.length; i++) {
            for (int j = 0; j < ((CaballoState) s).tablero.length; j++) {
                if (((CaballoState) s).tablero[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean in(int x) {
        return (x >= 0) && (x < 8);
    }

    private boolean marcado(int[][] t, int x, int y) {
        return t[x][y] == 1;
    }

    /**
     * @param s
     * @return
     */
    @Override
    public List<State> getSuccessors(State s) {
        int[][] tablero = ((CaballoState) s).tablero;
        int x = ((CaballoState) s).x;
        int y = ((CaballoState) s).y;
        List<State> sucesores = new LinkedList<>();
        tablero[x][y] = 1;
        if (in(x + 2) && in(y + 1) && !marcado(tablero, x + 2, y + 1)) {
            sucesores.add(new CaballoState(tablero, x + 2, y + 1));
        }

        if (in(x + 2) && in(y - 1) && !marcado(tablero, x + 2, y - 1)) {
            sucesores.add(new CaballoState(tablero, x + 2, y - 1));
        }

        if (in(x - 2) && in(y + 1) && !marcado(tablero, x - 2, y + 1)) {
            sucesores.add(new CaballoState(tablero, x - 2, y + 1));
        }

        if (in(x - 2) && in(y - 1) && !marcado(tablero, x - 2, y - 1)) {
            sucesores.add(new CaballoState(tablero, x - 2, y - 1));
        }
        /*
         * -----------------------------------------------------------------
         */
        if (in(y + 2) && in(x + 1) && !marcado(tablero, y + 2, x + 1)) {
            sucesores.add(new CaballoState(tablero, y + 2, x + 1));
        }

        if (in(y - 2) && in(x + 1) && !marcado(tablero, y - 2, x + 1)) {
            sucesores.add(new CaballoState(tablero, y - 2, x + 1));
        }

        if (in(y + 2) && in(x - 1) && !marcado(tablero, y + 2, x - 1)) {
            sucesores.add(new CaballoState(tablero, y + 2, x - 1));
        }

        if (in(y - 2) && in(x - 1) && !marcado(tablero, y - 2, x - 1)) {
            sucesores.add(new CaballoState(tablero, y - 2, x - 1));
        }

        return sucesores;
    }
}
