package com.neu.gc;


public class Application {

    public static void main(String[] args) {


        final int generations = 100; //Change the value to adjusted evolution of generations
        final int populationSize = 50; //Adjust the population size
        final int NumberOfColors = 3; //Adjust number of colors

        GraphGenerator.populateGraph();

        Population pop = new Population(populationSize, true, NumberOfColors);

        System.out.println("Current fittest color set : ");
        System.out.println(pop.getFittest().toString() + "fitness : " + pop.getFittest().getFitness());
        pop.getFittest().displayWrongColor();

        /*
         * Breed up to required generations
         */

        for (int i = 0; i < generations; i++) {
            pop = GaAlgorithm.evolvePopulation(pop);
        }

        System.out.println(String.format("After %d breed the fittest color set is : ", generations));
        System.out.println(pop.getFittest().toString() + "fitness : " + pop.getFittest().getFitness());
        System.out.println("Adjacent node containing similar color below this line if any");
        pop.getFittest().displayWrongColor();

    }




}
