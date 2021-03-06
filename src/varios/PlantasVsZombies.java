/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package varios;

import java.util.ArrayList;

/**
 * @author lprone
 */
class Planta implements Comparable {

    private final String especie;
    private final int potencia;
    private final int tiempo;
    private final double potenciaTiempo;

    /**
     * @param especie
     * @param potencia
     * @param tiempo
     */
    public Planta(String especie, int potencia, int tiempo) {
        this.especie = especie;
        this.potencia = potencia;
        this.tiempo = tiempo;
        this.potenciaTiempo = (double) potencia / (double) tiempo;
    }

    /**
     * @return
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @return
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     * @return
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return especie + " - " + potencia + " - " + tiempo + " - " + potenciaTiempo;
    }

    /**
     * @param other
     * @return
     */
    @Override
    public int compareTo(Object other) {
        if (potenciaTiempo > ((Planta) other).potenciaTiempo) {
            return 1;
        } else {
            if (potenciaTiempo == ((Planta) other).potenciaTiempo) {
                return 0;
            }
            return -1;
        }
    }
}

/**
 * @author lprone
 */
public class PlantasVsZombies {

    /**
     * @param plantas
     * @return
     */
    private static Planta[] solveGame(ArrayList<Planta> plantas) {
        plantas.sort(Planta::compareTo);
        Planta[] sol = new Planta[8];
        int auxArreglo, auxList = 0;
        sol[0] = plantas.get(auxList);
        for (int i = 1; i < sol.length; i++) {
            while (auxList < plantas.size()) {
                auxArreglo = i - 1;
                Planta ins = plantas.get(auxList);
                boolean canInsert = true;
                while (auxArreglo >= 0) {
                    if (!(sol[auxArreglo] != ins || (sol[auxArreglo] == ins && (sol[auxArreglo].getTiempo() + auxArreglo < i)))) {
                        canInsert = false;
                    }
                    auxArreglo--;
                }
                if (canInsert) {
                    sol[i] = ins;
                    auxList = plantas.size();
                } else {
                    auxList++;
                }
            }
            auxList = 0;
        }
        return sol;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Planta> plantas = new ArrayList<>();
        plantas.add(new Planta("E", 4, 2));
        plantas.add(new Planta("A", 10, 10));
        plantas.add(new Planta("D", 2, 1));
        plantas.add(new Planta("C", 8, 5));
        plantas.add(new Planta("B", 10, 8));
        plantas.add(new Planta("F", 8, 4));

        for (Planta planta : plantas) {
            System.out.println(planta);
        }

        System.out.println("---------------");
        PlantasVsZombies p = new PlantasVsZombies();
        Planta[] solve = solveGame(plantas);
        for (Planta aSolve : solve) {
            System.out.println(aSolve);
        }
    }
}
