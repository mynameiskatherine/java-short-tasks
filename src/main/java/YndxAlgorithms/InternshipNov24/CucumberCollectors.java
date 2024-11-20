package YndxAlgorithms.InternshipNov24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CucumberCollectors {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

//            int groupsNumber = Integer.parseInt(reader.readLine());
//            String[] groups = new String[groupsNumber];
//            for (int i = 0; i < groupsNumber; i++) {
//                groups[i] = reader.readLine();
//            }
//            int bottles = Integer.parseInt(reader.readLine());

            Scanner scanner = new Scanner("2\n" +
                    "1 0\n" +
                    "2 0 1\n" +
                    "3\n");
            int groupsNumber = Integer.parseInt(scanner.nextLine());
            String[] groups = new String[groupsNumber];
            for (int i = 0; i < groupsNumber; i++) {
                groups[i] = scanner.nextLine();
            }
            int bottles = Integer.parseInt(scanner.nextLine());

            int[] result = calculate(groups, bottles);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                builder.append(result[i]).append(" ");
            }
            writer.write(builder.toString().trim());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] calculate(String[] groups, int bottles) {
        int[] countingBottles = new int[groups.length];
        for (int i = 0; i < groups.length; i++) {
            String[] transGroup = groups[i].split(" ");

            int[] group = new int[Integer.parseInt(transGroup[0])];
            for (int j = 0; j < group.length; j++) {
                group[j] = Integer.parseInt(transGroup[j + 1]);
            }
            Arrays.sort(group);
            int median = group[group.length / 2];
            countingBottles[i] = median;
        }

        int sumOfBottles = 0;
        for (int e : countingBottles) {
            sumOfBottles += e;
        }

            if (sumOfBottles > bottles) {
                int dif = sumOfBottles - bottles;
                for (int i = 0; i < countingBottles.length; i++) {
                    int difToGroup = dif / (countingBottles.length - i);
                    if (countingBottles[i] - difToGroup >= 0) {
                        countingBottles[i] -= difToGroup;
                        dif -= difToGroup;
                    } else {
                        dif -= countingBottles[i];
                        countingBottles[i] = 0;
                    }
                }
            }
            if (sumOfBottles < bottles) {
                int dif = bottles - sumOfBottles;
                for (int i = 0; i < countingBottles.length; i++) {
                    int difToGroup = dif / (countingBottles.length - i);
                    countingBottles[i] += difToGroup;
                    dif -= difToGroup;
                }
            }
        return countingBottles;
    }
}
