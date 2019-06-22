package varios;

import java.util.ArrayList;

/**
 * @author lprone
 */
public class FiboDc {

    /**
     * @param in
     * @return
     */
    private boolean isBase(int in) {
        return in == 0 || in == 1;
    }

    /**
     * @param elem
     * @return
     */
    private int base(int elem) {
        return 1;
    }

    /**
     * @param a
     * @return
     */
    private ArrayList<Integer> split(int a) {
        ArrayList<Integer> ret = new ArrayList<>();
        int p1 = a - 1;
        int p2 = a - 2;
        ret.add(p1);
        ret.add(p2);
        return ret;
    }

    /**
     * @param l
     * @return
     */
    private int join(ArrayList<Integer> l) {
        int aux = 0;
        for (int elem : l) {
            aux += elem;
        }
        return aux;
    }

    /**
     * @param a
     * @return
     */
    private int fibo(int a) {

        ArrayList<Integer> sp = new ArrayList<>();
        sp.add(a);
        ArrayList<Integer> cb = new ArrayList<>();

        while (!sp.isEmpty()) {
            if (isBase(sp.get(0))) {
                cb.add(sp.get(0));
            } else {
                sp.add(split(sp.get(0)).get(0));
                sp.add(split(sp.get(0)).get(1));
            }
            sp.remove(0);
        }
        return join(map(cb));
    }

    /**
     * @param cb
     * @return
     */
    private ArrayList<Integer> map(ArrayList<Integer> cb) {
        ArrayList<Integer> sols = new ArrayList<>();
        for (int is : cb) {
            sols.add(base(is));
        }
        return sols;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        FiboDc b = new FiboDc();
        System.out.println(b.fibo(27));
    }
}
