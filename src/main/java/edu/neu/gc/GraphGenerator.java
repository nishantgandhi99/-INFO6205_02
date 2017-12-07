package edu.neu.gc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Abi on 12/3/17.
 */
public class GraphGenerator {

    private static Logger LOGGER = LogManager.getLogger(GraphGenerator.class.getName());
    /**
     * A graph can be represented in form of adjacency matrix.
     * An undirected graph is required
     *
     */
    static int[][] graph = new int[10][10];
    static int node = graph.length;

    //TODO: Automate the population of the graph
    static int[] firstRow = {0, 1, 0, 0, 0, 1, 0, 0, 0, 0};
    static int[] SecondRow = {1, 0, 1, 0, 0, 0, 1, 0, 0, 0};
    static int[] thirdRow = {0, 1, 0, 1, 0, 0, 0, 1, 0, 0};
    static int[] fourthRow = {0, 0, 1, 0, 1, 0, 0, 0, 1, 0};
    static int[] fifthRow = {1, 0, 0, 1, 0, 0, 0, 0, 0, 1};
    static int[] sixthRow = {1, 0, 0, 0, 0, 0, 0, 1, 1, 0};
    static int[] seventhRow = {0, 1, 0, 0, 0, 0, 0, 0, 1, 1};
    static int[] eightRow = {0, 0, 1, 0, 0, 1, 0, 0, 0, 1};
    static int[] nineRow = {0, 0, 0, 1, 0, 1, 1, 0, 0, 0};
    static int[] tenRow = {0, 0, 0, 0, 1, 0, 1, 1, 0, 0};


    //Populate the graph based on the column values
    static public void populateGraph() {
        graph[0] = firstRow;
        graph[1] = SecondRow;
        graph[2] = thirdRow;
        graph[3] = fourthRow;
        graph[4] = fifthRow;
        graph[5] = sixthRow;
        graph[6] = seventhRow;
        graph[7] = eightRow;
        graph[8] = nineRow;
        graph[9] = tenRow;
    }


    //TODO: Method to calculate number of node in a graph
    static public int getNode() {
        return node;
    }


    static public int[][] getGraph() {
        return graph;
    }


}
