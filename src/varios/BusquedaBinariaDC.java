package varios;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author lprone
 */
public class BusquedaBinariaDC {

    /**
     *
     * @param in
     * @return
     */
    private boolean isBase(int[] in) {
        return in.length == 1;
    }

    /**
     *
     * @param in
     * @param elem
     * @return
     */
    private boolean base(int[] in, int elem) {
        System.out.println("base: " + in[0]);
        return in[0] == elem;
    }

    /**
     *
     * @param a
     * @return
     */
    private ArrayList<int[]> split(int[] a) {
        ArrayList<int[]> ret = new ArrayList<>();
        int[] aux1;
        int[] aux2;
        aux1 = new int[a.length / 2];
        System.arraycopy(a, 0, aux1, 0, a.length / 2);
        if (a.length % 2 == 0) {
            aux2 = new int[a.length / 2];
            System.arraycopy(a, a.length / 2, aux2, 0, a.length / 2);
        } else {
            aux2 = new int[(a.length / 2) + 1];
            System.arraycopy(a, a.length / 2, aux2, 0, (a.length / 2) + 1);
        }
        ret.add(aux1);
        ret.add(aux2);
        return ret;
    }

    /**
     *
     * @param l
     * @return
     */
    private boolean join(ArrayList<Boolean> l) {
        boolean aux = false;
        for (int i = 0; i < l.size(); i++) {
            aux = aux || l.get(i);
        }
        return aux;
    }

    /**
     *
     * @param a
     * @param e
     * @return
     */
    private boolean busquedaBinaria(int[] a, int e) {

        ArrayList<int[]> sp = new ArrayList(Arrays.asList(a));
        ArrayList<int[]> cb = new ArrayList();

        while (!sp.isEmpty()) {
            if (isBase(sp.get(0))) {
                cb.add(sp.get(0));
            } else {
                if (e >= split(sp.get(0)).get(1)[0]) {
                    System.out.println("get(1)");
                    sp.add(split(sp.get(0)).get(1));
                } else {
                    System.out.println("get(0)");
                    sp.add(split(sp.get(0)).get(0));
                }
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
        return join(mapBase(cb, e));
    }

    /**
     *
     * @param cb
     * @param e
     * @return
     */
    private ArrayList<Boolean> mapBase(ArrayList<int[]> cb, int e) {
        ArrayList<Boolean> sols = new ArrayList();
        for (int[] is : cb) {
            sols.add(base(is, e));
        }
        return sols;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        BusquedaBinariaDC b = new BusquedaBinariaDC();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(b.busquedaBinaria(a, 0));
    }
}
