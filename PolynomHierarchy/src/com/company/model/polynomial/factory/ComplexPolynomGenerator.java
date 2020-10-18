package com.company.model.polynomial.factory;

import com.company.model.countable.ComplexNumber;
import com.company.model.countable.Countable;
import com.company.model.countable.factory.ComplexNumberGenerator;
import com.company.model.countable.factory.CountableFactory;
import com.company.model.polynomial.ComplexPolynomial;
import com.company.model.polynomial.Polynomial;

import java.util.Arrays;

public class ComplexPolynomGenerator extends PolynomGenerator{
    @Override
    protected Countable getRandomCountable() {
        CountableFactory factory = new ComplexNumberGenerator();
        return factory.getCountable();
    }


    @Override
    protected Polynomial getNewPolynom(Countable[] polCoff) {
        ComplexNumber[] ans = new ComplexNumber[polCoff.length];

        Arrays.setAll(ans, inputArrayIndex -> (ComplexNumber) polCoff[inputArrayIndex]);

        return new ComplexPolynomial(ans);
    }
}
