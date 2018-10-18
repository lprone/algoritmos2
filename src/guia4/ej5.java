package guia4;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author lprone
 */
public class ej5 {

    private final int[][] adyacencia;

    /**
     *
     * @param a
     */
    private ej5(ArrayList<Point> a) {
        adyacencia = new int[a.size()][a.size()];
    }

    /**
     *
     * @param t1
     * @param t2
     * @return
     */
    private int costoUnir(Point t1, Point t2) {
        if (t1.y == t2.x || t2.y == t1.x) {
            return 0;
        } else {
            return Math.min(Math.abs(t1.y - t2.x), Math.abs(t2.y - t1.x));
        }
    }

    /**
     *
     * @param tubos
     */
    private void inicializarUniones(ArrayList<Point> tubos) {
        for (int i = 0; i < adyacencia.length; i++) {
            for (int j = 0; j < adyacencia.length; j++) {
                adyacencia[i][j] = costoUnir(tubos.get(i), tubos.get(j));
            }
        }

        for (int i = 0; i < adyacencia.length; i++) {
            adyacencia[i][i] = 0;
        }
    }

    /**
     *
     * @param m
     */
    private void mostrarMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     */
    private void floydWarshall() {
        for (int k = 1; k < adyacencia.length; k++) {
            for (int i = 0; i < adyacencia.length; i++) {
                for (int j = 0; j < adyacencia.length; j++) {
                    if ((adyacencia[i][j] > (adyacencia[i][k - 1] + adyacencia[k][j])) && i != j) {
                        adyacencia[i][j] = adyacencia[i][k] + adyacencia[k][j];
                        System.out.println(i + " " + j + " " + adyacencia[i][j]);
                    }
                }
            }
        }
        System.out.println();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Point> a = new ArrayList();
        a.add(new Point(1, 6));
        a.add(new Point(2, 1));
        a.add(new Point(3, 1));
        a.add(new Point(5, 2));

        ej5 e = new ej5(a);
        e.inicializarUniones(a);
        e.mostrarMatriz(e.adyacencia);
        System.out.println("^^^^^^^^^^^^^^^^");
        e.floydWarshall();
        e.mostrarMatriz(e.adyacencia);
        System.out.println("--------");

    }
}
