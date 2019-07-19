package guia4;

import java.util.LinkedList;

/**
 * @author lprone
 */
public class ej3 {

    /**
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
     * @param args
     */
    public static void main(String[] args) {
        long time_start, time_end;

        time_start = System.currentTimeMillis();
        ej3 e = new ej3();
        System.out.printf("%.0f \n", e.fibo(1475));
        time_end = System.currentTimeMillis();
        System.out.println("the task has taken " + (time_end - time_start) / 1000 + " seconds");
    }
}
