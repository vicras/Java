package com.company.des;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

class CodeUTF8 {
    private static Charset utf8 = StandardCharsets.UTF_8;

    public static void main(String[] args) {
        byte[] ch = {99, 97, 110, 102};

        System.out.println((convertToBin(decode(ch),false)));
        System.out.println(Arrays.toString(coder("Hello")));
        ch = coder("Hello");
        for (var i : ch) {
            System.out.println(toBinString(i));
        }
        String tempBin = convertToBin("Hello it's me !!!", false);
        String tempText = convertToString(tempBin);
        System.out.println(tempBin);
        System.out.println(tempText);
    }

    private static String decode(byte[] ch) {
        return new String(ch, utf8);
    }

    private static byte[] coder(String str) {
        return str.getBytes(utf8);
    }

    private static String toBinString(int num) {
        String currentBinary = Integer.toBinaryString(256 + num);
        return (currentBinary.substring(currentBinary.length() - 8));
    }

    static int toIntFromBin(String num) {
        return Integer.parseUnsignedInt(num, 2);
    }

    static String convertToBin(String text, boolean isKey) {
        StringBuilder textBuilder = new StringBuilder(text);
        if (!isKey) {
            while (textBuilder.length() * 8 % 64 != 0) {
                textBuilder.append(" ");
            }
        }
        text = textBuilder.toString();
        byte[] temp = coder(text);
        var ans = new StringBuilder();
        for (var i : temp) {
            ans.append(toBinString(i));
        }
        if (isKey && ans.length() != 56)
            throw new RuntimeException("key length is wrong");

        return ans.toString();
    }


    static String convertToString(String binText) {
        assert binText.length() % 8 != 0;
        int length = binText.length() / 8;
        String[] letters = new String[length];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = binText.substring(i * 8, (i + 1) * 8);
        }
        var byteArray = new byte[letters.length];
        for (int i = 0; i < letters.length; i++) {
            byteArray[i] = (byte) toIntFromBin(letters[i]);
        }
        return decode(byteArray);
    }

}
