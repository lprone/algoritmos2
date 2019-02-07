package guia2;

import java.util.ArrayList;

/**
 *
 * @author lprone
 */
public class ej5b {

    private final int[][] tablero = new int[8][8];
    private final int reina = 8;
    private final int disponible = 0;
    private final int noDisponible = 1;
    private boolean solCorrecta;

    /**
     *
     * @return
     */
    private String getPosicionReinas() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (esReina(i, j)) {
                    ret.append("( ").append(i).append(" , ").append(j).append(" )  ");
                }
            }
        }
        return ret.toString();
    }

    /**
     *
     * @param x
     * @param y
     */
    private void setPosNoDisponible(int x, int y) {
        tablero[x][y] = noDisponible;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private boolean esReina(int x, int y) {
        return tablero[x][y] == reina;
    }

    /**
     *
     * @param x
     * @param y
     */
    private void setReina(int x, int y) {
        if (posicionNoPermitida(x, y)) {
            solCorrecta = false;
        }
        tablero[x][y] = reina;
        setFil(x);
        setCol(y);
        setDiag(x, y);
    }

    /**
     *
     */
    private void inicializarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = disponible;
            }
        }
        solCorrecta = true;
    }

    /**
     *
     * @param x
     */
    private void setFil(int x) {
        for (int i = 0; i < tablero.length; i++) {
            if (posicionPermitida(x, i)) {
                setPosNoDisponible(x, i);
            }
        }
    }

    /**
     *
     * @param y
     */
    private void setCol(int y) {
        for (int i = 0; i < tablero.length; i++) {
            if (posicionPermitida(i, y)) {
                setPosNoDisponible(i, y);
            }
        }
    }

    /**
     *
     * @param x
     * @param y
     */
    private void setDiag(int x, int y) {
        int i = x + 1, j = y + 1;
        while (i < tablero.length && i >= 0 && j < tablero.length && j >= 0) {
            if (posicionPermitida(i, j)) {
                setPosNoDisponible(i, j);
            }
            i = i + 1;
            j = j + 1;
        }
        i = x - 1;
        j = y - 1;
        while (i < tablero.length && i >= 0 && j < tablero.length && j >= 0) {
            if (posicionPermitida(i, j)) {
                setPosNoDisponible(i, j);
            }
            i = i - 1;
            j = j - 1;
        }
        i = x + 1;
        j = y - 1;
        while (i < tablero.length && i >= 0 && j < tablero.length && j >= 0) {
            if (posicionPermitida(i, j)) {
                setPosNoDisponible(i, j);
            }
            i = i + 1;
            j = j - 1;
        }
        i = x - 1;
        j = y + 1;
        while (i < tablero.length && i >= 0 && j < tablero.length && j >= 0) {
            if (posicionPermitida(i, j)) {
                setPosNoDisponible(i, j);
            }
            i = i - 1;
            j = j + 1;
        }
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private boolean posicionPermitida(int x, int y) {
        return tablero[x][y] != reina;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private boolean posicionNoPermitida(int x, int y) {
        return tablero[x][y] == reina || tablero[x][y] == noDisponible;
    }

    /**
     *
     */
    private void verTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     *
     * @return
     */
    private boolean solucionCorrecta() {
        return solCorrecta;
    }

    /**
     *
     */
    private static void solveBusquedaExaustiva() {
        ArrayList soluciones = new ArrayList();
        ej5b e = new ej5b();
        e.inicializarTablero();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        for (int m = 0; m < 8; m++) {
                            for (int n = 0; n < 8; n++) {
                                for (int o = 0; o < 8; o++) {
                                    for (int p = 0; p < 8; p++) {
                                        e.setReina(i, j);
                                        e.setReina(j, k);
                                        e.setReina(k, l);
                                        e.setReina(l, m);
                                        e.setReina(m, n);
                                        e.setReina(n, o);
                                        e.setReina(o, p);
                                        e.setReina(p, i);
                                        if (e.solucionCorrecta()) {
                                            if (!soluciones.contains(e.getPosicionReinas())) {
                                                soluciones.add(e.getPosicionReinas());
                                                e.verTablero();
                                            }
                                        }
                                        e.inicializarTablero();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Object s : soluciones) {
            System.out.println(s);
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        solveBusquedaExaustiva();
    }
}
