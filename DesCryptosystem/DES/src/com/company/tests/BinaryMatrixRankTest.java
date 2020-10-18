package com.company.tests;

//import com.company.Util.Converter;
import com.company.tests.Converter;
import com.company.tests.CryptoTestable;
import org.apache.commons.math3.special.Gamma;

public class BinaryMatrixRankTest implements CryptoTestable {
    public BinaryMatrixRankTest(){}

    @Override
    public boolean getResultOfTest(String line) {

        int[]mass = Converter.convertBitsToInt(line);

        return PerformTest(mass);
    }

    @Override
    public String getName() {
        return "Binary matrix rank test";
    }

    private int computeRank(int M, int Q, int[][] matrix)
    {

        /* FORWARD APPLICATION OF ELEMENTARY ROW OPERATIONS */
        for (int i = 0; i < Math.min(M, Q) - 1; i++)
        {
            if (matrix[i][i] == 1)
            {
                performElementaryRowOperations(true, i, M, Q, matrix);
            }
                else
            { 	/* matrix[i][i] = 0 */
                if (findUnitElementAndSwap(true, i, M, Q, matrix))
                {
                    performElementaryRowOperations(true, i, M, Q, matrix);
                }
            }
        }

        /* BACKWARD APPLICATION OF ELEMENTARY ROW OPERATIONS */
        for (int i = Math.min(M, Q) - 1; i > 0; i--)
        {
            if (matrix[i][i] == 1)
            {
                performElementaryRowOperations(false, i, M, Q, matrix);
            }
                else
            { 	/* matrix[i][i] = 0 */
                if (findUnitElementAndSwap(false, i, M, Q, matrix))
                {
                    performElementaryRowOperations(false, i, M, Q, matrix);
                }
            }
        }

        return determineRank(Math.min(Q, M), M, Q, matrix);
    }

    private void performElementaryRowOperations(boolean forward, int i, int M, int Q, int[][] A)
    {
        if (forward)
        {
            for (int j = i + 1; j < M; j++)
            {
                if (A[j][i] == 1)
                {
                    for (int k = i; k < Q; k++)
                    {
                        A[j][k] = (A[j][k] + A[i][k]) % 2;
                    }
                }
            }
        }
        else
        {
            for (int j = i - 1; j >= 0; j--)
            {
                if (A[j][i] == 1)
                {
                    for (int k = 0; k < Q; k++)
                    {
                        A[j][k] = (A[j][k] + A[i][k]) % 2;
                    }
                }
            }
        }
    }

    private boolean findUnitElementAndSwap(boolean forward, int i, int M, int Q, int[][] A)
    {
        if (forward)
        {
            int index = i + 1;
            while ((index < M) && (A[index][i] == 0))
            {
                index++;
            }
            if (index < M)
            {
                swapRows(i, index, Q, A);
                return true;
            }
        }
        else
        {
            int index = i - 1;
            while ((index >= 0) && (A[index][i] == 0))
            {
                index--;
            }
            if (index >= 0)
            {
                swapRows(i, index, Q, A);
                return true;
            }
        }
        return false;
    }

    private void swapRows(int i, int index, int Q, int[][] A)
    {
        for (int p = 0; p < Q; p++)
        {
            int temp = A[i][p];
            A[i][p] = A[index][p];
            A[index][p] = temp;
        }
    }

    private int determineRank(int m, int M, int Q, int[][] A)
    {
        /* DETERMINE RANK, THAT IS, COUNT THE NUMBER OF NONZERO ROWS */
        int rank = m;
        for (int i = 0; i < M; i++)
        {
            boolean allZeroes = true;
            for (int j = 0; j < Q; j++)
            {
                if (A[i][j] == 1)
                {
                    allZeroes = false;
                    break;
                }
            }
            if (allZeroes)
            {
                rank--;
            }
        }
        return rank;
    }

    private static int M = 32;
    private static int Q = M;

    public boolean PerformTest(int[] sequence)
    {
        int n = sequence.length*32;

        double[] Pm = new double[3];
        int r = Math.min(M, Q);     //compute predicted probabilities
        double product = 1;
        for (int i = 0; i <= r - 1; i++)
        {
            product *= ((1.0 - Math.pow(2, i - Q)) * (1.0 - Math.pow(2, i - M))) / (1.0 - Math.pow(2, i - r));
        }
        Pm[0] = Math.pow(2, r * (M + Q - r) - M * Q) * product;
        r--;
        product = 1;
        for (int i = 0; i <= r - 1; i++)
        {
            product *= ((1.0 - Math.pow(2, i - Q)) * (1.0 - Math.pow(2, i - M))) / (1.0 - Math.pow(2, i - r));
        }
        Pm[1] = Math.pow(2, r * (M + Q - r) - M * Q) * product;
        Pm[2] = 1 - (Pm[0] + Pm[1]);

        int N = n / (M * Q); //number of blocks
        int[] Fm = new int[3];
        String binary = Converter.convertIntToBinaryString(sequence);
        for (int k = 0; k < N; k++)
        {
            //construct the matrix of MxQ in size
            int[][] matrix = new int[M][Q];
            for (int i = 0; i < M; i++)
            {
                for (int j = 0; j < Q; j++)
                {
                    matrix[i][j] = binary.charAt(k * (M * Q) + j + i * Q) - '0';
                }
            }

            int R = computeRank(M, Q, matrix); //get the rank of the matrix

            if (R == M)
            {
                Fm[0]++;	//full rank
            }
            else if (R == M - 1)
            {
                Fm[1]++;    //full rank - 1
            }
        }
        Fm[2] = N - (Fm[0] + Fm[1]); //full rank - 2

        //compute p_value
        double chi_squared = (Math.pow(Fm[0] - N * Pm[0], 2) / (N * Pm[0]) +
                Math.pow(Fm[1] - N * Pm[1], 2) / (N * Pm[1]) +
                Math.pow(Fm[2] - N * Pm[2], 2) / (N * Pm[2]));
        double p_value = Gamma.regularizedGammaP(1, chi_squared / 2.0);

        return p_value>0.01;
    }
}
