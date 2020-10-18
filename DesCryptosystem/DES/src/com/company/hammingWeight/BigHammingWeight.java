package com.company.hammingWeight;

public class BigHammingWeight implements HammingWeightable {
    private final int ZERO_AMOUNT = 2;

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
                ans.append("0");
            else
                ans.append("1");
        }
        return ans.toString();
    }

    private static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
