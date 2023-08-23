package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

public class App2 {

    public static String rgbToHex(int r, int g, int b) {
        var hex = Stream.of(r, g, b)
                .map(channel -> Integer.toString(channel, 16))
                .map(channel -> StringUtils.leftPad(channel, 2, "0"))
                .collect(Collectors.joining(""));

        return String.format("#%s", hex);

    }
// variant 2
//    public static Map<String, Integer> hexToRgb(String hex) {
//        String[] chunked = Util.chunk(hex.substring(1), 2);
//        List<Integer> channels = Stream.of(chunked)
//                .map(channel -> Integer.parseInt(channel, 16))
//                .toList();
//
//        return Map.of(
//                "r", channels.get(0),
//                "g", channels.get(1),
//                "b", channels.get(2)
//        );
//    }
}
