package com.company.model;

import com.company.model.countable.Countable;
import com.company.model.polynomial.Polynomial;

import java.lang.reflect.InvocationTargetException;

public interface Taskable {

    /**
     *
     * @param length length of polynom array
     * @param endRank max rank of each polynom
     * @param type [ratio|complex]
     * @return new polynom array
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    Polynomial[] createPolynomArray(int length, int endRank, String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    /**
     *
     * @param array polynom array
     * @return sum of this array
     */
    Polynomial sumOfArray(Polynomial[] array);

    /**
     *
     * @param polynomials two polynoms
     * @return result of subtraction
     */
    Polynomial performSubtract(Polynomial[] polynomials);

    /**
     *
     * @param type type of new countable
     * @return new countable
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    Countable createCountable(String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    /**
     * perform multiplication between polynomial and countable
     * @param polynomial
     * @param number
     * @return result
     */
    Polynomial performMultiplication(Polynomial polynomial, Countable number);

    void addListeners(TaskObserver observer);

}
