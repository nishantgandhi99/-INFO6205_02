package edu.neu.gc;

import java.util.Random;

/**
 * Created by Abi on 12/3/17.
 */
public class GraphGenerator {

    /**
     * A graph can be represented in form of adjacency matrix.
     * An undirected graph is required
     */
    static int[][] graph = new int[10][10];
    //static int node = graph.length;

    public GraphGenerator(int v, int e) throws InvalidEdgeCountException {
        if (e > (v * v - 1) / 2) {
            throw new InvalidEdgeCountException("Edge " + String.valueOf(e) + " not possible for Vertices count " + String.valueOf(v));
        }
        int[][] graph = new int[v][v];
        GraphGenerator.graph = addRandomEdges(graph, e);

    }

    public static int getVertexCount() {
        return graph.length;
    }

    public static int[][] getGraph() {
        return graph;
    }

    private int[][] addRandomEdges(int[][] graph, int edgeCount) {
        Random random = new Random();
        while (edgeCount > 0) {
            int e1 = random.nextInt(graph.length);
            int e2 = random.nextInt(graph.length);
            if (e1 != e2 && graph[e1][e2] != 1) {
                graph[e1][e2] = 1;
                graph[e2][e1] = 1;
                edgeCount--;
            }
        }
        return graph;
    }

    class InvalidEdgeCountException extends Exception {
        public InvalidEdgeCountException(String s) {
            super(s);
        }
    }

}
