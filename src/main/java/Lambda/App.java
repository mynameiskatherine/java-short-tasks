package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.function.Supplier;


//build horizontal histogram for rolling dice
//Streams, Lambdas
class App {
    public static void main(String[] args) {
        App.play(10, (() -> new Random().nextInt(1, 7)));
    }
    public static void play(int rollNumber, Supplier<Integer> rollDieFunction) {
        Map<Integer, Integer> gameResults = new TreeMap<>() {{
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(6, 0);
        }};

        Stream.generate(rollDieFunction)
                .limit((long)rollNumber)
                .forEach(i -> gameResults.replace(i, gameResults.get(i) + 1));

        List<String> resultGistogramList = new ArrayList<>();

        for (Integer side: gameResults.keySet()) {
            if (gameResults.get(side) > 0) {
                String column = Stream.generate(() -> "#").limit(gameResults.get(side)).collect(Collectors.joining());
                resultGistogramList.add(side + "|" + column + " " + gameResults.get(side));
            } else {
                resultGistogramList.add(side + "|");
            }
        }
        System.out.println(String.join("\n", resultGistogramList));
    }


    //var II
//    public static void play(int roundsCount, Supplier rollDice) {
//        var barItem = "#";
//        List<Integer> numbers = Stream
//                .generate(rollDice)
//                .limit(roundsCount)
//                .toList();
//        var histogram = IntStream.rangeClosed(1, 6).boxed().map(side -> {
//            var count = (int) numbers.stream().filter(number -> number == side).count();
//            var displayCount = count != 0 ? " " + count : "";
//            var bar = barItem.repeat(count);
//            return String.format("%s|%s%s", side, bar, displayCount);
//        }).collect(Collectors.joining("\n"));
//        System.out.println(histogram);
//    }

}


