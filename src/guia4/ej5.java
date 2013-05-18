/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia4;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author lprone
 */
public class ej5 {

    private int[][] adyacencia;

    public ej5(ArrayList<Point> a) {
        adyacencia = new int[a.size()][a.size()];
    }

    private int costoUnir(Point t1, Point t2) {
        if (t1.y == t2.x || t2.y == t1.x) {
            return 0;
        } else {
            return Math.min(Math.abs(t1.y - t2.x), Math.abs(t2.y - t1.x));
        }
    }

    public void inicializarUniones(ArrayList<Point> tubos) {
        for (int i = 0; i < adyacencia.length; i++) {
            for (int j = 0; j < adyacencia.length; j++) {
                adyacencia[i][j] = costoUnir(tubos.get(i), tubos.get(j));
            }
        }

        for (int i = 0; i < adyacencia.length; i++) {
            adyacencia[i][i] = 0;
        }
    }

    public void mostrarMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void floydWarshall() {
        for (int k = 1; k < adyacencia.length; k++) {
            for (int i = 0; i < adyacencia.length; i++) {
                for (int j = 0; j < adyacencia.length; j++) {
                    if ((adyacencia[i][j] > (adyacencia[i][k-1] + adyacencia[k][j])) && i != j) {
                        adyacencia[i][j] = adyacencia[i][k] + adyacencia[k][j];
                        System.out.println(i+" "+j+" "+adyacencia[i][j]);
                    }
                }
            }
        }
        System.out.println("");
    }

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
