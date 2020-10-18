package com.company.model.countable.factory;

import com.company.model.countable.Countable;
import com.company.model.countable.RationalNumber;

import java.util.Random;

public class RationalNumberGenerator implements CountableFactory {
    @Override
    public Countable getCountable(double[] args) {
        if(args.length != 1) throw new IllegalArgumentException("args.length must be 1");
        return new RationalNumber(args[0]);
    }

    @Override
    public Countable getCountable() {
        Random rnd = new Random();
        return new RationalNumber(rnd.nextInt(10));
    }
}
