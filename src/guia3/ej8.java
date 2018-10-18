package guia3;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author lprone
 */
class MyPoint implements Comparable {

    private final int x;
    private final int y;

    /**
     *
     * @param x
     * @param y
     */
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param p
     * @return
     */
    public int dist(MyPoint p) {
        return (int) (Math.pow(Math.abs(x - p.x), 2) + Math.pow(Math.abs(y - p.y), 2));
    }

    /**
     *
     * @param o1
     * @param o2
     * @return
     */
    public int compare(MyPoint o1, MyPoint o2) {
        return o1.getX() - o2.getX();
    }

    /**
     *
     * @param other
     * @return
     */
    @Override
    public int compareTo(Object other) {
        return this.getX() - ((MyPoint) other).getX();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return ("(" + x + "," + y + ")");
    }
}

class ret implements Comparable {

    final int d;
    private final MyPoint p1;
    private final MyPoint p2;

    /**
     *
     * @param p1
     * @param p2
     * @param d
     */
    public ret(MyPoint p1, MyPoint p2, int d) {
        this.p1 = p1;
        this.p2 = p2;
        this.d = d;
    }

    /**
     *
     * @return
     */
    private int getD() {
        return d;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return ("(" + p1.toString() + "," + p2.toString() + " - d = " + Point.distance(p1.getX(), p1.getY(), p2.getX(), p2.getY()) + ")");
    }

    /**
     *
     * @param other
     * @return
     */
    @Override
    public int compareTo(Object other) {
        return Math.abs(this.getD() - ((ret) other).getD());
    }
}

/**
 *
 * @author lprone
 */
public class ej8 {

    /**
     *
     * @param p
     * @return
     */
    private boolean isBase(MyPoint[] p) {
        return p.length == 2;
    }

    /**
     *
     * @param a
     * @return
     */
    private ret base(MyPoint[] a) {
        return new ret(a[0], a[1], a[0].dist(a[1]));
    }

    /**
     *
     * @param a
     * @return
     */
    private ArrayList<MyPoint[]> split(MyPoint[] a) {
        ArrayList<MyPoint[]> ret = new ArrayList();
        MyPoint[] aux1 = new MyPoint[2];
        MyPoint[] aux2 = new MyPoint[a.length - 1];
        System.arraycopy(a, 0, aux1, 0, 2);
        System.arraycopy(a, 1, aux2, 0, a.length - 1);
        ret.add(aux1);
        ret.add(aux2);
        return ret;
    }

    /**
     *
     * @param in
     * @return
     */
    private ret join(ArrayList<ret> in) {
        ret r = in.get(0);
        ArrayList<ret> points = in;
        Collections.sort(points);
        for (ret sol : points) {
            if (sol.d < r.d) {
                r = sol;
            }
        }
        return r;
    }

    /**
     *
     * @param in
     * @return
     */
    private ret minDist(ArrayList<MyPoint[]> in) {
        ArrayList<MyPoint[]> sp = new ArrayList();
        sp.add(in.get(0));
        ArrayList<MyPoint[]> cb = new ArrayList();

        while (!sp.isEmpty()) {
            if (isBase(sp.get(0))) {
                cb.add(sp.get(0));
            } else {
                sp.add(split(sp.get(0)).get(0));
                sp.add(split(sp.get(0)).get(1));
            }
            sp.remove(0);
        }
        return join(map(cb));
    }

    /**
     *
     * @param cb
     * @return
     */
    private ArrayList<ret> map(ArrayList<MyPoint[]> cb) {
        ArrayList<ret> sols = new ArrayList();
        for (MyPoint[] is : cb) {
            sols.add(base(is));
        }
        return sols;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        ej8 e = new ej8();

        ArrayList<MyPoint> points = new <MyPoint>ArrayList();
        points.add(new MyPoint(1, 1));
        points.add(new MyPoint(5, 2));
        points.add(new MyPoint(9, 4));
        points.add(new MyPoint(0, 0));
        points.add(new MyPoint(1, 0));
        points.add(new MyPoint(0, 1));
        points.add(new MyPoint(3, 4));
        points.add(new MyPoint(0, 7));

        Collections.sort(points);

        MyPoint[] p = new MyPoint[points.size()];

        for (int i = 0; i < points.size(); i++) {
            p[i] = points.get(i);
        }

        ArrayList problema = new ArrayList();
        problema.add(p);
        System.out.println(e.minDist(problema));
    }
}
