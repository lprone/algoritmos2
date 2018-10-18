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
class Arista implements Comparable {

    private final String nodeA;
    private final String nodeB;
    private final int costo;

    /**
     *
     * @param nodeA
     * @param nodeB
     * @param costo
     */
    public Arista(String nodeA, String nodeB, int costo) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.costo = costo;
    }

    /**
     *
     * @return
     */
    public String getNodeA() {
        return nodeA;
    }

    /**
     *
     * @return
     */
    public String getNodeB() {
        return nodeB;
    }

    /**
     *
     * @return
     */
    public int getCosto() {
        return costo;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return nodeA + " - " + nodeB + " - " + costo;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        return costo - ((Arista) o).costo;
    }
}

/**
 *
 * @author lprone
 */
public class MST {

    /**
     *
     * @param aristas
     * @param nodos
     * @return
     */
    private static ArrayList<Arista> kruskal(ArrayList<Arista> aristas, ArrayList<String> nodos) {
        Collections.sort(aristas);
        ArrayList<Arista> mst = new ArrayList();
        ArrayList<String> unidos = new ArrayList();
        for (Arista a : aristas) {
            if (!unidos.contains(a.getNodeA()) || !unidos.contains(a.getNodeB())) {
                mst.add(a);
                unidos.add(a.getNodeA());
                unidos.add(a.getNodeB());
            }
        }
        return mst;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Arista> aristas = new ArrayList();
        ArrayList<String> nodosSet = new ArrayList();
        nodosSet.add("A");
        nodosSet.add("B");
        nodosSet.add("C");
        nodosSet.add("D");

        aristas.add(new Arista("A", "D", 1));
        aristas.add(new Arista("B", "D", 3));
        aristas.add(new Arista("C", "B", 6));
        aristas.add(new Arista("C", "A", 5));
        aristas.add(new Arista("B", "A", 2));

        for (Arista a : kruskal(aristas, nodosSet)) {
            System.out.println(a);
        }

    }
}
