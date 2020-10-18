package com.company.model.polynomial;

import com.company.model.countable.Countable;

import java.util.Arrays;

public abstract class Polynomial {
    /**
     * store coefficient of normalized polynom a<sub>0</sub> + a<sub>1</sub>x + ... + a<sub>n</sub>x<sup>n-1</sup> + a<sub>n+1</sub>x<sup>n</sup>
     * coefficient numeration match with array coefficients
     */
    private Countable[] polCoff;

    public Polynomial(Countable[] polCoff) {
        this.polCoff = polCoff;
    }

    /**
     * @return rank of polynom
     */
    public int getRank() {
        return polCoff.length - 1;
    }

    /**
     * @param i number of needed coefficient
     * @return this coefficient
     */
    public Countable getCoff(int i) {
        if (i >= polCoff.length || i < 0) throw new IndexOutOfBoundsException();
        return polCoff[i];
    }

    /**
     * Allows to get the sum of two polynom addendum given in the parameters.
     *
     * @return the new polynomial
     */
    public Polynomial add(Polynomial addendum) {
        Countable[] ans;
        Countable[] temp;

        if (getRank() > addendum.getRank()) {
            ans = Arrays.copyOf(polCoff, polCoff.length);
            temp = addendum.polCoff;

        } else {
            ans = Arrays.copyOf(addendum.polCoff, addendum.polCoff.length);
            temp = polCoff;
        }

        for (int i = 0; i < temp.length; i++) {
            ans[i] = ans[i].add(temp[i]);
        }
        return getNewPolynomial(ans);
    }

    /**
     * Allows to get the difference of two polynom subtrahend given in the parameters.
     *
     * @return the new polynom number
     */
    public Polynomial subtract(Polynomial subtrahend) {
        Countable[] ans = Arrays.copyOf(polCoff, Math.max(polCoff.length, subtrahend.polCoff.length));

        int minLength = Math.min(ans.length, subtrahend.polCoff.length);

        for (int i = 0; i < minLength ; i++) {
            if (ans[i] == null)
                ans[i] = getZeroElement();
            ans[i] = ans[i].subtract(subtrahend.polCoff[i]);
        }

        return getNewPolynomial(ans);
    }

    /**
     * Allows to get the product of polynom and const multiplier given in the parameters.
     *
     * @return the new polynom
     */
    public Polynomial multiply(Countable multiplier) {
        Countable[] ans = new Countable[polCoff.length];
        for (int i = 0; i < polCoff.length; i++) {
            ans[i] = getCoff(i).multiply(multiplier);
        }

        return getNewPolynomial(ans);
    }

    protected abstract Countable getZeroElement();

    protected abstract  Polynomial getNewPolynomial(Countable[] polCoff);

    @Override
    public String toString() {
        var ans = new StringBuilder();
        if (polCoff == null || polCoff.length == 0) {
            ans.append("Empty polynom");
        } else {
            ans.append("Polynom:\n");
            ans.append(polCoff[0]).append(" + ");
            for (int i = 1; i < polCoff.length-1; i++) {
                ans.append(polCoff[i].toString()).append("x^").append(i).append(" + ");
            }
            ans.append(polCoff[polCoff.length-1].toString()).append("x^").append(polCoff.length-1);
        }
        return ans.toString();
    }
}

