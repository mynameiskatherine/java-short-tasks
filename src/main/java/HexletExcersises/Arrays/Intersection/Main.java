package HexletExcersises.Arrays.Intersection;

import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] numbers1 = new int[] {10, 10, 11, 24};
        int[] numbers2 = new int[] {10, 10, 13, 14, 24, 30};
        System.out.println(Arrays.toString(getIntersectionOfSortedArrays(numbers1, numbers2)));
    }
    public static int[] getIntersectionOfSortedArrays(int[] numbersArray1, int[] numbersArray2) {
        int[] intersection = new int[numbersArray1.length];
        int i = 0;
        int k = 0;
        while (i < numbersArray1.length) {
            if (ArrayUtils.contains(numbersArray2, numbersArray1[i])) {
                intersection[k] = numbersArray1[i];
                if (k == 0) {
                    k++;
                } else if (k > 0 && intersection[k - 1] != intersection[k]) {
                    k++;
                }
            }
            i++;
        }
        return Arrays.copyOf(intersection, k);
    }
    // END
}