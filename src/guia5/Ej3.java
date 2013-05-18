/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia5;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author lprone
 */
class Cita implements Comparable {

    private String descripcion;
    private int hi, hf, p;

    public Cita(String descripcion, int hi, int hf, int p) {
        this.descripcion = descripcion;
        this.hi = hi;
        this.hf = hf;
        this.p = p;
    }

    public int getP() {
        return p;
    }

    public int getHf() {
        return hf;
    }

    public int getHi() {
        return hi;
    }

    @Override
    public String toString() {
        return descripcion + " - " + hi + " - " + hf + " - " + p;
    }

    @Override
    public int compareTo(Object other) {
        return this.p - ((Cita) other).p;
    }
}

public class Ej3 {

    public static ArrayList<Cita> organizarAgenda(ArrayList<Cita> citas) {
        Collections.sort(citas);
        Collections.reverse(citas);
        ArrayList<Cita> sol = new ArrayList();
        int[] dia = new int[24];
        for (Cita cita : citas) {
            boolean posible = true;
            for (int i = cita.getHi(); i <= cita.getHf(); i++) {
                if (dia[i] == 1) {
                    posible = false;
                }
            }
            if (posible) {
                sol.add(cita);
                for (int i = cita.getHi(); i <= cita.getHf(); i++) {
                    dia[i] = 1;
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        ArrayList<Cita> citas = new ArrayList();
        citas.add(new Cita(null, 1, 2, 5));
        citas.add(new Cita(null, 2, 3, 8));
        citas.add(new Cita(null, 1, 5, 3));
        citas.add(new Cita(null, 4, 7, 7));
        citas.add(new Cita(null, 3, 5, 9));
        citas.add(new Cita(null, 5, 6, 1));

        for (Cita cita : citas) {
            System.out.println(cita);
        }

        System.out.println("##################");

        ArrayList<Cita> sol = organizarAgenda(citas);
        for (Cita cita : sol) {
            System.out.println(cita);
        }
    }
}
