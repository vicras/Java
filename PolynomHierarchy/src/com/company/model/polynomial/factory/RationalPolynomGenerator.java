package com.company.model.polynomial.factory;

import com.company.model.countable.ComplexNumber;
import com.company.model.countable.Countable;
import com.company.model.countable.RationalNumber;
import com.company.model.countable.factory.CountableFactory;
import com.company.model.countable.factory.RationalNumberGenerator;
import com.company.model.polynomial.Polynomial;
import com.company.model.polynomial.RationalPolynomial;

import java.util.Arrays;

public class RationalPolynomGenerator extends PolynomGenerator {
    @Override
    protected Countable getRandomCountable() {
        CountableFactory factory = new RationalNumberGenerator();
        return factory.getCountable();
    }

    @Override
    protected Polynomial getNewPolynom(Countable[] polCoff) {
        RationalNumber[] ans = new RationalNumber[polCoff.length];

        Arrays.setAll(ans, inputArrayIndex -> (RationalNumber) polCoff[inputArrayIndex]);

        return new RationalPolynomial(ans);
    }
}
