package com.company.model.countable;

public interface Countable {
    /**
     * perform sum of two countable
     * @param addendum
     * @return
     */
    public Countable add(Countable addendum);

    /**
     * perform subtract of two countable
     * @param subtrahend
     * @return
     */
    public Countable subtract(Countable subtrahend);

    /**
     * perform multiplication of two countable
     * @param multiplier
     * @return
     */
    public Countable multiply(Countable multiplier);
}
