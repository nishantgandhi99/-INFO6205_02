package com.neu.gc;

/**
 * Created by Abi on 12/3/17.
 */
public class GaAlgorithm {

    //GA parameters
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    /**
     * Evolves population
     * <p>
     * 1) Retains the fittest in the current population
     * 2) Randomly select two individual from the current populations
     * 3) Performs crossover between two individuals
     * 4) Performs mutation in each individual to get new skills
     **/
    public static Population evolvePopulation(Population pop) {

        Population newPopulation = new Population(pop.getSize(), false);

        int eliteOffset = 0;

        if (elitism) {
            newPopulation.setColorset(0, pop.getFittest());
            eliteOffset = 1;
        }

        for (int i = eliteOffset; i < newPopulation.getSize(); i++) {
            ColorSet parent1 = tournamentSelection(pop);
            ColorSet parent2 = tournamentSelection(pop);
            ColorSet child = crossOver(parent1, parent2);
            newPopulation.setColorset(i, child);
        }

        for (int i = eliteOffset; i < newPopulation.getSize(); i++) {
            mutate(newPopulation.getColorset(i));
        }
        return newPopulation;
    }


    //Performs crossover between two colorset
    public static ColorSet crossOver(ColorSet parent1, ColorSet parent2) {

        ColorSet child = new ColorSet();
        int setLength = parent1.getSize();
        int startPosition = (int) (Math.random() * setLength);
        int endPosition = startPosition;
        while (endPosition == startPosition) {
            endPosition = (int) (Math.random() * setLength);
        }

        for (int i = 0; i < parent1.getSize(); i++) {

            if (startPosition < endPosition && i > startPosition && i < endPosition) {
                child.setColor(i, parent1.getColor(i));
            } else if (startPosition > endPosition) {
                if (!(i < startPosition && i > endPosition)) {
                    child.setColor(i, parent1.getColor(i));
                }
            }
        }

        for (int i = 0; i < parent2.getSize(); i++) {

            if ((!child.containsColor(parent2.getColor(i))) || child.getColor(i) == 0) {

                for (int ii = 0; ii < parent2.getSize(); ii++) {
                    if (child.getColor(ii) == 0) {
                        child.setColor(ii, parent2.getColor(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    //Swap elements within the colorset
    public static void mutate(ColorSet parent) {

        for (int colorset = 0; colorset < parent.getSize(); colorset++) {

            if (Math.random() < mutationRate) {
                int randomID = (int) (Math.random() * parent.getSize());

                int color1 = parent.getColor(colorset);
                int color2 = parent.getColor(randomID);

                parent.setColor(colorset, color2);
                parent.setColor(randomID, color1);
            }
        }
    }

    //Randomly select pool of candidates and returns fittest among them.
    public static ColorSet tournamentSelection(Population pop) {
        Population selectionCandidate = new Population(tournamentSize, false);

        for (int i = 0; i < tournamentSize; i++) {
            int randomID = (int) (Math.random() * (pop.getSize()));
            selectionCandidate.setColorset(i, pop.getColorset(randomID));
        }

        return selectionCandidate.getFittest();

    }
}
