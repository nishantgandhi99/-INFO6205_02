package edu.neu.gc;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void randomtest1() {
        assertEquals("hi", "hi");
    }

    @Test
    public void testFitness() {
        ColorSet mySet = new ColorSet();
        assertEquals(mySet.getFitness(), 0);
    }
}