/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author lprone
 */
public class ej6 {

    public boolean esCapicua(int n) {
        String aux = null;
        if (n >= 0 && n < 10) {
            aux = "0000" + new String((new Integer(n).toString()));
        }
        if (n >= 10 && n < 110) {
            aux = "000" + new String((new Integer(n).toString()));
        }
        if (n >= 100 && n < 1000) {
            aux = "00" + new String((new Integer(n).toString()));
        }
        if (n >= 1000 && n < 10000) {
            aux = "0" + new String((new Integer(n).toString()));
        }
        if (n >= 10000 && n < 100000) {
            aux = new String((new Integer(n).toString()));
        }
        boolean ret = true;
        for (int i = 0; i < 2; i++) {
            if (aux.charAt(i) != aux.charAt(aux.length() - i - 1)) {
                ret = false;
            }
        }
        return ret;
    }

    public ArrayList generarCapicuas() {
        ArrayList ret = new ArrayList();
        for (int i = 0; i < 100000; i++) {
            if (esCapicua(i)) {                
                ret.add(i);
            }
        }
        return ret;
    }

    public ArrayList ordenarCapicuas(ArrayList aux) {
        ArrayList ret = aux;
        Collections.sort(ret);
        return ret;
    }

    public int buscarMenorDiferencia(ArrayList aux) {
        int min = 99999;
        for (int i = 0; i < aux.size() - 1; i++) {
            if (((Integer) aux.get(i + 1) - (Integer) aux.get(i)) < min) {
                min = (Integer) aux.get(i + 1) - (Integer) aux.get(i);
                System.out.println(aux.get(i + 1) + " - " + (Integer) aux.get(i));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        ej6 e = new ej6();
        ArrayList cap = e.generarCapicuas();
        ArrayList ord = e.ordenarCapicuas(cap);
        System.out.println(e.buscarMenorDiferencia(ord));
    }
}
