/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia5;

import java.util.ArrayList;

/**
 *
 * @author lprone
 */
class Pair<A, B> {

    A a;
    B b;

    /**
     *
     * @param a
     * @param b
     */
    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return a + " - " + b;
    }
}

public class Ej7 {

    /**
     *
     * @param nodos
     * @param aristas
     * @param colores
     * @return
     */
    public static ArrayList<Pair<String, String>> colorear(ArrayList<String> nodos, ArrayList<Pair<Integer, Integer>> aristas, ArrayList<String> colores) {
        int colorUsado = 5;
        int[][] matrizAdyacencia = new int[nodos.size()][nodos.size()];
        for (Pair p : aristas) {
            matrizAdyacencia[(int) p.a][(int) p.b] = matrizAdyacencia[(int) p.b][(int) p.a] = 1;
        }
        verMatriz(matrizAdyacencia);
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
        verMatriz(matrizAdyacencia);                
        ArrayList<Pair<String, String>> ret = new ArrayList();
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            ret.add(new Pair(nodos.get(i), colores.get(matrizAdyacencia[i][i] - 5)));
        }
        return ret;
    }

    /**
     *
     * @param matriz
     */
    public static void verMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ArrayList<String> nodos = new ArrayList();
        ArrayList<Pair<Integer, Integer>> aristas = new ArrayList();
        ArrayList<String> colores = new ArrayList();

        colores.add("azul");
        colores.add("amarillo");
        colores.add("verde");
        colores.add("rojo");

        nodos.add(0,"A");
        nodos.add(1,"B");
        nodos.add(2,"C");
        nodos.add(3,"D");
        nodos.add(4,"E");

        aristas.add(new Pair(0, 1));
        aristas.add(new Pair(0, 2));
        aristas.add(new Pair(0, 3));
        aristas.add(new Pair(2, 4));
        aristas.add(new Pair(1, 2));
        aristas.add(new Pair(4, 1));

        for (Pair<String, String> a : colorear(nodos, aristas, colores)) {
            System.out.println(a);
        }
    }
}
