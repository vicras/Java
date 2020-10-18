package com.company.model.polynomial;

import com.company.model.countable.ComplexNumber;
import com.company.model.countable.Countable;
import com.company.model.polynomial.factory.ComplexPolynomGenerator;
import com.company.model.polynomial.factory.PolynomGenerator;

public class ComplexPolynomial extends Polynomial {

    public ComplexPolynomial(ComplexNumber[] complexNumbers) {
        super(complexNumbers);
    }

    /**
     *
     * @return complex_zero
     */
    @Override
    protected Countable getZeroElement() {
        return ComplexNumber.COMPLEX_ZERO;
    }

    /**
     *
     * @param polCoff array of countable
     * @return new polynomial
     */
    @Override
    protected Polynomial getNewPolynomial(Countable[] polCoff) {
        PolynomGenerator generator = new ComplexPolynomGenerator();
        return generator.getPolynom( polCoff);
    }
}
