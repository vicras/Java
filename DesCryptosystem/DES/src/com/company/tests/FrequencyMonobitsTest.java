package com.company.tests;


import com.company.tests.CryptoTestable;
import org.apache.commons.math3.special.Erf;

public class FrequencyMonobitsTest implements CryptoTestable {
    public FrequencyMonobitsTest(){}
    @Override
    public boolean getResultOfTest(String sequence) {
        int sum=0;
        for(var i:sequence.toCharArray()){
            if(i=='0') sum--;
            else sum++;
        }
        double sObs=(double)sum/Math.sqrt(sequence.length());
        var res=Erf.erfc(sObs/Math.sqrt(2));
        return res>0.01;
    }

    @Override
    public String getName() {
        return "FREQUENCY MONOBITS TEST";
    }
}

