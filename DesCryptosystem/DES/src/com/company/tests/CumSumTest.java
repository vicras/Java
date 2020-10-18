package com.company.tests;

import org.apache.commons.math3.distribution.NormalDistribution;

public class CumSumTest implements CryptoTestable{

    private int mode = 0;
    private String binaryLine;

    //private int[] Sequence;

   public CumSumTest(){}

    @Override
    public boolean getResultOfTest(String line) {
        binaryLine = line;
        NormalDistribution normalDistribution = new NormalDistribution();
        int[] sums = GetSums(mode);
        int z = GetMax(sums),
                size = sums.length;
        double firstSum = 0,
                secondSum = 0;

        for (int i = (int) (((-size / (double) z) + 1.0) / 4.0);
             i <= (int) (((size / (double) z) - 1.0) / 4.0);
             i++) {
            firstSum += normalDistribution.cumulativeProbability((4 * i + 1) * z / Math.sqrt(size)) -
                    normalDistribution.cumulativeProbability((4 * i - 1) * z / Math.sqrt(size));
        }

        for (int i = (int) (((-size / (double) z) - 3.0) / 4.0);
             i <= (int) (((size / (double) z) - 1.0) / 4.0);
             i++) {
            secondSum += normalDistribution.cumulativeProbability((4 * i + 3) * z / Math.sqrt(size)) -
                    normalDistribution.cumulativeProbability((4 * i + 1) * z / Math.sqrt(size));
        }

        return (1.0 - firstSum + secondSum > 0.01);
    }

    public int[] GetSums(int Mode)
    {
        int size = binaryLine.length();
        int[] sums = new int[size];


        if (Mode == 1)
        {
            sums[0] = BoolToInt(binaryLine.charAt(0));

            for (int i = 1; i < size; i++)
                sums[i] = sums[i - 1] + BoolToInt(binaryLine.charAt(i));
        }
        else
        {
            sums[0] = BoolToInt(binaryLine.charAt(size - 1));

            for (int i = 1; i < size; i++)
                sums[i] = sums[i - 1] + BoolToInt(binaryLine.charAt(size - i - 1));
        }

        return sums;
    }

    public int BoolToInt(char value){
       return value=='1' ? 1 : -1;
    }

    public int GetMax(int[] array)
    {
        int max = Integer.MIN_VALUE,
                size = array.length;

        for (int i = 0; i < size; i++)
            max = max < Math.abs(array[i]) ? Math.abs(array[i]) : max;

        return max;
    }



    @Override
    public String getName() {
        return "CUMULATIVE SUMS TEST";
    }
}
