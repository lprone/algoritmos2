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

    private final String descripcion;
    private final int hi, hf, p;

    /**
     *
     * @param descripcion
     * @param hi
     * @param hf
     * @param p
     */
    public Cita(String descripcion, int hi, int hf, int p) {
        this.descripcion = descripcion;
        this.hi = hi;
        this.hf = hf;
        this.p = p;
    }

    /**
     *
     * @return
     */
    public int getP() {
        return p;
    }

    /**
     *
     * @return
     */
    public int getHf() {
        return hf;
    }

    /**
     *
     * @return
     */
    public int getHi() {
        return hi;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return descripcion + " - " + hi + " - " + hf + " - " + p;
    }

    /**
     *
     * @param other
     * @return
     */
    @Override
    public int compareTo(Object other) {
        return this.p - ((Cita) other).p;
    }
}

/**
 *
 * @author lprone
 */
public class Ej3 {

    /**
     *
     * @param citas
     * @return
     */
    private static ArrayList<Cita> organizarAgenda(ArrayList<Cita> citas) {
        Collections.sort(citas);
        Collections.reverse(citas);
        ArrayList<Cita> sol = new ArrayList<>();
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

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Cita> citas = new ArrayList<>();
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
