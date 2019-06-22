package varios;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author lprone
 */
public class inversiones {

    /**
     * @param a
     * @return
     */
    private boolean isBase(int[] a) {
        return a.length == 2;
    }

    /**
     * @param a
     * @return
     */
    private int base(int[] a) {
        return (a[0] > a[1]) ? 1 : 0;
    }

    /**
     * @param a
     * @return
     */
    private ArrayList<int[]> split(int[] a) {
        ArrayList<int[]> ret = new ArrayList<>();
        int[] aux1 = new int[2];
        int[] aux2 = new int[a.length - 1];
        System.arraycopy(a, 0, aux1, 0, 2);
        System.arraycopy(a, 1, aux2, 0, a.length - 1);
        ret.add(aux1);
        ret.add(aux2);
        return ret;
    }

    /**
     * @param in
     * @return
     */
    private int join(ArrayList<Integer> in) {
        int ret = 0;
        for (Integer anIn : in) {
            ret += anIn;
        }
        return ret;
    }

    /**
     * @param in
     * @return
     */
    private int hacerInversiones(int[] in) {

        // join(map (inversiones (split isbase base)))
        ArrayList<int[]> sp = new ArrayList<>(Collections.singletonList(in));
        ArrayList<int[]> cb = new ArrayList<>();

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
            System.out.println();
        }
        return join(map(cb));
    }

    /**
     * @param cb
     * @return
     */
    private ArrayList<Integer> map(ArrayList<int[]> cb) {
        ArrayList<Integer> sols = new ArrayList<>();
        for (int[] is : cb) {
            sols.add(base(is));
        }
        return sols;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        inversiones i = new inversiones();
        int[] a = {1, 4, 3, 2, 1};
        System.out.println(i.hacerInversiones(a));
    }
}
