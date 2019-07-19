package guia1;

/**
 * @author lprone
 */
public class ej8 {

    /**
     *
     */
    private void fiboLong() {
        long f1 = 1;
        long f2 = 1;
        long fn = f1 + f2;
        while (fn > 0) {
            f1 = f2;
            f2 = fn;
            fn = f1 + f2;
            System.out.println(fn);
        }
    }

    /**
     *
     */
    private void fiboInt() {
        int f1 = 1;
        int f2 = 1;
        int fn = f1 + f2;
        while (fn > 0) {
            f1 = f2;
            f2 = fn;
            fn = f1 + f2;
            System.out.println(fn);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        long time_start, time_end;

        ej8 e = new ej8();
        time_start = System.currentTimeMillis();
        e.fiboInt();
        time_end = System.currentTimeMillis();
        System.out.println("the task has taken " + (time_end - time_start) / 1000 + " seconds");

        System.out.println("---------------------------");
        time_start = System.currentTimeMillis();
        e.fiboLong();
        time_end = System.currentTimeMillis();
        System.out.println("the task has taken " + (time_end - time_start) / 1000 + " seconds");
    }
}
