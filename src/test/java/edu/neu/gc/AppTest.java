package edu.neu.gc;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testFitness() {
        ColorSet mySet = new ColorSet();
        assertEquals(mySet.getFitness(), 0);
    }

    @Test
    public void testFitness1() throws GraphGenerator.InvalidEdgeCountException {
        int vertexCount = 7;
        int edgeCount = 5;
        GraphGenerator graph = new GraphGenerator(vertexCount, edgeCount);
        ColorSet mySet = new ColorSet();
        assertEquals(mySet.getFitness(), 0);
    }

    @Test
    public void testGraphGenerator() throws GraphGenerator.InvalidEdgeCountException {
        int vertexCount = 7;
        int edgeCount = 5;
        GraphGenerator graph1 = new GraphGenerator(vertexCount, edgeCount);
        assertEquals(vertexCount, graph1.getVertexCount());
        assertNotEquals(vertexCount + 1, graph1.getVertexCount());
    }

    @Test(expected=GraphGenerator.InvalidEdgeCountException.class)
    public void testGraphGenerator1() throws GraphGenerator.InvalidEdgeCountException {
        int vertexCount = 7;
        int edgeCount = vertexCount*vertexCount;
        GraphGenerator graph2 = new GraphGenerator(vertexCount, edgeCount);
    }
}