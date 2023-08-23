package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App4 {

    public static void main(String[] args) {
        List<String> coll1 = List.of("aabb", "abcd", "bbaa", "dada");
        List<String> result1 = App4.filterAnagram("abba", coll1);
        System.out.println(result1); // ["aabb", "bbaa"]

        List<String> coll2 = List.of("crazer", "carer", "racar", "caers", "racer");
        List<String> result2 = App4.filterAnagram("racer", coll2);
        System.out.println(result2); // ["carer", "racer"]

        List<String> coll3 = List.of("lazing", "lazy", "lacer");
        List<String> result3 = App4.filterAnagram("laser", coll3);
        System.out.println(result3); // []
    }

    public static List<String> filterAnagram(String word, List<String> checkList) {
        String[] wordSplited = word.split("");
        Arrays.sort(wordSplited);
        String wordSorted = String.join("", wordSplited);

        List<String> result = checkList.stream()
                .filter(string -> {
                    string = Arrays.stream(string.split(""))
                                    .sorted()
                                    .collect(Collectors.joining(""));
                    return string.equals(wordSorted);
                })
                .collect(Collectors.toList());
        return result;
    }
}
