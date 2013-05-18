/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package varios;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author lprone
 */
public class inversiones {

    private boolean isBase(int[] a) {
        return a.length == 2;
    }

    private int base(int[] a) {
//        System.out.print("base: ");
//        for (int j = 0; j < a.length; j++) {
//            System.out.print(a[j] + " ");
//        }
//        System.out.println("");
        return (a[0] > a[1]) ? 1 : 0;
    }

    private ArrayList<int[]> split(int[] a) {
        ArrayList<int[]> ret = new ArrayList();
        int[] aux1 = new int[2];
        int[] aux2 = new int[a.length - 1];
        System.arraycopy(a, 0, aux1, 0, 2);
        System.arraycopy(a, 1, aux2, 0, a.length - 1);
        ret.add(aux1);
        ret.add(aux2);
        return ret;
    }

    private int join(ArrayList<Integer> in) {
        int ret = 0;
        for (int j = 0; j < in.size(); j++) {
            ret += in.get(j);
        }
        return ret;
    }

    public int inversiones(int[] in) {

        // join(map (inversiones (split isbase base)))
        ArrayList<int[]> sp = new ArrayList(Arrays.asList(in));
        ArrayList<int[]> cb = new ArrayList();

        while (!sp.isEmpty()) {
            if (isBase(sp.get(0))) {
                cb.add(sp.get(0));
            } else {
                sp.add(split(sp.get(0)).get(0));
                sp.add(split(sp.get(0)).get(1));
            }
            sp.remove(0);

            for (int[] p : sp) {
                for (int j : p) {
                    System.out.print(j + " ");
                }
                System.out.print(" -  ");
            }
            System.out.println("");
        }
        return join(map(cb));
    }

    private ArrayList<Integer> map(ArrayList<int[]> cb) {
        ArrayList<Integer> sols = new ArrayList();
        for (int[] is : cb) {
            sols.add(base(is));
        }
        return sols;
    }

    public static void main(String[] args) {
        inversiones i = new inversiones();
        int[] a = {1, 4, 3, 2, 1};
        System.out.println(i.inversiones(a));
    }
}
