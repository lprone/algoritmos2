/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia5;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author lprone
 */
class Pair {

    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public String toString() {
        return a + " - " + b;
    }
}

public class Ej7 {

    public static void verTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ArrayList<String> nodos = new ArrayList();
        ArrayList<Pair> aristas = new ArrayList();
        ArrayList<String> colores = new ArrayList();
        int colorUsado = 5;

        colores.add("azul");
        colores.add("amarillo");
        colores.add("verde");
        colores.add("rojo");

        nodos.add("A");
        nodos.add("B");
        nodos.add("C");
        nodos.add("D");
        nodos.add("E");

        aristas.add(new Pair(0, 1));
        aristas.add(new Pair(0, 2));
        aristas.add(new Pair(0, 3));
        aristas.add(new Pair(2, 4));
        aristas.add(new Pair(1, 2));
        aristas.add(new Pair(4, 1));

        int[][] matrizAdyacencia = new int[nodos.size()][nodos.size()];

        for (Pair p : aristas) {
            matrizAdyacencia[p.a][p.b] = matrizAdyacencia[p.b][p.a] = 1;
        }

        verTablero(matrizAdyacencia);

        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = i; j < matrizAdyacencia.length; j++) {
                if (matrizAdyacencia[i][i] == 0) {
                    matrizAdyacencia[i][i] = colorUsado;
                }
                if (matrizAdyacencia[i][j] == 0 && matrizAdyacencia[j][j] == 0) {
                    matrizAdyacencia[j][j] = colorUsado;
                }
            }
            colorUsado++;
        }

        verTablero(matrizAdyacencia);

        for (int i = 0; i < matrizAdyacencia.length; i++) {
            System.out.print("(" + nodos.get(i) + "," + colores.get(matrizAdyacencia[i][i] - 5) + ") ");
        }

    }
}
