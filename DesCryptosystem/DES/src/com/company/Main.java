package com.company;

import com.company.des.Des;
import com.company.hammingWeight.LowHammingWeight;
import com.company.tests.*;

public class Main {

    public static void main(String[] args) {
        Des.encrypt("in.txt", "key.txt", "crypt.txt");
        Des.decrypt("crypt.txt", "key.txt", "decrypt.txt");

        CryptoTestable[] tests = new CryptoTestable[]{
                new FrequencyMonobitsTest(),
                new BinaryMatrixRankTest(),
                new CumSumTest(),
                new FrequencyMonobitsTest(),
                new LinearComplexityTest(),
                new LongestRunOfOnesTest(),
                new MaurersTest(),
                new RandomExcursionsTest(),
                new RunsTest(),
                new SerialTest(),
        };

        var scenario = new Scenario(new Des(), tests);

        System.out.println(scenario.runAllTest(new LowHammingWeight()));
    }
}
