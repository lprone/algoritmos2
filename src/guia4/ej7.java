/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia4;

/**
 *
 * @author lprone
 */
public class ej7 {

    public int computeLevenshteinDistance(String str1, String str2) {
        int[][] distance = new int[str1.length() + 1][];
        int repi, repj;

        for (int i = 0; i <= str1.length(); i++) {
            distance[i] = new int[str2.length() + 1];
            distance[i][0] = i;
        }
        for (int j = 0; j < str2.length() + 1; j++) {
            distance[0][j] = j;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                distance[i][j] = minimum(distance[i - 1][j] + 1,
                        distance[i][j - 1] + 1,
                        distance[i - 1][j - 1] + ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1));
            }
        }
        repi = str1.length();
        repj = str2.length();
        while (!(repi == 0 && repj == 0)) {
            if (repi == 0) {
                System.out.println("Insertar " + str2.charAt(repj - 1) + " en posicion " + Integer.toString(repi));
                repj--;
            } else {
                if (repj == 0) {
                    System.out.println("Eliminar " + str1.charAt(repi - 1) + " en posicion " + Integer.toString(repi - 1));
                    repi--;
                } else {
                    int o1 = distance[repi - 1][repj] + 1;
                    int o2 = distance[repi][repj - 1] + 1;
                    int o3 = distance[repi - 1][repj - 1];
                    if (minimum(o1, o2, o3) == o1) {
                        System.out.println("Eliminar " + str1.charAt(repi - 1) + " en posicion " + Integer.toString(repi - 1));
                        repi--;
                    } else {
                        if (minimum(o1, o2, o3) == o2) {
                            System.out.println("Insertar " + str2.charAt(repj - 1) + " en posicion " + Integer.toString(repi - 1));
                            repj--;
                        } else {
                            if (str1.charAt(repi - 1) != str2.charAt(repj - 1)) {
                                System.out.println("Reemplazar la " + str1.charAt(repi - 1) + " por " + str2.charAt(repj - 1));
                            };
                            repi--;
                            repj--;
                        }
                    }
                }
            }
        }

        return distance[str1.length()][str2.length()];
    }

    private int minimum(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        }
        if (b <= a && b <= c) {
            return b;
        }
        return c;
    }

    public static void main(String[] args) {
        ej7 e = new ej7();
        e.computeLevenshteinDistance("auto", "casa");
    }
}
