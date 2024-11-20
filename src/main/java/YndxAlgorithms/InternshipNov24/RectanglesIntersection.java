package YndxAlgorithms.InternshipNov24;

import java.io.*;
import java.util.Scanner;

public class RectanglesIntersection {
//    public static void main(String[] args) {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
//
////            int rectanglesNumber = Integer.parseInt(reader.readLine());
////            String[] rectangles = new String[rectanglesNumber];
////            for (int i = 0; i < rectanglesNumber; i++) {
////                rectangles[i] = reader.readLine();
////            }
//
//            Scanner scanner = new Scanner("6\n" +
//                    "-2 -4 2 2\n" +
//                    "-2 -4 0 -1\n" +
//                    "-2 -1 0 2\n" +
//                    "0 -4 2 -1\n" +
//                    "0 -1 2 2\n" +
//                    "-1 -2 1 0\n");
//            int rectanglesNumber = Integer.parseInt(scanner.nextLine());
//            String[] rectangles = new String[rectanglesNumber];
//            for (int i = 0; i < rectanglesNumber; i++) {
//                rectangles[i] = scanner.nextLine();
//            }
//
//            int[] result = calculate(rectangles);
//            StringBuilder builder = new StringBuilder();
//            for (int i = 0; i < result.length; i++) {
//                builder.append(result[i]).append(" ");
//            }
//            writer.write(builder.toString().trim());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        int n = 6;
//        int[][] rectangles = {
//                {-2, -4, 2, 2},
//                {-2, -4, 0, -1},
//                {-2, -1, 0, 2},
//                {0, -4, 2, -1},
//                {0, -1, 2, 2},
//                {-1, -2, 1, 0}
//        };
//
//        List<Integer> intersectionCounts = rectangleIntersections(n, rectangles);
//        System.out.println("Intersection Counts: " + intersectionCounts);
//    }
//
//        private static int[] calculate(int n, int[][] rectangles) {
//            int[] intersections = new int[];
//            for (int i = 0; i < n; i++) {
//                intersections.add(0); // Initialize intersection count for each rectangle
//            }
//
//            for (int i = 0; i < n; i++) {
//                for (int j = i + 1; j < n; j++) {
//                    int[] rect1 = rectangles[i];
//                    int[] rect2 = rectangles[j];
//
//                    // Check for X-overlap
//                    boolean xOverlap = rect1[0] < rect2[2] && rect1[2] > rect2[0];
//
//                    // Check for Y-overlap
//                    boolean yOverlap = rect1[1] < rect2[3] && rect1[3] > rect2[1];
//
//                    // If both X and Y overlap, increment intersection count
//                    if (xOverlap && yOverlap) {
//                        intersections.set(i, intersections.get(i) + 1);
//                        intersections.set(j, intersections.get(j) + 1);
//                    }
//                }
//            }
//
//            return intersections;
//        }
}
