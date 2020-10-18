package com.company.tests;

public class Converter {

    public static int[] convertBitsToInt(String line) {

        assert line.length() % 32 != 0;
        int length = line.length() / 32;
        String[] letters = new String[length];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = line.substring(i * 32, (i + 1) * 32);
        }

        var intArray = new int[letters.length];

        for (int i = 0; i < letters.length; i++) {

            intArray[i] = Integer.parseUnsignedInt(letters[i], 2);
        }
        return intArray;
    }

    public static String convertIntToBinaryString(int[] sequence) {

        var ans =new StringBuilder();
        for (var i : sequence) {
            ans.append(toBinString(i));
        }
        return ans.toString();
    }

    private static String toBinString(int num) {
        String currentBinary = Integer.toBinaryString(num);
        var ans= new StringBuilder();
        if (currentBinary.length()!=32){
            ans.append("0".repeat(32-currentBinary.length())).append(currentBinary);
        }else{
            ans.append(currentBinary);
        }

        if (ans.length()!=32){
            throw new RuntimeException(Integer.toString(currentBinary.length()));
        }
        return ans.toString();
    }
}
