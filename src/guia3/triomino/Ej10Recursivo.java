package guia3.triomino;

import java.awt.*;
import java.util.LinkedList;

/**
 *
 * @author lprone
 */
public class Ej10Recursivo {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

//        int n = Integer.valueOf(JOptionPane.showInputDialog("N= "));
//        Point ip = new Point(Integer.valueOf(JOptionPane.showInputDialog("X= ")), Integer.valueOf(JOptionPane.showInputDialog("X= ")));        
        int n = 3;
        Point ip = new Point(4, 4);

        Game g = new Game(n, ip);
        g.cubrir();

        new View().play(g);
    }
}

class Triomino {

    /**
     *
     */
    final Point p1;
    final Point p2;
    final Point p3;

    /**
     *
     * @param p1
     * @param p2
     * @param p3
     */
    public Triomino(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "P1: x=" + p1.x + " y=" + p1.y + " - "
                + "P2: x=" + p2.x + " y=" + p2.y + " - "
                + "P3: x=" + p3.x + " y=" + p3.y;
    }
}

class Game {

    Point initialPoint;
    private final int n;
    final LinkedList<Triomino> result;

    /**
     *
     * @param n
     * @param p
     */
    public Game(int n, Point p) {
        this.initialPoint = p;
        this.n = n;
        result = new LinkedList();
    }

    /**
     *
     */
    public void cubrir() {
        cubrirOffset(n, initialPoint.x, initialPoint.y, 0, 0);
    }

    /**
     *
     * @param n
     * @param x
     * @param y
     * @param ox
     * @param oy
     */
    private void cubrirOffset(int n, int x, int y, int ox, int oy) {
        if (n != 0) {
//            (x > 2^(n-1)) && (y > 2^(n-1))
            if ((x > (2 ^ (n - 1))) && (y > (2 ^ (n - 1)))) {
//                [((2^(n-1)+ox , 2^(n-1)+1+oy) , (2^(n-1)+1+ox , 2^(n-1)+oy) , (2^(n-1)+ox , 2^(n-1)+oy))]
                result.add(new Triomino(
                        new Point(2 ^ (n - 1) + ox, 2 ^ (n - 1) + 1 + oy),
                        new Point(2 ^ (n - 1) + 1 + ox, 2 ^ (n - 1) + oy),
                        new Point(2 ^ (n - 1) + ox, 2 ^ (n - 1) + oy)));

                cubrirOffset((n - 1), (2 ^ (n - 1)), (2 ^ (n - 1)), ox, oy);
                cubrirOffset((n - 1), 1, (2 ^ (n - 1)), (ox + 2 ^ (n - 1)), oy);
                cubrirOffset((n - 1), (2 ^ (n - 1)), 1, ox, (oy + 2 ^ (n - 1)));
                cubrirOffset((n - 1), (x - 2 ^ (n - 1)), (y - 2 ^ (n - 1)), (ox + 2 ^ (n - 1)), (oy + 2 ^ (n - 1)));

            }
//            (x > 2^(n-1)) && (y <= 2^(n-1))
            if ((x > (2 ^ (n - 1))) && (y <= (2 ^ (n - 1)))) {
//                [((2^(n-1)+ox , 2^(n-1)+1+oy) , (2^(n-1)+1+ox , 2^(n-1)+oy+1) , (2^(n-1)+ox , 2^(n-1)+oy))]
                result.add(new Triomino(
                        new Point(2 ^ (n - 1) + ox, 2 ^ (n - 1) + 1 + oy),
                        new Point(2 ^ (n - 1) + 1 + ox, 2 ^ (n - 1) + oy + 1),
                        new Point(2 ^ (n - 1) + ox, 2 ^ (n - 1) + oy)));

                cubrirOffset((n - 1), (2 ^ (n - 1)), (2 ^ (n - 1)), ox, oy);
                cubrirOffset((n - 1), (2 ^ (n - 1)), 1, ox, (oy + 2 ^ (n - 1)));
                cubrirOffset((n - 1), 1, 1, (ox + 2 ^ (n - 1)), (oy + 2 ^ (n - 1)));
                cubrirOffset((n - 1), (x - 2 ^ (n - 1)), y, (ox + 2 ^ (n - 1)), oy);
            }
//             x <= 2^(n-1)) && (y > 2^(n-1))
            if ((x <= (2 ^ (n - 1))) && (y > (2 ^ (n - 1)))) {
//                [((2^(n-1)+1+ox , 2^(n-1)+oy) , (2^(n-1)+1+ox , 2^(n-1)+oy+1) , (2^(n-1)+ox , 2^(n-1)+oy))]
                result.add(new Triomino(
                        new Point(2 ^ (n - 1) + 1 + ox, 2 ^ (n - 1) + oy),
                        new Point(2 ^ (n - 1) + 1 + ox, 2 ^ (n - 1) + oy + 1),
                        new Point(2 ^ (n - 1) + ox, 2 ^ (n - 1) + oy)));

                cubrirOffset((n - 1), (2 ^ (n - 1)), (2 ^ (n - 1)), ox, oy);
                cubrirOffset((n - 1), 1, (2 ^ (n - 1)), (ox + 2 ^ (n - 1)), oy);
                cubrirOffset((n - 1), 1, 1, (ox + 2 ^ (n - 1)), (oy + 2 ^ (n - 1)));
                cubrirOffset((n - 1), x, (y - 2 ^ (n - 1)), ox, (oy + 2 ^ (n - 1)));
            }
//            (x <= 2^(n-1)) && (y <= 2^(n-1))
            if ((x <= (2 ^ (n - 1))) && (y <= (2 ^ (n - 1)))) {
//                [((2^(n-1)+1+ox , 2^(n-1)+oy) , (2^(n-1)+1+ox , 2^(n-1)+oy+1) , (2^(n-1)+ox , 2^(n-1)+oy+1))]
                result.add(new Triomino(
                        new Point(2 ^ (n - 1) + 1 + ox, 2 ^ (n - 1) + oy),
                        new Point(2 ^ (n - 1) + 1 + ox, 2 ^ (n - 1) + oy + 1),
                        new Point(2 ^ (n - 1) + ox, 2 ^ (n - 1) + oy + 1)));

                cubrirOffset((n - 1), (2 ^ (n - 1)), 1, ox, (oy + 2 ^ (n - 1)));
                cubrirOffset((n - 1), 1, (2 ^ (n - 1)), (ox + 2 ^ (n - 1)), oy);
                cubrirOffset((n - 1), 1, 1, (ox + 2 ^ (n - 1)), (oy + 2 ^ (n - 1)));
                cubrirOffset((n - 1), x, y, ox, oy);
            }
        }
    }
}

class View extends javax.swing.JFrame {

    /**
     *
     */
    public View() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     *
     * @param g
     */
    public void play(Game g) {
        setPoint(g.initialPoint);
        for (Triomino t : g.result) {
            System.out.println(t);
            setTriomino(t);
            delay(200);
        }
        System.out.println(g.result.size());
    }

    /**
     *
     * @param t
     */
    private void delay(int t) {
        try {
            Thread.sleep(t);
        } catch (Exception ignored) {
        }
    }

    /**
     *
     * @param p
     */
    private void setPoint(Point p) {
        board.setValueAt("X", p.x, p.y);
    }

    /**
     *
     * @param t
     */
    private void setTriomino(Triomino t) {
        board.setValueAt("*", t.p1.x, t.p1.y);
        board.setValueAt("*", t.p2.x, t.p2.y);
        board.setValueAt("*", t.p3.x, t.p3.y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        board = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        board.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        board.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24)); // NOI18N
        board.setModel(new javax.swing.table.DefaultTableModel(
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
        board.setGridColor(new java.awt.Color(0, 0, 0));
        board.setMinimumSize(new java.awt.Dimension(128, 128));
        board.setPreferredSize(new java.awt.Dimension(128, 128));
        board.setRowSelectionAllowed(false);
        board.getTableHeader().setResizingAllowed(false);
        board.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(board);
        board.getAccessibleContext().setAccessibleParent(null);

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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable board;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
