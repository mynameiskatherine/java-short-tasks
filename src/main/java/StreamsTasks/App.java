package StreamsTasks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        List<Integer> newList = new ArrayList<>();

        Scanner scanFile = new Scanner(System.in);
        String file = scanFile.nextLine();
        Path filePath = Paths.get("src", "main", "resources", file).toAbsolutePath().normalize();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(filePath)))) {
            String s = "";
            List<Integer> list = new ArrayList<>();
            while (reader.ready()) {
                s = reader.readLine();
                list.add(Integer.valueOf(s));
            }
            newList = list.stream()
                    .filter(i -> i % 2 == 0)
                    .sorted()
                    .toList();
        }


        System.out.println(newList);

    }
}
