package com.company.des;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Des implements ScenarioTestable {

    /**
     * first- vector index
     * second line number
     * third column number
     */
    private static int[][][] SBox;
    private static int[][] PBox;
    private static int[][] IPStartBox;
    private static int[][] IPEndBox;
    private static int[][] PCiBox;
    private static int[][] PC2Box;
    private static int[] ShiftBox;

    private static void fillSBox() {
        SBox = new int[8][][];
        SBox[0] = new int[][]{{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}};
        SBox[1] = new int[][]{
                {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
        };
        SBox[2] = new int[][]{
                {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
        };
        SBox[3] = new int[][]{
                {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
        };
        SBox[4] = new int[][]{
                {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
        };
        SBox[5] = new int[][]{
                {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
        };
        SBox[6] = new int[][]{
                {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
        };
        SBox[7] = new int[][]{
                {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
                {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
                {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
                {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
        };

        PBox = new int[][]{
                {16, 7, 20, 21, 29, 12, 28, 17},
                {1, 15, 23, 26, 5, 18, 31, 10},
                {2, 8, 24, 14, 32, 27, 3, 9},
                {19, 13, 30, 6, 22, 11, 4, 25},
        };

        IPStartBox = new int[][]{
                {58, 50, 42, 34, 26, 18, 10, 2},
                {60, 52, 44, 36, 28, 20, 12, 4},
                {62, 54, 46, 38, 30, 22, 14, 6},
                {64, 56, 48, 40, 32, 24, 16, 8},
                {57, 49, 41, 33, 25, 17, 9, 1},
                {59, 51, 43, 35, 27, 19, 11, 3},
                {61, 53, 45, 37, 29, 21, 13, 5},
                {63, 55, 47, 39, 31, 23, 15, 7},
        };
        IPEndBox = new int[][]{
                {40, 8, 48, 16, 56, 24, 64, 32},
                {39, 7, 47, 15, 55, 23, 63, 31},
                {38, 6, 46, 14, 54, 22, 62, 30},
                {37, 5, 45, 13, 53, 21, 61, 29},
                {36, 4, 44, 12, 52, 20, 60, 28},
                {35, 3, 43, 11, 51, 19, 59, 27},
                {34, 2, 42, 10, 50, 18, 58, 26},
                {33, 1, 41, 9, 49, 17, 57, 25},
        };
        PCiBox = new int[][]{
                {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18},
                {10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36},
                {63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22},
                {14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4},
        };

        PC2Box = new int[][]{
                {14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10},
                {23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2},
                {41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48},
                {44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32},
        };

        ShiftBox = new int[]{
                1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1
        };

    }

    public static void main(String[] args) {
        fillSBox();
        var temp=doEncrypt("Hello, today rainy and dull", "qwertyu");
        System.out.println(temp);
        var tempDec=doDecrypt(temp, "qwertyu");
        System.out.println(tempDec);
    }

    public static void encrypt(String fileToEncrypt, String keyFile, String resultFileName) {
        fillSBox();
        var text= TextWorker.read(fileToEncrypt);
        var key=TextWorker.read(keyFile);
        var result= doEncrypt(text, key);
        TextWorker.write(resultFileName, result);
    }

    public static void decrypt(String fileToDecrypt, String keyFile, String resultFileName){
        fillSBox();
        var text=TextWorker.read(fileToDecrypt);
        var key=TextWorker.read(keyFile);
        var result= doDecrypt(text, key);
        TextWorker.write(resultFileName, result);
    }

    private static String doEncrypt(String line, String aKey) {
        var text = CodeUTF8.convertToBin(line, false);
        var key = CodeUTF8.convertToBin(aKey, true);
        var textBlocks = makeBlocks(text);
        var keyList = getKeyList(key);
        var ans = new StringBuilder();

        for (String textBlock : textBlocks) {
            ans.append(execDesRoundEncrypt(textBlock, keyList));
        }
        return ans.toString();
    }

    private static String doDecrypt(String line, String aKey) {
        var key = CodeUTF8.convertToBin(aKey, true);
        var textBlocks = makeBlocks(line);
        var keyList = getKeyList(key);
        var ans = new StringBuilder();

        for (String textBlock : textBlocks) {
            ans.append(execDesRoundDecrypt(textBlock, keyList));
        }
        return CodeUTF8.convertToString(ans.toString());
    }

    private static String[] makeBlocks(String text) {
        if (text.length() % 64 != 0)
            throw new RuntimeException("text format is wrong");
        var ans = new String[text.length() / 64];
        for (var i = 0; i < ans.length; i++) {
            ans[i] = text.substring(i * 64, (i + 1) * 64);
        }
        return ans;
    }

    private static String execDesRoundEncrypt(String block, String[] keyList) {
        var desPair = getDesPair(block);
        for (int i = 0; i < 16; i++) {
            desPair = desRound(desPair, keyList[i], true);
        }
        return desPair.left + desPair.right;
    }

    private static String execDesRoundDecrypt(String block, String[] keyList) {
        var desPair = getDesPair(block);
        for (int i = 15; i >= 0; i--) {
            desPair = desRound(desPair, keyList[i],false);
        }
        return desPair.left + desPair.right;
    }

    private static DesPair getDesPair(String text) {
        if (text.length() != 64)
            throw new RuntimeException("block size is wrong");
        return new DesPair(text.substring(0, 32), text.substring(32, 64));
    }

    private static DesPair desRound(DesPair pair, String key, boolean isEncrypt) {
        DesPair ans = new DesPair();
        if(isEncrypt){
            ans.left = pair.right;
            ans.right = xor(desFunction(pair.right, key), pair.left);
        }
        else{
            ans.right=pair.left;
            ans.left=xor(desFunction(pair.left,key), pair.right);
        }

        return ans;
    }

    private static String desFunction(String side, String key) {
        var modRight = expansionUnit(side);
        var xorRight = xor(modRight, key);
        var sConversion = sUnit(xorRight);
        return pUnit(sConversion);
    }

    private static String expansionUnit(String rightPart) {
        var sections = new String[8];
        var resultSections = new String[8];
        for (int i = 0; i < 8; i++) {
            sections[i] = rightPart.substring(i * 4, (i + 1) * 4);
        }
        for (int i = 1; i < 7; i++) {
            resultSections[i] = sections[i - 1].charAt(3) + sections[i] + sections[i + 1].charAt(0);
        }
        resultSections[0] = sections[7].charAt(3) + sections[0] + sections[1].charAt(0);
        resultSections[7] = sections[6].charAt(3) + sections[7] + sections[0].charAt(0);
        var ans = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            ans.append(resultSections[i]);
        }
        return ans.toString();
    }

    public static String xor(String a, String b) {
        if (a.length() != b.length()) {
            throw new RuntimeException("operand 1 and 2 has different length in xor function");
        }

        var ans = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '0' && b.charAt(i) == '0') ans.append('0');
            if (a.charAt(i) == '1' && b.charAt(i) == '0') ans.append('1');
            if (a.charAt(i) == '0' && b.charAt(i) == '1') ans.append('1');
            if (a.charAt(i) == '1' && b.charAt(i) == '1') ans.append('0');
        }
        return ans.toString();
    }

    private static String sUnit(String rightPart) {
        var sections = new String[8];
        var boxHelper = new BoxPair[8];
        var ansSections = new String[8];
        for (int i = 0; i < 8; i++) {
            sections[i] = rightPart.substring(i * 6, (i + 1) * 6);
        }
        for (int i = 0; i < 8; i++) {
            boxHelper[i] = getBoxValue(sections[i]);
        }
        for (int i = 0; i < 8; i++) {
            ansSections[i] = toBinStringSUnit(SBox[i][boxHelper[i].line][boxHelper[i].column]);
        }
        var ans = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            ans.append(ansSections[i]);
        }
        if (ans.length() != 32)
            throw new RuntimeException("something go wrong");

        return ans.toString();
    }

    private static BoxPair getBoxValue(String line) {
        if (line.length() != 6)
            throw new RuntimeException("string length is not right, was expected 6");

        StringBuilder lineNum = new StringBuilder();
        StringBuilder columnNum = new StringBuilder();

        lineNum.append(line.charAt(0)).append(line.charAt(5));
        columnNum.append(line.charAt(1)).append(line.charAt(2)).append(line.charAt(3)).append(line.charAt(4));
        return new BoxPair(CodeUTF8.toIntFromBin(lineNum.toString()), CodeUTF8.toIntFromBin(columnNum.toString()));
    }

    private static String toBinStringSUnit(int num) {
        String currentBinary = Integer.toBinaryString(256 + num);
        return (currentBinary.substring(currentBinary.length() - 4));
    }

    private static String pUnit(String text) {
        var ans = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++)
                ans.append(text.charAt(PBox[i][j] - 1));
        }
        return ans.toString();
    }

    private static String[] getKeyList(String key) {
        if (key.length() != 56)
            throw new RuntimeException("key size is not 56 bit");
        var ans = new String[16];
        var enlargedKey = getNormalisedKey(key);
        var cKey = new StringBuilder();
        var dKey = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 14; j++)
                cKey.append(enlargedKey.charAt(PCiBox[i][j] - 1));
        }
        for (int i = 2; i < 4; i++) {
            for (int j = 0; j < 14; j++)
                dKey.append(enlargedKey.charAt(PCiBox[i][j] - 1));
        }
        var cShift = cKey.toString();
        var dShift = dKey.toString();

        for (int i = 0; i < 16; i++) {
            cShift = makeShift(cShift, ShiftBox[i]);
            dShift = makeShift(dShift, ShiftBox[i]);
            ans[i] = getIterationKey(cShift, dShift);
        }
        return ans;
    }

    private static String makeShift(String key, int shift) {
        return key.substring(shift) + key.substring(0, shift);
    }

    private static String getIterationKey(String cKey, String dKey) {
        if (cKey.length() != 28 || dKey.length() != 28)
            throw new RuntimeException("cKey or dKey size is not fit");
        var sumKey = (cKey + dKey);
        var ans = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++)
                ans.append(sumKey.charAt(PC2Box[i][j] - 1));
        }
        return ans.toString();
    }

    private static String getNormalisedKey(String key) {
        var ans = new StringBuilder();
        var amountsOfUno = 0;
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == '1') amountsOfUno++;
            ans.append(key.charAt(i));
            if (i % 7 == 0) {
                if (amountsOfUno % 2 == 0)
                    ans.append('1');
                else
                    ans.append('0');
                amountsOfUno = 0;
            }
        }
        if (ans.length() != 64)
            throw new RuntimeException("expected key length ==64 real length: " + ans.length());
        return ans.toString();
    }

    @Override
    public String getCipheredSequence(String sequence, String key) throws NoSuchElementException {
        fillSBox();
        if(key.length()!=56) throw new NumberFormatException("key size is not support");
        if(sequence.length()%64!=0) throw new NumberFormatException("sequence size is not support");
        for(var i=0; i<sequence.length();i++)
            if(sequence.charAt(i)!='0' && sequence.charAt(i)!='1') throw  new NumberFormatException("sequence has wrong format");

        var textBlocks = makeBlocks(sequence);
        var keyList = getKeyList(key);
        var ans = new StringBuilder();

        for (String textBlock : textBlocks) {
            ans.append(execDesRoundEncrypt(textBlock, keyList));
        }
        return ans.toString();
    }
}

class DesPair {
    String left;
    String right;

    DesPair(String left, String right) {
        this.left = left;
        this.right = right;
    }

    DesPair() {
    }
}

class BoxPair {
    int line;
    int column;

    BoxPair(int line, int column) {
        this.line = line;
        this.column = column;
    }

}

