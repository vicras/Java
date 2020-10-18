package com.company.model.polynomial.factory;

import com.company.model.countable.Countable;
import com.company.model.polynomial.Polynomial;
import com.company.view.ConsoleOutputer;

import java.util.Random;

public abstract class PolynomGenerator {


    /**
     * generate arrays of polynoms
     * polynoms generated with random rank
     * @param amount amounts of polynoms
     * @param endRank max rank which polynoms can be created
     * @return arrays of polynoms
     */
    public Polynomial[] getPolynoms(int amount, int endRank){
        Polynomial[] array = new Polynomial[amount];

        Random rnd = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = getPolynom(rnd.nextInt(endRank));
        }

        return array;
    }



//    public static RationalPolynomial[] getRationalPolynoms(int amount, int endRank){
//        RationalPolynomial[] array = new RationalPolynomial[amount];
//
//        Random rnd = new Random();
//
//        for (int i = 0; i < array.length; i++) {
//            array[i] = PolynomGenerator.getRationalPolynom(rnd.nextInt(endRank));
//            ConsoleOutputer.outputResult(array[i]);
//        }
//
//        return array;
//    }
//
//    /**
//     * generate arrays of complex polynoms
//     * polynoms generated with random rank
//     * @param amount amounts of polynoms
//     * @param endRank max rank which polynoms can be created
//     * @return arrays of complex polynoms
//     */
//    static ComplexPolynomial[] getComplexPolynoms(int amount, int endRank){
//        var array = new ComplexPolynomial[amount];
//
//        Random rnd = new Random();
//
//        for (int i = 0; i < array.length; i++) {
//            array[i] = PolynomGenerator.getComplexPolynom(rnd.nextInt(endRank));
//            ConsoleOutputer.outputResult(array[i]);
//        }
//
//        return array;
//    }

    /**
     * create random polynom
     * @param rank rank of created polynom
     * @return new polynom
     */
    public Polynomial getPolynom(int rank){
        Countable[] polCoff = generateArray(rank);

        return getNewPolynom(polCoff);
    }

    /**
     * create polynom
     * @param polCoff coefficient of created polynom
     * @return new polynom
     */
    public Polynomial getPolynom(Countable[] polCoff){
        return getNewPolynom(polCoff);
    }

    /**
     * generate array of rational numbers
     * @param rank size of array
     * @return array of rationals numbers
     */
    private Countable[] generateArray(int rank){
        var numbers = new Countable[rank];
        for (int i = 0; i < rank; i++) {
            numbers[i] = getRandomCountable();
        }
        return  numbers;
    }

    /**
     * generate random number
     * @return new Countable
     */
    protected abstract Countable getRandomCountable();

    /**
     * generate new Polynom
     * @return new new Polynom
     */
    protected abstract Polynomial getNewPolynom(Countable[] polCoff);




}
