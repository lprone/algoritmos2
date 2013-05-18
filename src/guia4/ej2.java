/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia4;

/**
 *
 * @author lprone
 */
class Pair<A, B> {

    private A first;
    private B second;

    /**
     *
     * @param first
     * @param second
     */
    public Pair(A first, B second) {
        super();
        this.first = first;
        this.second = second;
    }

    /**
     *
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            return ((this.first == otherPair.first
                    || (this.first != null && otherPair.first != null
                    && this.first.equals(otherPair.first)))
                    && (this.second == otherPair.second
                    || (this.second != null && otherPair.second != null
                    && this.second.equals(otherPair.second))));
        }

        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    /**
     *
     * @return
     */
    public A getFirst() {
        return first;
    }

    /**
     *
     * @param first
     */
    public void setFirst(A first) {
        this.first = first;
    }

    /**
     *
     * @return
     */
    public B getSecond() {
        return second;
    }

    /**
     *
     * @param second
     */
    public void setSecond(B second) {
        this.second = second;
    }
}

public class ej2 {

    /**
     *
     * @param m
     * @param n
     * @return
     */
    public int combinatorio(int m, int n) {
        int[] cache = null;
        int a = fact(m, cache);
        int b = fact(n, cache) * fact(m - n, cache);
        return a / b;
    }

    /**
     *
     * @param m
     * @param n
     * @return
     */
    public int comb(int m, int n) {
        switch (n) {
            case 0:
                return 1;
            case 1:
                return m;
            default:
                if (m == n) {
                    return 1;
                } else {
                }

        }
        return 0;

    }

    /**
     *
     * @param n
     * @param cache
     * @return
     */
    public int fact(int n, int[] cache) {
        Pair a = new Pair(n, cache);
        return n * fact(n - 1, cache);
    }

    public static void main(String[] args) {
        ej2 e = new ej2();
        int[] cache = null;
        Pair a = new Pair(5, cache);

    }
}
