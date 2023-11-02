package HexletExcersises.Arrays.Multiplication;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[][] A = new int[][] {
                {2, 5},
                {6, 7},
                {1, 8}
        };
        int[][] B = new int[][] {
                {1, 2, 1, 0},
                {0, 1, 0, 0}
        };
        System.out.println(Arrays.deepToString(multiply(A, B)));
    }
    public static int[][] multiply(int[][] A, int[][] B) {

        int[][] C = new int[A.length][B[0].length];
        int sum = 0, a = 0, b = 0, i = 0;

        for (a = 0; a < A.length; a++) {
            b = 0;
            while (b < B[0].length) {
                for (i = 0; i < A[a].length; i++) {
                    sum += A[a][i] * B[i][b];
                }
                C[a][b] = sum;
                sum = 0;
                b++;
            }
        }

        return C;
    }
}