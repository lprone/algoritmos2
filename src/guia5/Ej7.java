/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia5;

import java.util.ArrayList;

/**
 *
 * @author lprone
 */
class Node {

    String name;
    int color;
    ArrayList<Node> adyacentes = new ArrayList();

    /**
     * 
     * @param name
     * @param color 
     */
    public Node(String name, int color) {
        this.name = name;
        this.color = color;
    }

    /**
     * 
     * @param color 
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return String.valueOf(color);
    }
}

class Edge {

    Node a, b;

    /**
     * 
     * @param a
     * @param b 
     */
    public Edge(Node a, Node b) {
        this.a = a;
        this.b = b;
    }

    /**
     * 
     * @return 
     */
    public Node getA() {
        return a;
    }

    /**
     * 
     * @return 
     */
    public Node getB() {
        return b;
    }
}

public class Ej7 {

    /**
     * 
     * @param grafo
     * @return 
     */
    public static ArrayList<Node> colorear(ArrayList<Edge> grafo) {
        ArrayList<Node> coloreados = new ArrayList();
        int ultimoColorUsado = 0;
        while (true) {
            for (Edge e : grafo) {
                if (e.a.color == -1 && e.b.color == -1) {
                    e.a.color = ultimoColorUsado;
                    coloreados.add(e.a);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge> grafo = new ArrayList();
        grafo.add(new Edge(new Node("A", -1), new Node("B", -1)));
        grafo.add(new Edge(new Node("A", -1), new Node("C", -1)));
        grafo.add(new Edge(new Node("C", -1), new Node("B", -1)));
        grafo.add(new Edge(new Node("C", -1), new Node("D", -1)));
        System.out.println(colorear(grafo));
    }
}
