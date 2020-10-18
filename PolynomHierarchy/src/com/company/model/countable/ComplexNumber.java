package com.company.model.countable;

public class ComplexNumber implements Countable {
    /**
     * Represents the zero complex number (re =0, im =0)
     */
    public static final ComplexNumber  COMPLEX_ZERO =  new ComplexNumber(0,0);

    /**
     * Represents the real part of a complex number
     */
    private double re;

    /**
     * Represents imaginary part of a complex number
     */
    private double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumber(){
        re = 0;
        im = 0;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    /**
     * @return modulus (or absolute value) of the number
     */
    private double getModule() {
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }

    /**
     * Allows to get the sum of two complex numbers addendum given in the parameters.
     *
     * @return the new complex number
     */
    public ComplexNumber sum(ComplexNumber addendum) {
        return new ComplexNumber(getRe() + addendum.getRe(), getIm() + addendum.getIm());
    }

    /**
     * Allows to get the difference of two complex numbers subtrahend given in the parameters.
     *
     * @return the new complex number
     */
    public ComplexNumber subtract(ComplexNumber subtrahend) {
        return new ComplexNumber(getRe() - subtrahend.getRe(), getIm() - subtrahend.getIm());
    }

    /**
     * Allows to get the product of two complex numbers multiplier given in the parameters.
     *
     * @return the new complex number
     */
    public ComplexNumber multiply(ComplexNumber multiplier) {
        return new ComplexNumber(getRe() * multiplier.getRe() - getIm() * multiplier.getIm(),
                getRe() * multiplier.getIm() + getIm() * multiplier.getRe());
    }

    /**
     * This function allows to get the argument of complex number to represent it in trigonometric form
     *
     * @return argument of complex number
     */
    private double GetArg() {
        if (this.re > 0) {
            return Math.atan(im / re);
        } else {
            if (re < 0 && im > 0) {
                return Math.PI + Math.atan(im / re);
            } else {
                return -Math.PI + Math.atan(im / re);
            }
        }
    }

    /**
     * Defines and returns the sign required for correct record of a number
     *
     * @return string with appropriate sign
     */
    private String sign() {
        if (im > 0) return " + ";
        else return " - ";
    }

    /**
     * Allows opportunity to check functions argument
     *
     * @param args
     * @throws NullPointerException     if args == null
     * @throws IllegalArgumentException if args != ComplexNumber
     */
    private void checkArg(Countable args) {
        if (args == null)
            throw new NullPointerException();
        if (this.getClass() != args.getClass())
            throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        String string;
        if (im == 1 || im == -1) {
            if (re == 0) {
                string = "(" +sign() + "i)";
            } else {
                string = "(" + Double.toString(re) + sign() + "i)";
            }
        } else {
            string ="("+ Double.toString(re) + sign() + Double.toString(Math.abs(im)) + "i)";
        }
        return string;
    }

    @Override
    public Countable add(Countable addendum) {
        checkArg(addendum);

        return sum((ComplexNumber) addendum);
    }

    @Override
    public Countable subtract(Countable subtrahend) {
        checkArg(subtrahend);

        return subtract((ComplexNumber) subtrahend);
    }

    @Override
    public Countable multiply(Countable multiplier) {
        checkArg(multiplier);

        return multiply((ComplexNumber) multiplier);
    }

}
