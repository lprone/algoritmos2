/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1;

/**
 *
 * @author lprone
 */
public class ej5 {
    
    private int[][] tablero = new int[8][8];

    public boolean posValida(int x, int y) {
        return tablero[x][y] != 1;
    }
    
    public void setReina(int x, int y){
        for (int i = 0; i < 7; i++) {
            tablero[i][y] = 1;            
        }
        for (int i = 0; i < 7; i++) {
            tablero[x][i] = 1;            
        }
        while (true) {            
            
        }
    }
}
