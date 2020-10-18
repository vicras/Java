package com.company;

import com.company.des.Des;
import com.company.des.ScenarioTestable;
import com.company.hammingWeight.BigHammingWeight;
import com.company.hammingWeight.HammingWeightable;
import com.company.hammingWeight.LowHammingWeight;
import com.company.tests.CryptoTestable;

import java.util.Date;
import java.util.Random;

public class Scenario {
    private ScenarioTestable cipher;
    private CryptoTestable[] tests;
    private final int KEY_SIZE = 56;
    private final int BLOCK_SIZE = 64;
    private final int SEQUENCE_LENGTH = 8388608;//1024;//
    private final int BLOCK_AMOUNTS = SEQUENCE_LENGTH / BLOCK_SIZE;


    public Scenario(ScenarioTestable testable, CryptoTestable[] cryptoTestable) {
        this.cipher = testable;
        this.tests = cryptoTestable;
    }

    //region Scenario
    String getArbitraryChoiceScenario() {
        var inSeq = getSequence(SEQUENCE_LENGTH);
        var inKey = getSequence(KEY_SIZE);
        return cipher.getCipheredSequence(inSeq, inKey);
    }

    String getSpeciallyChoiceScenario(HammingWeightable hammingWeightable, boolean isKey) {
        if(isKey){
            var inSeq = new StringBuilder();
            var inKey = hammingWeightable.getVector(KEY_SIZE);
            for (var i = 0; i < BLOCK_AMOUNTS; i++) {
                inSeq.append(getSequence(BLOCK_SIZE));
            }
            return cipher.getCipheredSequence(inSeq.toString(), inKey);
        }else{
            var inSeq = new StringBuilder();
            var inKey = getSequence(KEY_SIZE);
            for (var i = 0; i < BLOCK_AMOUNTS; i++) {
                inSeq.append(hammingWeightable.getVector(64));
            }
            return cipher.getCipheredSequence(inSeq.toString(), inKey);
        }

    }

    String getKeyChangeChoiceScenario() {

        var inSeq = getZeroString(BLOCK_SIZE);
        var ans = new StringBuilder();
        var amountOfSequences = Math.max(SEQUENCE_LENGTH / BLOCK_SIZE / KEY_SIZE, 1);
        for (var i = 0; i < amountOfSequences; i++) {
            var inKey = getSequence(KEY_SIZE);
            for (var j = 0; j < KEY_SIZE; j++) {
                var a = cipher.getCipheredSequence(inSeq, inKey);
                var b = cipher.getCipheredSequence(inSeq, Des.xor(inKey, getZeroVectorWithOneUno(KEY_SIZE, j)));
                ans.append(Des.xor(a, b));
            }
        }

        return ans.substring(0, Math.min(SEQUENCE_LENGTH, ans.length()));
    }

    String getSequenceChangeChoiceScenario() {
        var inKey = getZeroString(KEY_SIZE);
        var ans = new StringBuilder();
        var amountOfSequences = Math.max(1, SEQUENCE_LENGTH / BLOCK_SIZE / BLOCK_SIZE);

        for (var i = 0; i < amountOfSequences; i++) {
            var inSeq = getSequence(BLOCK_SIZE);
            for (var j = 0; j < BLOCK_SIZE; j++) {
                var a = cipher.getCipheredSequence(inSeq, inKey);
                var b = cipher.getCipheredSequence(Des.xor(inSeq, getZeroVectorWithOneUno(BLOCK_SIZE, j)), inKey);
                ans.append(Des.xor(a, b));
            }
        }
        return ans.substring(0, Math.min(SEQUENCE_LENGTH, ans.length()));
    }

    String getMethodsOfProcessTechnologyChoiceScenario() {
        var inKey = getSequence(KEY_SIZE);
        var ans = new StringBuilder();

        for (var i=0 ; i <BLOCK_AMOUNTS;i++) {
            var inSeq=getSequence(BLOCK_SIZE);
            var blockResult = cipher.getCipheredSequence(inSeq, inKey);
            ans.append(Des.xor(inSeq, blockResult));
        }

        return ans.toString();
    }

    String getChainProcessingChoiceScenario() {
        var inKey = getSequence(KEY_SIZE);
        var inSeq = getZeroString(BLOCK_SIZE);
        var tempComp = new String[BLOCK_AMOUNTS];


        for (int i = 0; i < BLOCK_AMOUNTS; i++) {
            if (i == 0) {
                tempComp[i] = cipher.getCipheredSequence(inSeq, inKey);
            } else {
                tempComp[i] = cipher.getCipheredSequence(tempComp[i - 1], inKey);
            }
        }

        var ans = new StringBuilder();
        for (String s : tempComp) {
            ans.append(s);
        }
        return ans.toString();
    }
    //endregion


    public String runAllTest(HammingWeightable hammingWeightable) {
       /* var ans = new StringBuilder();
        ans.append("********************************************************************************\n");
        ans.append(new Date()).append("\n");
        for(int i=0 ;i<tests.length;i++){
            System.out.println("________________________________________________________________________________\n");
            System.out.println(("                                   Test # ")+(i + 1)+("\n"));
            System.out.println(("                                 ")+(tests[i].getTestName())+("\n"));
            System.out.println(("Исследование вероятностных свойств выходной последовательности режима простой \n" +
                    "замены при произвольном выборе открытого текста и ключа\n"));
            var temp=getArbitraryChoice();
            System.out.println(("Result: ")+(tests[i].getTestResult(temp))+("\n"));

            System.out.println(("Исследование вероЯтностных свойств выходной последовательности режима простой \n" +
                    "замены при специальном выборе открытого текста и ключа.\n"));
            temp=getSpeciallyChoice(hammingWeightable);
            System.out.println(("Result: ")+(tests[i].getTestResult(temp))+("\n"));

            System.out.println(("Исследование размножения ошибки при изменении ключа в режиме простой замены.\n"));
            temp=getKeyChangeChoice();
            System.out.println(("Result: ")+(tests[i].getTestResult(temp))+("\n"));

            System.out.println(("Исследование размножениЯ ошибки при изменении открытого текста в режиме простой\nзамены.\n"));
            temp=getSequenceChangeChoice();
            System.out.println(("Result: ")+(tests[i].getTestResult(temp))+("\n"));

            System.out.println(("Исследование коррелЯции открытого текста и зашифрованного текста в режиме \nпростой замены.\n"));
            temp=getMethodsOfProcessTechnologyChoice();
            System.out.println(("Result: ")+(tests[i].getTestResult(temp))+("\n"));

            System.out.println(("Исследование вероЯтностных свойств выходной последовательности в режиме цепочной\n обработки.\n"));
            temp=getChainProcessingChoice();
            System.out.println(("Result: ")+(tests[i].getTestResult(temp))+("\n"));


            System.out.println("________________________________________________________________________________\n");

        }
        System.out.println((new Date()) + ("\n"));
        System.out.println("********************************************************************************\n");
        return ans.toString();*/
        var ans = new StringBuilder();
        ans.append("********************************************************************************\n");
        ans.append(new Date()).append("\n");
        for (int i = 0; i < tests.length; i++) {
            ans.append("________________________________________________________________________________\n");
            ans.append("                                   Test # ").append(i + 1).append("\n");
            ans.append("                                 ").append(tests[i].getName()).append("\n");
            ans.append(("Исследование вероятностных свойств выходной последовательности режима простой \n" +
                    "замены при произвольном выборе открытого текста и ключа\n"));
            var temp = new String();
                    //getArbitraryChoiceScenario();
/*            ans.append("Result: ").append(tests[i].getResultOfTest(temp)).append("\n");*/

            ans.append(("Исследование вероЯтностных свойств выходной последовательности режима простой \n" +
                    "замены при специальном выборе открытого текста и ключа.\n"));
            temp = getSpeciallyChoiceScenario(new BigHammingWeight(), true);
            ans.append("Result: ").append(tests[i].getResultOfTest(temp)).append("\n");
            temp = getSpeciallyChoiceScenario(new LowHammingWeight(), true);
            ans.append("Result: ").append(tests[i].getResultOfTest(temp)).append("\n");
            temp = getSpeciallyChoiceScenario(new BigHammingWeight(), false);
            ans.append("Result: ").append(tests[i].getResultOfTest(temp)).append("\n");
            temp = getSpeciallyChoiceScenario(new LowHammingWeight(), false);
            ans.append("Result: ").append(tests[i].getResultOfTest(temp)).append("\n");
/*
            ans.append(("Исследование размножения ошибки при изменении ключа в режиме простой замены.\n"));
            temp = getKeyChangeChoiceScenario();
            ans.append("Result: ").append(tests[i].getResultOfTest(temp)).append("\n");

            ans.append(("Исследование размножениЯ ошибки при изменении открытого текста в режиме простой\nзамены.\n"));
            temp = getSequenceChangeChoiceScenario();
            ans.append("Result: ").append(tests[i].getResultOfTest(temp)).append("\n");

            ans.append(("Исследование коррелЯции открытого текста и зашифрованного текста в режиме \nпростой замены.\n"));
            temp = getMethodsOfProcessTechnologyChoiceScenario();
            ans.append("Result: ").append(tests[i].getResultOfTest(temp)).append("\n");

            ans.append(("Исследование вероЯтностных свойств выходной последовательности в режиме цепочной\n обработки.\n"));
            temp = getChainProcessingChoiceScenario();
            ans.append("Result: ").append(tests[i].getResultOfTest(temp)).append("\n");*/


            ans.append("________________________________________________________________________________\n");

        }
        ans.append(new Date()).append("\n");
        ans.append("********************************************************************************\n");
        return ans.toString();
    }

    private String getZeroVectorWithOneUno(int size, int position) {
        var ans = new StringBuilder();
        ans.append("0".repeat(Math.max(0, position)));
        ans.append("1");
        ans.append("0".repeat(Math.max(0, size - position - 1)));
        if (ans.length() != size)
            throw new RuntimeException("mistake with size of generated sequence");
        return ans.toString();
    }

    private String getZeroString(int size) {
        return "0".repeat(Math.max(0, size));
    }

    private String getSequence(int size) {
        var ans = new StringBuilder();
        var rnd = new Random();
        for (var i = 0; i < size; i++) {
            ans.append((rnd.nextInt() < 0) ? "0" : "1");
        }
        return ans.toString();
    }
}
