package edu.neu.gc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Abi on 12/3/17.
 */

public class ColorSet {

    private static Logger LOGGER = LogManager.getLogger(ColorSet.class.getName());

    int[] colorset;

    public ColorSet() {
        colorset = new int[GraphGenerator.getNode()];

    }

    /**
     * Populate the node with random color
     * Number of color is user inputted
     *
     **/
    public void generateSet(int numberOfColor) {

        Random random = new Random();

        for (int i = 0; i < colorset.length; i++) {

            colorset[i] = random.nextInt(numberOfColor) + 1;
        }

    }

    //Get color at a particular node
    public int getColor(int index) {
        return colorset[index];
    }

    //Set color of particular node
    public void setColor(int index, int color) {
        this.colorset[index] = color;
    }

    /**
     * Get the fitness value of graph based on the colorset
     * <p>
     * returns the count of satisfied edge having different adjacent colors
     */

    public int getFitness() {

        int count = 0;


        int[][] graph = GraphGenerator.getGraph();


        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1 && colorset[i] != colorset[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public void displayWrongColor() {
        int[][] graph = GraphGenerator.getGraph();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1 && colorset[i] == colorset[j]) {
                    LOGGER.info(String.format("Problem with edge coloring : %d \t %d", i, j));
                }
            }
        }


    }

    public boolean containsColor(int i) {
        return IntStream.of(colorset).anyMatch(x -> x == i);
    }

    //Get number of nodes in a colorset
    public int getSize() {
        return colorset.length;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i : colorset) {
            sb.append(i).append("\t");
        }
        return sb.toString();
    }


}
