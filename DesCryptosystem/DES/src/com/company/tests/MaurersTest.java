package com.company.tests;

//import com.company.Util.Converter;
import org.apache.commons.math3.special.Erf;

import java.util.HashMap;

public class MaurersTest implements CryptoTestable{
    private static int[] lengths =
            { 387840, 904960, 2068480, 4654080,
                    10342400, 22753280, 49643520,
                    107560960, 231669760, 496435200,
                    1059061760 };
    private static double[] expectedValues =
            { 0, 0, 0, 0, 0, 0,
                    5.2177052, 6.1962507, 7.1836656,
                    8.1764248, 9.1723243, 10.170032,
                    11.168765, 12.168070, 13.167693,
                    14.167488, 15.167379 };
    private static double[] variances =
            { 0, 0, 0, 0, 0, 0,
                    2.954, 3.125, 3.238, 3.311, 3.356,
                    3.384, 3.401, 3.416, 3.419, 3.421 };

    public MaurersTest(){}
    @Override
    public boolean getResultOfTest(String line) {
        int[]sequence = Converter.convertBitsToInt(line);
        int i = 0;
        while (i < lengths.length &&
                lengths[i] < sequence.length * (32))
            ++i;
        if (i == 0)
            return false;

        int blockLength = 5 + i;
        int initBlocks = 10 << blockLength;

        BitBlockArray bitBlockArray = new BitBlockArray(sequence, blockLength);
        HashMap<Integer, Integer> lastBlock = new HashMap<>();

        for (i = 0; i < initBlocks; ++i)
            lastBlock.put(bitBlockArray.getBlock(i), i + 1);

        int remBlocks = sequence.length * (32) / blockLength - initBlocks;
        double sum = 0;
        for (i = initBlocks; i < initBlocks + remBlocks; ++i)
        {
            int lastIndex = lastBlock.containsKey(bitBlockArray.getBlock(i))
                    ? lastBlock.get(bitBlockArray.getBlock(i))
                    : 0;
            sum += Math.log((i + 1) - lastIndex)/Math.log(2);
            lastBlock.put(bitBlockArray.getBlock(i),i + 1);
        }
        sum /= remBlocks;

        double sigma =
                (0.7 - 0.8 / blockLength + (4 + 32.0 / blockLength) *
                        Math.pow(remBlocks, -3.0 / blockLength) / 15) *
                        Math.sqrt(variances[blockLength] / remBlocks);
        double pVal = Erf.erfc
                (Math.abs((sum - expectedValues[blockLength]) /
                        (Math.sqrt(2) * sigma)));
        return pVal >= 0.01;
    }

    @Override
    public String getName() {
        return "MAURER'S UNIVERSAL STATISTICAL TEST";
    }
}

class BitBlockArray
{
    private int[] bits;
    private int blockSize;

    private static int getLastBitsShifted
            (int number, int shift, int numberOfBits)
    {
        return (number >>> shift) & ((1 << numberOfBits) - 1);
    }

    public BitBlockArray(int[] bits, int blockSize)
    {
        this.bits = new int[bits.length];
        System.arraycopy(bits, 0, this.bits, 0, bits.length);
        this.bits = bits;
        this.blockSize = blockSize;
    }

    public int getBlock(int index)
    {
        int inBlockNumber = index * blockSize / 32,
                leftBits = 32 - index * blockSize % 32;
        if (leftBits >= blockSize)
            return getLastBitsShifted(bits[inBlockNumber], leftBits - blockSize, blockSize);
        else
        {
            int firstPart = getLastBitsShifted(bits[inBlockNumber], 0, leftBits);
            int secondPart = getLastBitsShifted(bits[inBlockNumber + 1],
                    32 - (blockSize - leftBits),
                    blockSize - leftBits);
            return (firstPart << (blockSize - leftBits)) | secondPart;
        }
    }
}