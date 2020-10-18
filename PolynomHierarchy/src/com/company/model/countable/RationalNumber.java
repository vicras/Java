package com.company.model.countable;

public class RationalNumber implements Countable {

    /**
     * Represents the zero rational number (0)
     */
    public static final RationalNumber  RATIONAL_ZERO =  new RationalNumber(0);

    private final double number;

    public RationalNumber(double number) {
        this.number = number;
    }

    public  RationalNumber(){
        number =0;
    }

    public double getNumber(){
        return number;
    }

    /**
     * Allows to get the sum of two rational numbers addendum given in the parameters.
     *
     * @return the new rational number
     */
    public RationalNumber sum(RationalNumber addendum) {
        return new RationalNumber(number + addendum.getNumber());
    }

    /**
     * Allows to get the difference of two rational numbers subtrahend given in the parameters.
     *
     * @return the new rational number
     */
    public RationalNumber subtract(RationalNumber subtrahend) {
        return new RationalNumber(number - subtrahend.getNumber());
    }

    /**
     * Allows to get the product of two rational numbers multiplier given in the parameters.
     *
     * @return the new rational number
     */
    public RationalNumber multiply(RationalNumber multiplier) {
        return new RationalNumber(multiplier.getNumber() * number);
    }

    /**
     * Allows opportunity to check functions argument
     * @throws NullPointerException if args == null
     * @throws IllegalArgumentException if args != ComplexNumber
     * @param args
     */
    private void checkArg(Countable args) {
        if(args ==null)
            throw new NullPointerException();
        if (this.getClass() != args.getClass())
            throw new IllegalArgumentException();
    }

    @Override
    public Countable add(Countable addendum) {
        checkArg(addendum);

        return sum((RationalNumber) addendum);
    }

    @Override
    public Countable subtract(Countable subtrahend) {
        return subtract((RationalNumber)subtrahend);
    }

    @Override
    public Countable multiply(Countable multiplier) {
        checkArg(multiplier);

        return multiply((RationalNumber) multiplier);
    }

    @Override
    public String toString() {
        String ans = String.format("%.2f", number);
        return String.valueOf(ans);
    }
}
