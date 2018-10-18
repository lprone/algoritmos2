package guia6.problems.farmer;

import guia6.problems.State;

/**
 *
 * @author lprone
 */
public class FarmerState implements State {

    /**
     *
     */
    final int granjero;
    final int zorro;
    final int gallina;
    final int maiz;

    /**
     *
     * @param granjero
     * @param zorro
     * @param gallina
     * @param maiz
     */
    public FarmerState(int granjero, int zorro, int gallina, int maiz) {
        this.granjero = granjero;
        this.zorro = zorro;
        this.gallina = gallina;
        this.maiz = maiz;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(State o) {
        return this.granjero == ((FarmerState) o).granjero
                && this.zorro == ((FarmerState) o).zorro
                && this.gallina == ((FarmerState) o).gallina
                && this.maiz == ((FarmerState) o).maiz;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "granjero " + granjero + " zorro " + zorro + " gallina " + gallina + " maiz " + maiz;
    }
}
