package com.company.tests;

import org.apache.commons.math3.special.Gamma;

public class LongestRunOfOnesTest implements CryptoTestable {

    @Override
    public boolean getResultOfTest(String binary) {
        int n = binary.length();


        init(n);  //initialize variables to sensible values

        int[] V = new int[pi.length];
        int N = n / M;    //number of blocks that can be made from the binary string
        for (int i = 0; i < N; i++)
        {
            //count the longest run of ones in each block
            int longestRun = 0;
            int currentRun = 0;
            for (int j = 0; j < M; j++)
            {
                if (binary.charAt(i * M + j) - '0' == 1)
                {
                    longestRun = Math.max(longestRun, ++currentRun);
                }
                else
                {
                    currentRun = 0;
                }
            }
            //record the longest run of ones found in the correct counter
            if (longestRun < V0)
            {
                V[0]++;
            }
            else if (longestRun > V0 + K)
            {
                V[K]++;
            }
            else
            {
                V[longestRun - V0]++;
            }
        }

        //calculate p_value
        double chi_squared = 0.0;
        for (int i = 0; i <= K; i++)
        {
            chi_squared += ((V[i] - N * pi[i]) * (V[i] - N * pi[i])) / (N * pi[i]);
        }
        double p_value = Gamma.regularizedGammaP(((double)K / 2.0), chi_squared / 2.0);

        return p_value>0.01;
    }

    @Override
    public String getName() {
        return "Longest run of ones test";
    }

    double[] pi;
    int K, M, V0;

    public LongestRunOfOnesTest(){}

    private void init(int n)
    {
        if (n < 6272)
        {
            K = 3;
            M = 8;
            V0 = 1;
            pi = new double[4];
            pi[0] = 0.21484375;
            pi[1] = 0.3671875;
            pi[2] = 0.23046875;
            pi[3] = 0.1875;
        }
        else if (n < 750000)
        {
            K = 5;
            M = 128;
            V0 = 4;
            pi = new double[6];
            pi[0] = 0.1174035788;
            pi[1] = 0.242955959;
            pi[2] = 0.249363483;
            pi[3] = 0.17517706;
            pi[4] = 0.102701071;
            pi[5] = 0.112398847;
        }
        else
        {
            K = 6;
            M = 10000;
            V0 = 10;
            pi = new double[7];
            pi[0] = 0.0882;
            pi[1] = 0.2092;
            pi[2] = 0.2483;
            pi[3] = 0.1933;
            pi[4] = 0.1208;
            pi[5] = 0.0675;
            pi[6] = 0.0727;
        }
    }
}
