/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guia4;

/**
 *
 * @author lprone
 */
//class Pair<L, R> {
//
//    private final L left;
//    private final R right;
//
//    public Pair(L left, R right) {
//        this.left = left;
//        this.right = right;
//    }
//
//    public L getLeft() {
//        return left;
//    }
//
//    public R getRight() {
//        return right;
//    }
//
//    @Override
//    public int hashCode() {
//        return left.hashCode() ^ right.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == null) {
//            return false;
//        }
//        if (!(o instanceof Pair)) {
//            return false;
//        }
//        Pair pairo = (Pair) o;
//        return this.left.equals(pairo.getLeft())
//                && this.right.equals(pairo.getRight());
//    }
//}
class Pair<A, B> {

    private A first;
    private B second;

    public Pair(A first, B second) {
        super();
        this.first = first;
        this.second = second;
    }

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

    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }
}

public class ej2 {

    public int combinatorio(int m, int n) {
        int[] cache = null;
        int a = fact(m, cache);
        int b = fact(n, cache) * fact(m - n, cache);
        return a / b;
    }

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
