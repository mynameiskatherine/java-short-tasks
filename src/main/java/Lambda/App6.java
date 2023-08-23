package Lambda;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class App6 {

    public static void main(String[] args) {
        Map<Integer, Map<Integer, Double>> result1 = App6.calculateProbabilities(
                new ArrayList<Integer>()
        );
        System.out.println(result1); // => {}

        Map<Integer, Map<Integer, Double>> result2 = App6.calculateProbabilities(
                List.of(1, 3, 1, 5, 1, 2, 1, 6)
        );
        System.out.println(result2);
        // => {1={2=0.25, 3=0.25, 5=0.25, 6=0.25}, 2={1=1.0}, 3={1=1.0}, 5={1=1.0}, 6={}}

        Map<Integer, Map<Integer, Double>> result4 = App6.calculateProbabilities(
                List.of(1, 3, 1, 5, 1, 2, 1, 6)
        );
        System.out.println(result4);

        Map<Integer, Map<Integer, Double>> result3 = App6.calculateProbabilities(
                List.of(1, 3, 1, 3, 1, 2, 2, 6)
        );
        System.out.println(result3);
    }

    public static Map<Integer, Map<Integer, Double>> calculateProbabilities(List<Integer> list) {
        //initial variant
//        Map<Integer, Map<Integer, Double>> countPairs = new HashMap<>();
//
//        List<List<Integer>> pairs = IntStream.range(0, list.size())
//                .mapToObj(ind  -> {
//                    if (ind == list.size() - 1) {
//                        return new ArrayList<Integer>(List.of(list.get(ind), null));
//                    } else {
//                        return new ArrayList<Integer>(List.of(list.get(ind), list.get(ind + 1)));
//                    }
//                })
//                .collect(Collectors.toList());
//
//        for (List<Integer> pair : pairs) {
//            countPairs.computeIfAbsent(pair.get(0), k -> new HashMap<>())
//                    .merge(pair.get(1), 1d, Double::sum);
//        }
//
//        countPairs.forEach((k, v) -> {
//            Double sum = v.values().stream().reduce(0d, Double::sum);
//            v.replaceAll((s, val) -> val / sum);
//        });
//
//        return countPairs;

        Map<Integer, Map<Integer, Double>> matrix = list.stream().distinct().collect(Collectors.toMap(l -> l, v -> new HashMap<Integer, Double>()));
        for (Integer key : matrix.keySet()) {
            IntStream.range(0, list.size() - 1)
                    .forEachOrdered(i -> {
                        if (key == list.get(i)) {
                            matrix.get(key).merge(list.get(i + 1), 1d, Double::sum);
                        }
                    });
            Double sum = matrix.get(key).values().stream().reduce(0d, Double::sum);
            matrix.get(key).replaceAll((s, val) -> val / sum);
        }
        return matrix;


    }
}
