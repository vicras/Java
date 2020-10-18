package com.company.model.polynomial;

import com.company.model.countable.Countable;
import com.company.model.countable.RationalNumber;
import com.company.model.polynomial.factory.PolynomGenerator;
import com.company.model.polynomial.factory.RationalPolynomGenerator;

public class RationalPolynomial extends Polynomial {

    public RationalPolynomial(RationalNumber[] rationalNumbers) {
        super(rationalNumbers);
    }

    /**
     *
     * @return rational_zero
     */
    @Override
    protected Countable getZeroElement() {
        return RationalNumber.RATIONAL_ZERO;
    }

    /**
     *
     * @param polCoff array of countable
     * @return new polynomial
     */
    @Override
    protected Polynomial getNewPolynomial(Countable[] polCoff) {
        PolynomGenerator generator = new RationalPolynomGenerator();
        return generator.getPolynom( polCoff);
    }

}
