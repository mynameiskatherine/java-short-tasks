package CheapHotelsTask;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        System.out.println(new Gateway().findAll());
        System.out.println(new Gateway().findAll(Map.of("min", 700, "max", 1000)));
        System.out.println(findTheCheapestService(Map.of("min", 700)));
    }

    public static Map<String, Object> findTheCheapestService(Map<String, Integer> predicates) {
        Optional<Map<String, Object>> result = null;
            List<Map<String, Object>> findAllResult = new Gateway().findAll(predicates);
            result = findAllResult.stream()
                    .min(Comparator.comparing(e -> getCost(e), Double::compareTo));

        return result.isPresent() ? result.get() : Map.of();
    }

    private static Double getCost(Map<String, Object> serviceHotelMap) {
        Map<String, Object> hotelInfo = new ObjectMapper().convertValue(serviceHotelMap.get("hotel"), new TypeReference<Map<String, Object>>() { });
        return (Double) hotelInfo.get("cost");
    }

}
