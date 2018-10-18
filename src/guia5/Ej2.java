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
class Moneda implements Comparable {

    private final int valor;

    /**
     *
     * @param valor
     */
    public Moneda(int valor) {
        this.valor = valor;
    }

    /**
     *
     * @return
     */
    public int getValor() {
        return this.valor;
    }

    /**
     *
     * @param other
     * @return
     */
    @Override
    public int compareTo(Object other) {
        return ((Moneda) other).valor - this.valor;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}

/**
 *
 * @author lprone
 */
public class Ej2 {

    /**
     *
     * @param monedas
     * @param precio
     * @return
     */
    private static ArrayList<Moneda> cambio(ArrayList<Moneda> monedas, int precio) {
        Collections.sort(monedas);
        int retornado = 0;
        ArrayList<Moneda> vuelto = new ArrayList();

        for (Moneda m : monedas) {
            while (m.getValor() <= precio - retornado) {
                vuelto.add(m);
                retornado += m.getValor();
            }
        }
        return vuelto;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Moneda> monedas = new ArrayList();
        monedas.add(new Moneda(25));
        monedas.add(new Moneda(1));
        monedas.add(new Moneda(10));

        for (Moneda moneda : Ej2.cambio(monedas, 68)) {
            System.out.println(moneda.toString());
        }

    }
}
