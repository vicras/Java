package com.company.hammingWeight;

public class LowHammingWeight implements HammingWeightable {
    private final int UNO_AMOUNT = 2;

    @Override
    public String getVector(int size) {
        var ans = new StringBuilder();
        double a, b;
        do {
            a = rnd(0, size - 1);
            b = rnd(0, size - 1);
        } while (a == b);

        for (var i = 0; i < size; i++) {
            if (i == a || i == b)
                ans.append("1");
            else
                ans.append("0");
        }
        return ans.toString();
    }

    private static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
