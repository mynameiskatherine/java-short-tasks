package CheapHotelsTask;

import CheapHotelsTask.strategy.Strategy;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Gateway {
    private List<Map<String, Object>> hotelsByService = getData("data.json");

    private static List<Map<String, Object>> getData(String fileName) {
        Path filePath = Paths.get("src", "main", "resources", fileName).toAbsolutePath().normalize();
        ObjectMapper mapper = new ObjectMapper();
        try {
            var content = Files.readString(filePath).trim();
            return mapper.readValue(content, new TypeReference<List<Map<String, Object>>>() { });
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<Map<String, Object>> findAll(Map<String, Integer> predicates) {
        List<Map<String, Object>> result = new ArrayList<>();
        Double min = predicates.get("min") == null ? Double.MIN_VALUE : Double.valueOf(predicates.get("min"));
        Double max = predicates.get("max") == null ? Double.MAX_VALUE : Double.valueOf(predicates.get("max"));

        for (Map<String, Object> dataBySingleService : hotelsByService) {
            String service = new ObjectMapper().convertValue(dataBySingleService.get("service"), new TypeReference<String>() {
            });
            List<Map<String, Object>> hotels = new ObjectMapper().convertValue(dataBySingleService.get("hotels"), new TypeReference<List<Map<String, Object>>>() {
            });
            hotels.stream()
                        .map(e -> Strategy.strategyMap.get(service).convert(e))
                        .filter(e -> (Double) e.get("cost") >= min && (Double) e.get("cost") <= max)
                        .map(e -> Map.of("service", service, "hotel", e))
                        .forEach(e -> result.add(e));
        }
        return result;
    }

    public List<Map<String, Object>> findAll() {
        return findAll(Map.of());
    }

//      convert Obj to List of Strings
//    public static List<String> convertObjectToListOfStrings(Object obj) {
//        return obj == null ? null : (obj instanceof String ? List.of((String) obj)
//                : (obj.getClass().isArray() ? Arrays.asList((Object[])obj)
//                : (obj instanceof Collection ? ((Collection<?>) obj) : List.of()))
//                .stream().map(String::valueOf).toList());
//    }
}
