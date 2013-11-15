/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia5;

import java.util.Collections;
import java.util.ArrayList;

/**
 *
 * @author lprone
 */
class Elemento implements Comparable {

    String name;
    int peso;
    int felicidad;
    double felicidadPrecio;

    /**
     *
     * @param name
     * @param peso
     * @param felicidad
     */
    public Elemento(String name, int peso, int felicidad) {
        this.name = name;
        this.peso = peso;
        this.felicidad = felicidad;
        this.felicidadPrecio = new Double(felicidad) / new Double(peso);
        System.out.println(toString());
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public int getPeso() {
        return peso;
    }

    /**
     *
     * @return
     */
    public int getFelicidad() {
        return felicidad;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return name + " - " + peso + " - " + felicidad + " - " + felicidadPrecio;
    }

    /**
     *
     * @param other
     * @return
     */
    @Override
    public int compareTo(Object other) {
//        return this.getFelicidad() / this.getPeso() - ((Elemento) other).getFelicidad() / ((Elemento) other).getPeso();
        if (felicidadPrecio > ((Elemento) other).felicidadPrecio) {
            return 1;
        } else {
            if (felicidadPrecio == ((Elemento) other).felicidadPrecio) {
                return 0;
            }
            return -1;
        }
    }
}

/**
 *
 * @author lprone
 */
public class Ej6 {

    /**
     *
     * @param elementos
     * @param capacidad
     * @return
     */
    public static ArrayList<Elemento> llenarMochila(ArrayList<Elemento> elementos, int capacidad) {
        Collections.sort(elementos);
        ArrayList<Elemento> mochila = new ArrayList();
        int espacioDisponible = capacidad;
        for (int i = elementos.size() - 1; i >= 0; i--) {
            Elemento elemento = elementos.get(i);
            while (elemento.getPeso() <= espacioDisponible) {
                mochila.add(elemento);
                espacioDisponible -= elemento.getPeso();
            }
        }
        return mochila;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Elemento> elementos = new ArrayList();
        elementos.add(new Elemento(null, 4, 8));
        elementos.add(new Elemento(null, 2, 3));

        ArrayList<Elemento> mochila = llenarMochila(elementos, 10);
        System.out.println("##################");
        for (Elemento elemento : mochila) {
            System.out.println(elemento);
        }
    }
}
