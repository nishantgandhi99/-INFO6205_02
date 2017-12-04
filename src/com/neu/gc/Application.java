package com.neu.gc;

/**
 * Created by Abi on 12/3/17.
 */
public class Application {

    public static void main(String[] args) {


        final int generations = 100; //Change the value to adjusted evolution of generations
        final int populationSize = 50; //Adjust the population size

        GraphGenerator.populateGraph();

        Population pop = new Population(populationSize, true);

        System.out.println("Current fittest color set : ");
        System.out.println(pop.getFittest().toString() + "fitness : " + pop.getFittest().getFitness());
        pop.getFittest().displayWrongColor();

        /**
         * Breed up to required generations

         */
        for (int i = 0; i < generations; i++) {
            pop = GaAlgorithm.evolvePopulation(pop);
        }

        System.out.println("After 100 breed the fittest color set is : ");
        System.out.println(pop.getFittest().toString() + "fitness : " + pop.getFittest().getFitness());
        System.out.println("Adjacent color below this line if any");
        pop.getFittest().displayWrongColor();


    }

}
