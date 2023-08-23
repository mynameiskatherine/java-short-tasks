package Lambda;

import java.util.Arrays;
import java.util.stream.Stream;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.List;


public class App5 {
    public static void main(String[] args) {
//        System.out.println(App5.isValidIPv6("10:d3:2d06:24:400c:5ee0:be:3d")); // true
//        System.out.println(App5.isValidIPv6("0B0:0F09:7f05:e2F3:0D:0:e0:7000")); // true
//        System.out.println(App5.isValidIPv6("000::B36:3C:00F0:7:937")); // true
//        System.out.println(App5.isValidIPv6("::1")); // true
        System.out.println(App5.isValidIPv6("1::1:")); // ?
        System.out.println(App5.isValidIPv6("::"));
        System.out.println(App5.isValidIPv6(":1::1"));

        System.out.println(App5.isValidIPv6("2607:G8B0:4010:801::1004")); // false
        System.out.println(App5.isValidIPv6("1001:208:67:4f00:e3::2c6:0")); // false
        System.out.println(App5.isValidIPv6("2.001::")); // false
        System.out.println(App5.isValidIPv6("9f8:0:69S0:9:9:d9a:672:f90d")); // false

    }

    public static boolean isValidIPv6(String ip) {
        if (ip.equals("::")) return true;
        String[] splitedIp = ip.split(":");
        if (splitedIp[splitedIp.length - 1].equals(":") && (!(splitedIp[splitedIp.length - 2].equals(":")))) return false;
        if (splitedIp.length > 8 || splitedIp.length < 1) return false;
        int empty = (int) Arrays.stream(splitedIp)
                .filter(string -> string.equals(""))
                .count();
        if (empty > 2) return false;
        if (empty > 1 && ((!(ip.substring(0, 2).equals("::")) && (!(ip.substring(ip.length() - 2, ip.length()).equals("::")))))) return false;
        if (splitedIp.length == 8 && empty > 0) return false;
        if (splitedIp.length < 8 && empty == 0) return false;
        if (splitedIp.length == 1 && empty == 1) return true;
        for (int i = 0; i < splitedIp.length; i++) {
            if (splitedIp[i].equals("")) continue;
            if (!App5.isHex(splitedIp[i])) return false;
        }
        return true;
    }

    public static boolean isHex(String number) {
        return NumberUtils.isCreatable("0x" + number);
    }
//variant 2
//    private static boolean isValidGroup(String group) {
//        var hexadecimal = "0x" + group;
//        return NumberUtils.isCreatable(hexadecimal)
//                && group.length() <= 4;
//    }
//
//    public static boolean isValidIPv6(String ip) {
//        if (ip.indexOf("::") != ip.lastIndexOf("::")) {
//            return false;
//        }
//
//        var isShort = ip.contains("::");
//
//        List<String> groups = Stream.of(ip.split("::"))
//                .filter(group -> group != "")
//                .flatMap(group -> Stream.of(group.split(":", -1)))
//                .toList();
//
//        var length = isShort ? groups.size() + 2 : groups.size();
//
//        if ((!isShort && length < 8) || length > 8) {
//            return false;
//        }
//
//        return groups.stream().allMatch(App::isValidGroup);
//    }
}
