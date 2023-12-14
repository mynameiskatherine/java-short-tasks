package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App8 {

    public static void main(String[] args) {
        System.out.println(App8.ipToDec("128.32.10.1")); // 2149583361
        System.out.println(App8.ipToDec("0.0.0.0")); // 0
        System.out.println(App8.ipToDec("255.255.255.255")); // 4294967295

        System.out.println(App8.decToIp(2149583361L)); // "128.32.10.1"
        System.out.println(App8.decToIp(0L)); // "0.0.0.0"
        System.out.println(App8.decToIp(4294967295L)); // "255.255.255.255"

    }
    public static Long ipToDec(String ip) {
        String[] arrayIp = ip.split("\\.");

        return IntStream.range(0, arrayIp.length)
                .mapToObj(i -> Long.valueOf(arrayIp[i]) * Math.pow(256, (arrayIp.length - i - 1)))
                .mapToLong(e -> (Long) Math.round(e)).sum();
    }
    public static String decToIp(Long longIp) {
        Long[] ip = new Long[4];
        Long tempIp = longIp;
        for (int i = 3; i > 0; i--) {
            ip[i] = tempIp % 256;
            tempIp /= 256;
        }
        ip[0] = tempIp;

        return Arrays.stream(ip)
                .map(j -> String.valueOf(j))
                .collect(Collectors.joining("."));
    }
}
