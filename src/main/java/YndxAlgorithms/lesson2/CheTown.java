package YndxAlgorithms.lesson2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CheTown {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

//            Scanner scanner = new Scanner(Paths.get("src", "main", "resources", "input.txt").toAbsolutePath().normalize());
            String[] sizeAndDistance = reader.readLine().split(" ");
            int distance = Integer.parseInt(sizeAndDistance[1]);
            String[] numbers = reader.readLine().split(" ");
            int[] monumentsDistances = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                monumentsDistances[i] = Integer.parseInt(numbers[i]);
            }

            long result = calculate(monumentsDistances, distance);
            writer.write(String.valueOf(result));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long calculate(int[] monumentsDistances, int distance) {
        long combinations = 0;
        int right = 1;
        for (int l = 0; l < monumentsDistances.length; l++) {
            while ((right < monumentsDistances.length) && (monumentsDistances[right] - monumentsDistances[l] <= distance)) {
                right += 1;
            }
            combinations += (monumentsDistances.length - right);
        }
        return combinations;
    }
}