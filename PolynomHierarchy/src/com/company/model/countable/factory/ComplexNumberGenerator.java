package com.company.model.countable.factory;

import com.company.model.countable.ComplexNumber;
import com.company.model.countable.Countable;

import java.util.Random;

public class ComplexNumberGenerator implements CountableFactory {
    @Override
    public Countable getCountable(double[] args) {
        if(args.length != 2) throw new IllegalArgumentException("args.length must be 2");
        return new ComplexNumber(args[0], args[1]);
    }

    @Override
    public Countable getCountable() {
        Random rnd = new Random();
        return new ComplexNumber(rnd.nextInt(10), rnd.nextInt(10));
    }
}
