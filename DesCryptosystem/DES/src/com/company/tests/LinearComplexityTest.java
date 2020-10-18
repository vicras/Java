package com.company.tests;

import com.company.tests.CryptoTestable;
import org.apache.commons.math3.special.Gamma;

public class LinearComplexityTest implements CryptoTestable {
    @Override
    public boolean getResultOfTest(String binary) {
        int n = binary.length();
        int M = BlockLength;

        if (M < 500 || M > 5000)
        {
            return false;
        }

        double[] pi = { 0.01047, 0.03125, 0.12500, 0.50000, 0.25000, 0.06250, 0.020833 };

        int N = n / M;    //number of blocks

        double mu = M / 2.0 + (9.0 + Math.pow(-1, M + 1)) / 36.0 - 1.0 / Math.pow(2, M) * (M / 3.0 + 2.0 / 9.0);

        double[] v = new double[K + 1];

        for (int i = 0; i < N; i++)
        {
            int[] T = new int[M];   //initialize the work arrays
            int[] P = new int[M];
            int[] C = new int[M];
            int[] B = new int[M];

            int L = 0;
            int m = -1;
            int d = 0;
            C[0] = 1;
            B[0] = 1;

            //calculate the linear complexity of the block
            int blockPos = 0;
            while (blockPos < M)
            {
                d = binary.charAt(i * M + blockPos) - '0';
                for (int j = 1; j <= L; j++)
                {
                    d += C[j] * (binary.charAt(i * M + blockPos - j) - '0');
                }
                d = d % 2;
                if (d == 1)
                {
                    for (int j = 0; j < M; j++)
                    {
                        T[j] = C[j];
                        P[j] = 0;
                    }
                    for (int j = 0; j < M; j++)
                    {
                        if (B[j] == 1)
                        {
                            P[j + blockPos - m] = 1;
                        }
                    }
                    for (int j = 0; j < M; j++)
                    {
                        C[j] = (C[j] + P[j]) % 2;
                    }
                    if (L <= blockPos / 2)
                    {
                        L = blockPos + 1 - L;
                        m = blockPos;
                        for (int j = 0; j < M; j++)
                        {
                            B[j] = T[j];
                        }
                    }
                }
                blockPos++;
            }

            double Ti = Math.pow(-1, M) * (L - mu) + 2.0 / 9.0;

            //record result of complexity test
            if (Ti <= -2.5)
                v[0]++;
            else if (Ti > -2.5 && Ti <= -1.5)
                v[1]++;
            else if (Ti > -1.5 && Ti <= -0.5)
                v[2]++;
            else if (Ti > -0.5 && Ti <= 0.5)
                v[3]++;
            else if (Ti > 0.5 && Ti <= 1.5)
                v[4]++;
            else if (Ti > 1.5 && Ti <= 2.5)
                v[5]++;
            else
                v[6]++;
        }

        //calculate p_value
        double chi_squared = 0;
        for (int i = 0; i < K + 1; i++)
        {
            chi_squared += Math.pow(v[i] - N * pi[i], 2) / (N * pi[i]);
        }
        double p_value = Gamma.regularizedGammaP(K / 2.0, chi_squared / 2.0);

        return p_value>0.01;
    }

    @Override
    public String getName() {
        return "Linear Complexity Test";
    }

    public LinearComplexityTest(){}

    private static int K = 6;

    private int BlockLength = 1024;

}
