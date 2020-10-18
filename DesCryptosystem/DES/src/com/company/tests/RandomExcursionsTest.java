package com.company.tests;

import org.apache.commons.math3.special.Gamma;

public class RandomExcursionsTest implements CryptoTestable {

    public RandomExcursionsTest(){}

    @Override
    public boolean getResultOfTest(String binary) {
        int[] stateX = { -4, -3, -2, -1, 1, 2, 3, 4 };

        double[][] pi = {
                {0.0000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.0000000000},
                {0.5000000000, 0.25000000000, 0.12500000000, 0.06250000000, 0.03125000000, 0.0312500000},
                {0.7500000000, 0.06250000000, 0.04687500000, 0.03515625000, 0.02636718750, 0.0791015625},
                {0.8333333333, 0.02777777778, 0.02314814815, 0.01929012346, 0.01607510288, 0.0803755143},
                {0.8750000000, 0.01562500000, 0.01367187500, 0.01196289063, 0.01046752930, 0.0732727051}
        };

        int n = binary.length();

        //determine cycles
        int J = 0;
        int[] S_k = new int[n];
        S_k[0] = 2 * (binary.charAt(0) - '0') - 1;
        int[] cycle = new int[Math.max(1000, n / 100)];
        for (int i = 1; i < n; i++)
        {
            S_k[i] = S_k[i - 1] + 2 * (binary.charAt(i) - '0') - 1;
            if (S_k[i] == 0)
            {
                J++;
                if (J >= Math.max(1000, n / 100))
                {
                    return false;
                }
                cycle[J] = i;
            }
        }
        if (S_k[n - 1] != 0)
        {
            J++;
        }
        cycle[J] = n;


        double constraint = Math.max(0.005 * Math.pow(n, 0.5), 500);
        double[] p_values = new double[8];
        if (J < constraint)
        {
            return false;
        }

        double[][] v = new double[6][8];
        int cycleStart = 0;
        int cycleStop = cycle[1];
        for (int k = 0; k < 6; k++)
        {
            for (int i = 0; i < 8; i++)
            {
                v[k][i] = 0.0;
            }
        }
        int[] counter = new int[8];
        //for each cycle compute frequency of x
        for (int j = 1; j <= J; j++)
        {
            for (int i = 0; i < 8; i++)
            {
                counter[i] = 0;
            }
            for (int i = cycleStart; i < cycleStop; i++)
            {
                if ((S_k[i] >= 1 && S_k[i] <= 4) || (S_k[i] >= -4 && S_k[i] <= -1))
                {
                    int b = S_k[i] < 0 ? 4 : 3;
                    counter[S_k[i] + b]++;
                }
            }
            cycleStart = cycle[j] + 1;
            if (j < J)
            {
                cycleStop = cycle[j + 1];
            }

            for (int i = 0; i < 8; i++)
            {
                if ((counter[i] >= 0) && (counter[i] <= 4))
                {
                    v[counter[i]][i]++;
                }
                else if (counter[i] >= 5)
                {
                    v[5][i]++;
                }
            }
        }

        //calculate p_values
        for (int i = 0; i < 8; i++)
        {
            int x = stateX[i];
            double sum = 0;
            for (int k = 0; k < 6; k++)
            {
                sum += Math.pow(v[k][i] - J * pi[Math.abs(x)][k], 2) / (J * pi[Math.abs(x)][k]);
            }
            p_values[i] = Gamma.regularizedGammaP(2.5, sum / 2.0);
            if(p_values[i]<=0.01)
                return false;
        }
        return true;
    }

    @Override
    public String getName() {
        return "Random excursion test";
    }
}
