package HexletExcersises.Arrays.Snail;

import org.apache.commons.lang3.ArrayUtils;

class Main {
    public static void main(String[] args) {

        int[][] matrix1 = {{1, 2, 3, 4}};
        System.out.println(buildSnailPath(matrix1));


        int[][] matrix2 = {{1}, {2}, {3}, {4}};
        System.out.println(buildSnailPath(matrix2));

    }

    public static int[] buildSnailPath(int[][] matrix) {
        int[] snailPath;
        if (matrix.length == 0) {
            snailPath = new int[0];
            return snailPath;
        }

        int indexes = matrix.length * matrix[0].length;
        snailPath = new int[indexes];

        int circle = 1;
        int currentIndex = 0;
        int row = 0;
        int element = 0;


        while (currentIndex < indexes) {
            while (element < matrix[row].length - circle && currentIndex < indexes) {
                snailPath[currentIndex] = matrix[row][element];
                currentIndex++;
                element++;
            }

            while (row < matrix.length - circle && currentIndex < indexes) {
                snailPath[currentIndex] = matrix[row][element];
                currentIndex++;
                row++;
            }

            while (element >= 0 + circle && currentIndex < indexes) {
                snailPath[currentIndex] = matrix[row][element];
                currentIndex++;
                element--;
            }

            while (row >= 0 + circle && currentIndex < indexes) {
                snailPath[currentIndex] = matrix[row][element];
                currentIndex++;
                row--;
            }
            circle++;
            row++;
            element++;
        }
        return snailPath;
    }

}