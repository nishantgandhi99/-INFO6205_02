package edu.neu.gc;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    private static Logger LOGGER = LogManager.getLogger(Application.class.getName());

    public static void main(String[] args) throws GraphGenerator.InvalidEdgeCountException
    {

        final int generations = 100; //Change the value to adjusted evolution of generations
        final int populationSize = 50; //Adjust the population size
        final int NumberOfColors = 3; //Adjust number of colors

        //GraphGenerator.populateGraph();
        GraphGenerator graph = new GraphGenerator(10, 14);

        Population pop = new Population(populationSize, true, NumberOfColors);

        LOGGER.info("Current fittest color set : "+ pop.getFittest().toString());
        LOGGER.info("fitness : " + pop.getFittest().getFitness());
        pop.getFittest().displayWrongColor();

        /*
         * Breed up to required generations
         */

        for (int i = 0; i < generations; i++) {
            pop = GaAlgorithm.evolvePopulation(pop);
        }

        LOGGER.info(String.format("After %d breed the fittest color set is : ", generations));
        LOGGER.info(pop.getFittest().toString() + "fitness : " + pop.getFittest().getFitness());
        LOGGER.info("Adjacent node containing similar color below this line if any");
        pop.getFittest().displayWrongColor();
    }
}