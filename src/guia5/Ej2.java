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

    int valor;

    public Moneda(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    @Override
    public int compareTo(Object other) {
        return ((Moneda) other).valor - this.valor;
    }

    public String toString() {
        return String.valueOf(valor);
    }
}

public class Ej2 {

    public static ArrayList<Moneda> cambio(ArrayList<Moneda> monedas, int precio) {
        Collections.sort(monedas);
        int retornado = 0;
        ArrayList<Moneda> vuelto = new ArrayList();

        for (int i = 0; i < monedas.size(); i++) {
            Moneda m = monedas.get(i);
            while (m.getValor() <= precio - retornado) {
                vuelto.add(m);
                retornado += m.getValor();
            }
        }
        return vuelto;
    }

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
