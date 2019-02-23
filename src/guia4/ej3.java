package guia4;

import java.util.LinkedList;

/**
 *
 * @author lprone
 */
public class ej3 {

    /**
     *
     * @param n
     * @return
     */
    private double fibo(double n) {

        if (n == 0 || n == 1) {
            return 1;
        } else {
            LinkedList<Double> fibos = new LinkedList<>();
            fibos.add(0, 1d);
            fibos.add(1, 1d);
            for (int i = 2; i <= n; i++) {
                fibos.add(i, (fibos.get(i - 1) + fibos.get(i - 2)));
            }
            return fibos.get((int) n);
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ej3 e = new ej3();
        System.out.printf("%.0f \n", e.fibo(1475));
    }
}
