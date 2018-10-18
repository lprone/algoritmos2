package guia4.tubos;

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
    private ej5(ArrayList<Integer> a) {
        adyacencia = new int[a.size()][a.size()];
    }

    /**
     *
     * @param t1
     * @param t2
     * @return
     */
    private int costoUnir(int t1, int t2) {
        return (t1 == t2) ? t1 : 2 * Math.max(t1, t2);
    }

    /**
     *
     * @param tubos
     */
    public void inicializarUniones(ArrayList<Integer> tubos) {
        for (int i = 0; i < adyacencia.length; i++) {
            for (int j = i; j < adyacencia.length; j++) {
                if (i == j) {
                    adyacencia[i][j] = 0;
                } else {
                    adyacencia[i][j] = costoUnir(tubos.get(i), tubos.get(j));
                }

//                System.out.println(costoUnir(tubos.get(j), tubos.get(p)));
            }
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
     * @param tubos
     */
    private void une(ArrayList<Integer> tubos) {
//        for j= 1 to n
//        N[j,j] = 0
//        – for l = 2 to n
//        for j = 1 to n-l+1
//        p=j+l-1
//        N[j,p] = inf. 
//        for i=j to p-1
//        q=N[j,i] + N[i+1,p] + pi-1pkpj
//        if q < m[j,p]
//        m[j,p] = q
//        s[j,p] = i

        for (int l = 1; l < adyacencia.length - 1; l++) {
            for (int i = 1; i < adyacencia.length - l - 1; i++) {
                int j = i + l;
//                adyacencia[j][p] = Integer.MAX_VALUE;
                for (int k = i; k < j - 1; k++) {
                    int q = adyacencia[i][k] + adyacencia[k + 1][j] + (tubos.get(i - 1) * tubos.get(k) * tubos.get(j));
                    if (q < adyacencia[i][j]) {
                        adyacencia[i][j] = q;
                    }
                }
            }

        }

    }

    /**
     *
     * @param tubos
     */
    private void unir(ArrayList<Integer> tubos) {
        for (int l = 0; l < adyacencia.length - 1; l++) {
            for (int i = 0; i <= adyacencia.length - l; i++) {
                int j = i + l;
                for (int k = i; k < j; k++) {
                    System.out.println(i + " - " + j + " - " + k);
                    int t = adyacencia[i][k] + adyacencia[k + 1][j] + (tubos.get(i - 1) * tubos.get(k) * tubos.get(j));
                    System.out.println(adyacencia[i][j] + " " + t);
                    if (t < adyacencia[i][j]) {

                        adyacencia[i][j] = t;
                    }
                }
            }
        }
        System.out.println();
    }

    /**
     *
     * @param tubos
     */
    private void floydWarshall(ArrayList<Integer> tubos) {
        for (int i = 0; i < adyacencia.length; i++) {
            int minimo;
            for (int j = i + 1; j < adyacencia.length; j++) {
                int aux;
                minimo = Integer.MAX_VALUE;
                for (int p = 0; p < adyacencia.length; p++) {
                    int m = costoUnir(tubos.get(i), tubos.get(p)) + costoUnir(tubos.get(p), tubos.get(j));
                    aux = adyacencia[i][p] + adyacencia[p][j] + m;
//                    adyacencia[j][p] = Math.min(adyacencia[j][p], m);
                    minimo = Math.min(aux, minimo);
                }
                adyacencia[i][j] = minimo;
            }

        }
    }

    /**
     *
     * @param tubos
     * @return
     */
    public int lalala(ArrayList<Integer> tubos) {
        int N = adyacencia.length;
        for (int j = 1; j < adyacencia.length; j++) {
            for (int i = 0; i < adyacencia.length - j; i++) {
                int aux;
                int minimo;
                minimo = Integer.MAX_VALUE;
                for (int k = i + 1; k <= i + j; k++) {
//                    System.out.println(j+" "+(p+j)+" "+i);

//                    int m = costoUnir(tubos.get(j), tubos.get(i)) + costoUnir(tubos.get(i), tubos.get(p));
                    int m = costoUnir(tubos.get(i), tubos.get(k)) + costoUnir(tubos.get(k), tubos.get(j));
                    aux = adyacencia[i][k] + adyacencia[k][j] + m;
//                    System.out.println(aux + " " + m);
                    if (aux < minimo) {
                        minimo = aux;
                    }
                }
                adyacencia[i][j] = minimo;
            }
        }
        return adyacencia[0][N - 1];
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList();
        a.add(1);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(1);
//        a.add(1);
//        a.add(1);
//        a.add(1);
//        a.add(1);
//        a.add(1);
        ej5 e = new ej5(a);

//        e.inicializarUniones(a);
        e.mostrarMatriz(e.adyacencia);
        System.out.println("..............");
        e.floydWarshall(a);

        e.mostrarMatriz(e.adyacencia);

        System.out.println("^^^^^^^^^^^^^^^^");
        System.out.println(e.adyacencia[1][a.size() - 2]);

    }
}
