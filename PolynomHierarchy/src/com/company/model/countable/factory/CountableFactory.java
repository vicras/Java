package com.company.model.countable.factory;

import com.company.model.countable.Countable;

public interface CountableFactory {
    /**
     *
     * @param args arguments which used to generate Countable;
     * @return new Countable
     */
    Countable getCountable(double[] args);

    /**
     * generate random Countable
     * @return new Countable
     */
    Countable getCountable();
}
