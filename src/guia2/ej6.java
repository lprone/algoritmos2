package guia2;

import java.util.ArrayList;

/**
 * @author lprone
 */
public class ej6 {

    /**
     * @param n
     * @return
     */
    private boolean esCapicua(int n) {
        String aux = null;
        if (n >= 0 && n < 10) {
            aux = "0000" + (n);
        }
        if (n >= 10 && n < 110) {
            aux = "000" + (n);
        }
        if (n >= 100 && n < 1000) {
            aux = "00" + (n);
        }
        if (n >= 1000 && n < 10000) {
            aux = "0" + (n);
        }
        if (n >= 10000 && n < 100000) {
            aux = (Integer.toString(n));
        }
        boolean ret = true;
        for (int i = 0; i < 2; i++) {
            assert aux != null;
            if (aux.charAt(i) != aux.charAt(aux.length() - i - 1)) {
                ret = false;
            }
        }
        return ret;
    }

    /**
     * @return
     */
    private ArrayList generarCapicuas() {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            if (esCapicua(i)) {
                ret.add(i);
            }
        }
        return ret;
    }

    /**
     * @param aux
     * @return
     */
    private ArrayList ordenarCapicuas(ArrayList<Integer> aux) {
        ArrayList<Integer> ret = aux;
        ret.sort(Integer::compareTo);
        return ret;
    }

    /**
     * @param aux
     * @return
     */
    private int buscarMenorDiferencia(ArrayList aux) {
        int min = 99999;
        for (int i = 0; i < aux.size() - 1; i++) {
            if (((Integer) aux.get(i + 1) - (Integer) aux.get(i)) < min) {
                min = (Integer) aux.get(i + 1) - (Integer) aux.get(i);
                System.out.println(aux.get(i + 1) + " - " + aux.get(i));
            }
        }
        return min;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ej6 e = new ej6();
        ArrayList cap = e.generarCapicuas();
        ArrayList ord = e.ordenarCapicuas(cap);
        System.out.println(e.buscarMenorDiferencia(ord));
    }
}
