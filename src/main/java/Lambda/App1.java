package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


//nrzi decryptor
public class App1 {

    public static void main(String[] args) {
        var signal1 = "_|¯|____|¯|__|¯¯¯";
        System.out.println(App1.nrzi(signal1)); // "011000110100"

        var signal2 = "|¯|___|¯¯¯¯¯|___|¯|_|¯";
        System.out.println(App1.nrzi(signal2)); // "110010000100111"

        var signal3 = "¯|___|¯¯¯¯¯|___|¯|_|¯";
        System.out.println(App1.nrzi(signal3)); // "010010000100111"

        var signal4 = "";
        System.out.println(App1.nrzi(signal4)); // ""

        var signal5 = "|";
        System.out.println(App1.nrzi(signal5)); // ""
    }
    public static String nrzi(String signal) {
// variant 2
//        public static String nrzi(String signal) {
//            return IntStream.range(0, signal.length())
//                    .mapToObj(index -> {
//                        if (signal.charAt(index) == '|') {
//                            return "";
//                        }
//                        return (index != 0 && signal.charAt(index - 1) == '|') ? "1" : "0";
//                    })
//                    .collect(Collectors.joining(""));
//        }

        String[] splitedSignal = signal.split("");
        //List<Integer> result = new ArrayList<>();
        String result = IntStream.range(0, splitedSignal.length).boxed()
                .map(i -> {
                    if (i == 0) {
                        if (splitedSignal[i].equals("_") || splitedSignal[i].equals("¯")) return "0";
                    } else {
                        if (splitedSignal[i].equals("_") || splitedSignal[i].equals("¯")) {
                          if (splitedSignal[i - 1].equals("|")) return "1";
                          else return "0";
                        }
                    }
                    return "";
                })
                .filter(i -> i.equals(0) || i.equals(1))
                .collect(Collectors.joining());


        return result;
    }
}
