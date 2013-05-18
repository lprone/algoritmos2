/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia4;

/**
 *
 * @author lprone
 */
public class ej2BN {

    private double[][] triangulo(int n) {
        double[][] matriz = new double[n + 1][];
        matriz[0] = new double[]{1};

        for (int k = 1; k < matriz.length; k++) {
            matriz[k] = new double[k + 1];
            matriz[k][0] = matriz[k][k] = 1;
            for (int i = 1; i < k; i++) {
                matriz[k][i] = matriz[k - 1][i - 1] + matriz[k - 1][i];
            }
        }
        return matriz;
    }

    public double combDP(int m, int n) {
        return triangulo(m)[m][n];
    }

    private int fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public int comb(int m, int n) {
        return fact(m) / (fact(n) * fact(m - n));
    }

    public static void main(String[] args) {
        ej2BN e = new ej2BN();
        int m = 1269, n = 1265;
//        System.out.println(e.combDP(m, n));
        System.out.printf("%.0f \n", e.combDP(m, n));
//        System.out.println(e.comb(m, n));

    }
}
