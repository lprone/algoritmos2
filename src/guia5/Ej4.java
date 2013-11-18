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
class Persona implements Comparable {

    String nombre;
    int tiempo;

    /**
     *
     * @param nombre
     * @param tiempo
     */
    public Persona(String nombre, int tiempo) {
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        return this.tiempo - ((Persona) o).tiempo;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return nombre + " - " + tiempo;
    }
}

/**
 *
 * @author lprone
 */
public class Ej4 {

    /**
     *
     * @param personas
     * @param t
     * @return
     */
    static boolean cruzarRio(ArrayList<Persona> personas, int t) {
        int tTotal = 0;
        Collections.sort(personas);
        Persona best = personas.get(0);
        personas.remove(0);
        while (!personas.isEmpty()) {
            tTotal += personas.get(0).tiempo + best.tiempo;
            System.out.println("cruzan " + personas.get(0).nombre + " y " + best.nombre);
            System.out.println("vuelve " + best.nombre);
            personas.remove(0);
        }
        System.out.println("Tiempo total: " + tTotal);
        return tTotal <= t;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList();
        personas.add(new Persona("indiana", 1));
        personas.add(new Persona("novia", 2));
        personas.add(new Persona("padre", 4));
        personas.add(new Persona("suegro", 5));

        System.out.println(cruzarRio(personas, 17));
    }
}
