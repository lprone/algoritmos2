/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6.problems.ochoReinas;

import guia6.problems.State;

/**
 *
 * @author lprone
 */
public class OchoReinasState implements State {

    int[][] tableroMatriz = new int[8][8];
    int[] tablero = new int[8];

    /**
     *
     * @param tablero
     */
    public OchoReinasState(int t0, int t1, int t2, int t3, int t4, int t5, int t6, int t7) {
        tablero[0] = t0;
        tablero[1] = t1;
        tablero[2] = t2;
        tablero[3] = t3;
        tablero[4] = t4;
        tablero[5] = t5;
        tablero[6] = t6;
        tablero[7] = t7;
    }

    @Override
    public boolean equals(State s) {
        System.out.println(s);
        return tablero[0] == ((OchoReinasState) s).tablero[0]
                && tablero[1] == ((OchoReinasState) s).tablero[1]
                && tablero[2] == ((OchoReinasState) s).tablero[2]
                && tablero[3] == ((OchoReinasState) s).tablero[3]
                && tablero[4] == ((OchoReinasState) s).tablero[4]
                && tablero[5] == ((OchoReinasState) s).tablero[5]
                && tablero[6] == ((OchoReinasState) s).tablero[6]
                && tablero[7] == ((OchoReinasState) s).tablero[7];
    }

    @Override
    public String toString() {
        return tablero[0] + " "
                + tablero[1] + " "
                + tablero[2] + " "
                + tablero[3] + " "
                + tablero[4] + " "
                + tablero[5] + " "
                + tablero[6] + " "
                + tablero[7];
    }
}
