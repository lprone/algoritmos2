/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1;

/**
 *
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

    public static void main(String[] args) {
        ej8 e = new ej8();
        e.fiboInt();
        System.out.println("---------------------------");
        e.fiboLong();
    }
}
