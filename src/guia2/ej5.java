package guia2;

/**
 *
 * @author lprone
 */
public class ej5 {

    private final int tablero[][] = new int[8][8];
    private int reinas = 0;
    private final int reina = 8;
    private final int disponible = 0;
    private final int noDisponible = 1;

    /**
     *
     * @return
     */
    private boolean tableroLleno() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (posicionPermitida(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

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
     * @return
     */
    private int getReinas() {
        return reinas;
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
        tablero[x][y] = reina;
        reinas++;
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
        reinas = 0;
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
        return tablero[x][y] == disponible;
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
     */
    private static void solve() {
        ej5 e = new ej5();
        e.inicializarTablero();
        int i, j;
        while (e.getReinas() != 8) {
            i = new Double(Math.random() * 8).intValue();
            j = new Double(Math.random() * 8).intValue();
            if (e.posicionPermitida(i, j)) {
                e.setReina(i, j);
            }
            if (e.tableroLleno() && e.getReinas() != 8) {
                e.inicializarTablero();
            }
        }
        e.verTablero();
        System.out.println(e.getPosicionReinas());
    }

    /**
     *
     */
    public static void solve2() {
        ej5 e = new ej5();
        e.inicializarTablero();
        int a, b;
        while (e.getReinas() < 8) {
            for (int f = 0; f < 8; f++) {
                for (int c = 0; c < 8; c++) {
                    e.inicializarTablero();
                    a = new Double(Math.random() * 8).intValue();
                    b = new Double(Math.random() * 8).intValue();
                    e.setReina(a, b);
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (e.posicionPermitida(i, j)) {
                                e.setReina(i, j);
                            }
                        }
                    }
                }
            }
        }
        e.verTablero();
        System.out.println(e.getPosicionReinas());
    }

    /**
     *
     */
    public void testSolution() {
        ej5 e = new ej5();
        e.inicializarTablero();
        e.verTablero();
        e.setReina(1, 1);
        e.setReina(7, 0);
        e.setReina(0, 4);
        e.setReina(2, 3);
        e.setReina(4, 2);
        e.setReina(3, 6);
        e.setReina(5, 7);
        e.setReina(6, 5);
        e.verTablero();
        System.out.println(e.getReinas());
        System.out.println(e.getPosicionReinas());
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        solve();
    }
}
