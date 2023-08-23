package Lambda;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App3 {

    public static void main(String[] args) {
        List<Map<String, String>> users = List.of(
                Map.of("name", "Bronn", "gender", "male", "birthday", "1973-03-23"),
                Map.of("name", "Reigar", "gender", "male", "birthday", "1973-11-03"),
                Map.of("name", "Eiegon", "gender", "male", "birthday", "1963-11-03"),
                Map.of("name", "Sansa", "gender", "female", "birthday", "2012-11-03"),
                Map.of("name", "Jon", "gender", "male", "birthday", "1980-11-03"),
                Map.of("name", "Robb", "gender", "male", "birthday", "1980-05-14"),
                Map.of("name", "Tisha", "gender", "female", "birthday", "2012-11-03"),
                Map.of("name", "Rick", "gender", "male", "birthday", "2012-11-03"),
                Map.of("name", "Joffrey", "gender", "male", "birthday", "1999-11-03"),
                Map.of("name", "Edd", "gender", "male", "birthday", "1973-11-03")
        );

        Map<Integer, Long> result = App3.getMenCountByYear(users);
        System.out.println(result); // {1980=2, 1999=1, 1963=1, 1973=3, 2012=1}

    }
    public static Map<Integer, Long> getMenCountByYear(List<Map<String, String>> users) {
        Map<Integer, Long> result = users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .collect(Collectors.groupingBy(user -> LocalDate.parse(user.get("birthday")).getYear(), Collectors.counting()));
        return result;

    }
}
