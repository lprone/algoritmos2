package guia3;

import java.awt.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author lprone
 */
public class Ej10 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int x = Integer.valueOf(JOptionPane.showInputDialog("X: "));
        int y = Integer.valueOf(JOptionPane.showInputDialog("Y: "));

        Triomino t = new Triomino();
        Game g = new Game(t);
        View v = new View();
        g.addObs(v);
        v.setVisible(true);
    }
}

class Game {

    private static Triomino game;

    /**
     *
     * @param t
     */
    public Game(Triomino t) {
        game = t;
    }

    /**
     *
     * @param o
     */
    public void addObs(Observer o) {
        game.addObserver(o);
    }

    /**
     *
     * @return
     */
    public static int[][] getBoard() {
        return game.getBoard();
    }

    /**
     *
     * @param x
     * @param y
     */
    public static void init(int x, int y) {
        game.init(x, y);
    }

    /**
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     */
    public void set(int x1, int y1, int x2, int y2, int x3, int y3) {
        game.set(x1, y1, x2, y2, x3, y3);
    }

    /**
     *
     */
    public static void solve() {
        if (!game.end()) {
            game.solve();
        }

    }
}

class Chip {

    private final Point p1;
    private final Point p2;
    private final Point p3;

    /**
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     */
    public Chip(int x1, int y1, int x2, int y2, int x3, int y3) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
        p3 = new Point(x3, y3);
    }

    /**
     *
     * @return
     */
    public LinkedList<Point> getChip() {
        LinkedList<Point> ret = new LinkedList<>();
        ret.add(p1);
        ret.add(p2);
        ret.add(p3);
        return ret;
    }

    @Override
    public String toString() {
        return "P1: x=" + p1.x + " y=" + p1.y + "\n"
                + "P2: x=" + p2.x + " y=" + p2.y + "\n"
                + "P3: x=" + p3.x + " y=" + p3.y;
    }
}

class Triomino extends Observable {

    private final LinkedList result;
    private final int[][] board;
    private int count;

    /**
     *
     * @return
     */
    public int[][] getBoard() {
        return board;
    }

    public LinkedList getSolution() {
        return result;
    }

    /**
     *
     */
    public Triomino() {
        board = new int[8][8];
        result = new LinkedList<>();
        count = 0;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void init(int x, int y) {
        board[x][y] = 1;
        count++;
        setChanged();
        notifyObservers();
    }

    /**
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     */
    public void set(int x1, int y1, int x2, int y2, int x3, int y3) {
        board[x1][y1] = 1;
        board[x2][y2] = 1;
        board[x3][y3] = 1;
        count += 3;
        setChanged();
        notifyObservers();
    }

    /**
     *
     */
    public void view() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }

    /**
     *
     * @return
     */
    public boolean end() {
        return count == 64;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public boolean free(int x, int y) {
        return board[x][y] != 1;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private int getCuadrant(int x, int y) {
        return (y / 2) + (x * board.length - 1 / 2);
    }

    /**
     *
     * @param x
     * @param y
     */
    private void paintNeighbour(int x, int y) {
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private boolean leftBorder(int x, int y) {
        return x == 0;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private boolean rightBorder(int x, int y) {
        return x == board.length - 1;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private boolean topBorder(int x, int y) {
        return y == 0;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private boolean buttonBorder(int x, int y) {
        return y == board.length - 1;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private boolean inBorder(int x, int y) {
        return x == 0 || y == 0 || x == board.length - 1 || y == board.length - 1;
    }

    /**
     * IMPLEMENTAR
     *
     * @param x
     * @param y
     * @return
     */
    private boolean freeNeighbour(int x, int y) {
        return true;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private boolean isFull(int x, int y) {
        int i = x % 2 == 0 ? x : x - 1;
        int j = y % 2 == 0 ? y : y - 1;
        return board[i][j] == 1
                && board[i + 1][j] == 1
                && board[i][j + 1] == 1
                && board[i + 1][j + 1] == 1;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private boolean isEmpty(int x, int y) {
        int i = x % 2 == 0 ? x : x - 1;
        int j = y % 2 == 0 ? y : y - 1;
        return board[i][j] == 1
                || board[i + 1][j] == 1
                || board[i][j + 1] == 1
                || board[i + 1][j + 1] == 1;
    }

    /**
     *
     */
    public void solve() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (topBorder(i, j) && freeNeighbour(i, j)) {
                    paintNeighbour(i, j);
                    return;
                }
            }
        }
    }
}

class View extends javax.swing.JFrame implements Observer {

    /**
     *
     */
    private final javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
    });

    /**
     * Creates new form Ej10
     */
    public View() {
        initComponents();
        setLocationRelativeTo(null);
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", ""
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setMinimumSize(new java.awt.Dimension(128, 128));
        jTable1.setPreferredSize(new java.awt.Dimension(128, 128));
        jTable1.setRowSelectionAllowed(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        for (int i = 0; i < Game.getBoard().length; i++) {
            for (int j = 0; j < Game.getBoard().length; j++) {
                jTable1.setValueAt(Game.getBoard()[i][j] == 0 ? "" : "1", i, j);
            }
        }
    }
}
