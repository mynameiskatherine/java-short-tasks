package HexletExcersises.Arrays.Chunk;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        String[] numbers = new String[] {"one", "two", "three", "four", "five"};
        int i = 2;
        System.out.println(Arrays.toString(chunk(numbers, i)));
    }
    public static String[][] chunk(String[] str, int chunk) {
        String[][] result;

        if (str.length % chunk != 0) {
            result = new String[str.length / chunk + 1][];
            for (int j = 0; j <= str.length / chunk; j++) {
                result[j] = new String[chunk];
            }
            result[str.length / chunk] = new String[str.length % chunk];
        } else {
            result = new String[str.length / chunk][chunk];
        }

        int l = 0;
        while (l < str.length) {
            for (int i = 0; i < result.length; i++) {
                for (int k = 0; k < result[i].length; k++) {
                    result[i][k] = str[l];
                    l++;
                }
            }
        }
        return result;
    }
}