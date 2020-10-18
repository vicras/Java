package com.company.tests;

import com.company.tests.CryptoTestable;
import org.apache.commons.math3.special.Erf;

public class RunsTest implements CryptoTestable {
    private int length;

    public RunsTest(){}

    @Override
    public boolean getResultOfTest(String binaryLine) {
        if(binaryLine == null)
        {
            System.out.println("there are no binaryLine");
            return false;
        }
        length = binaryLine.length();
        double frequency = getFrequency(binaryLine);
        if(!checkFrequency(frequency))
        {
            System.out.println("frequency test failed");
            return false;
        }
        int statistic = 0;
        for(int i = 0;i<length-1;i++){
            if(binaryLine.charAt(i) != binaryLine.charAt(i+1))
                statistic++;
        }
        statistic++;
        double Pvalue = 1- Erf.erf(Math.abs((double)statistic-2*length*frequency*(1-frequency))/
                (2*Math.sqrt(2*length)*frequency*(1-frequency)));
        return Pvalue>=0.01;
    }

    @Override
    public String getName() {
        return "RUNS TEST";
    }

    private double getFrequency(String binaryLine){
        int counter = 0;
        for(int i = 0;i<length;i++)
        {
            if(binaryLine.charAt(i)=='1')
                counter++;
        }
        double frequency = (double)counter/length;
        return frequency;
    }

    private boolean checkFrequency(double frequency)
    {
        double criticalValue = (double)2/Math.sqrt(length);
        return Math.abs(frequency-0.5)<criticalValue;
    }
}
