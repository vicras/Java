package com.company.tests;

import com.company.tests.CryptoTestable;
import org.apache.commons.math3.special.Gamma;

public class SerialTest implements CryptoTestable {
    @Override
    public boolean getResultOfTest(String sequence) {
        int n = sequence.length();
        int m = 11;

        if (m > Math.floor(Math.log(n)/Math.log(2)) - 2 || m <= 0)
            return false;

        double psim0 = psi2(sequence, m, n);
        double psim1 = psi2(sequence, m - 1, n);
        double psim2 = psi2(sequence, m - 2, n);
        double del1 = psim0 - psim1;
        double del2 = psim0 - 2.0 * psim1 + psim2;

        //calculate p_values
        double p_value1 = Gamma.regularizedGammaP(Math.pow(2, m - 1) / 2, del1 / 2.0);
        double p_value2 = Gamma.regularizedGammaP(Math.pow(2, m - 2) / 2, del2 / 2.0);
        return p_value1>0.01 && p_value2>0.01;
    }

    @Override
    public String getName() {
        return "Serial test";
    }

    private double psi2(String binary, int m, int n)
    {
        if ((m == 0) || (m == -1))
        {
            return 0.0;
        }

        int[] P = new int[(1 << (m + 1))];

        for (int i = 0; i < n - m - 1; ++i)
            P[Integer.parseUnsignedInt(binary.substring(i, i+m), 2)]++;

        double sum = 0;
        for (int i = 0; i < (1 << m); i++)
        {
            sum += Math.pow(P[i], 2);
        }
        return (sum * (1L << m) / n) - n;
    }


    public SerialTest(){}
}
