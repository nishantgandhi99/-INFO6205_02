package edu.neu.gc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Abi on 12/3/17.
 */
public class Population {

    private static Logger LOGGER = LogManager.getLogger(Population.class.getName());
    ColorSet[] colorset;

    public Population(int populationSize, Boolean flag, int numberOfColor) {

        colorset = new ColorSet[populationSize];

        if (flag) {
            for (int i = 0; i < populationSize; i++) {
                ColorSet cs = new ColorSet();
                cs.generateSet(numberOfColor);
                setColorset(i, cs);
            }
        }
    }

    public ColorSet getColorset(int index) {
        return colorset[index];
    }

    public void setColorset(int index, ColorSet colorset) {
        this.colorset[index] = colorset;
    }

    public ColorSet getFittest() {

        ColorSet cs = colorset[0];

        for (int i = 1; i < colorset.length; i++) {

            if (cs.getFitness() < colorset[i].getFitness()) {
                cs = colorset[i];
            }
        }

        return cs;

    }

    public int getSize() {
        return colorset.length;
    }

}
