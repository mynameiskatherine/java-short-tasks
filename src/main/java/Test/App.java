package Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class App {

    public static void main(String[] args) {
        short sh = 12;
        long by = 7;
        var sum = sh + by;
        System.out.println(sh + " " + by + " " + sum);
//        Object array1 = new String[]{"1", "2"};
//        Object array2 = new Integer[][]{{1, 2},{7, 8, 9}};
//        Object array3 = new String[]{"1", "2"};
//        Object array4 = new int[][]{{1, 2},{7, 8, 9}};
//        Object map1 = Map.of("id", "1", "array", "[1,2]");
//        Object map2 = Map.of("id", "1", "array", "[1,2]");
//        Object list1 = List.of(4,5,6);
//        Object list2 = List.of(4,5,6);
//        List<Object> list3 = Arrays.asList(array1);
//        List<Object> list4 = Arrays.asList(array3);
//        Object object1 = null;
//        Object object2 = 3;
//        //Object object3 = new Integer(3);
//        List<Object> list = List.of(array1, array2, map1, list1);
//        for (Object e : list) {
//            ObjectMapper mapper = new ObjectMapper();
//            if (e instanceof Object[]) {
//                Object[] array = (Object[]) e;
//                System.out.println(Arrays.toString(array));
//            } else {
//                System.out.println(e);
//            }
//        }
//        System.out.println(Objects.deepEquals(array2, array4));
//        System.out.println(Objects.deepEquals(map1, map2));
//        System.out.println(Objects.deepEquals(list1, list2));
////        if (array2 instanceof Object[][] && array4 instanceof Object[][]) {
////            String str2 = Arrays.deepToString((Object[][]) array2);
////            String str4 = Arrays.deepToString((Object[][]) array4);
////            System.out.println(Objects.equals(str2, str4));
////        }
//        System.out.println(Objects.deepEquals(object2, object3));
//        //System.out.println(Arrays.deepEquals(array1, array3));
//
//        HashMap<String, Object> file1 = Map.of("id", null, "array", "[1,2]");
//        HashMap<String, Object> file2 = Map.of("id", 1, "array", "[1,2]");
//        System.out.println(Objects.equals(file1.get("id"), file2.get("id")));
//        Set<String> keys1 = file1.keySet();
//                keys1.stream()
//                        .sorted()
//                        .flatMap( e -> {
//                    if (file2.containsKey(e)) {
//                        if (Objects.deepEquals(file1.get(e), file2.get(e))) {
//                            return Map.of(Map.of(e, file1.get(e)), "unchanged");
//                        } else {
//                            return Map.of(Map.of(e, file1.get(e)), "removed", Map.of(e, file2.get(e)), "added");
//                        }
//                    } else {
//                        return Map.of(Map.of(e, file1.get(e)), "removed");
//                    }
//                })
//                        .forEach(result::putAll);
    }

    //    private static boolean compareValues(Object object1, Object object2) {
//        if (object1 == null && object2 == null) {
//            return true;
//        } else if (object1 == null || object2 == null) {
//            return false;
//        } else if (!object1.getClass().equals(object2.getClass())) {
//           return false;
//        } else if (object1.getClass().isArray()) {
//
//        }
//    }
//
//    private static List<?> processArray(Object[] object, Integer dimentions) {
//        int length = Array.getLength(object);
//        for (int i = 0; i < length; i++) {
//            Object arrayElement = Array.get(object, i);
//        if (object != null && object.getClass().isArray()) {
//
//            int length = Array.getLength(object);
//            for (int i = 0; i < length; i++) {
//                Object arrayElement = Array.get(object, i);
//                processArray(arrayElement, action);
//            }
//        } else {
//            action.accept(object);
//        }
//    }
}
//public class App {
//    public static void main(String[] args) {
//        String filePath1 = "src/test/resources/file1.json"; //src/test/resources/fileEmpty1.json
//        String filePath2 = "src/test/resources/file2.json"; //src/test/resources/fileEmpty2.json
//        String format1 = "stylish";
//        String format2 = "plain";
//        try {
//            System.out.println(Differ.generate(filePath1, filePath2, format1));
//            System.out.println(Differ.generate(filePath1, filePath2, format2));
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//    }
//}
//public class App {
//    public static void main(String[] args) {
//        String filePath1 = "src/test/resources/file1.json"; //src/test/resources/fileEmpty1.json
//        String filePath2 = "src/test/resources/file2.json"; //src/test/resources/fileEmpty2.json
//        String format = "json";
//        try {
//            var str1 = Differ.generate(filePath1, filePath2, format);
//            var str2 = new String(Files.readAllBytes(Paths.get("src/test/resources/jsonFormatTest.txt").toAbsolutePath().normalize()));
//            System.out.println(str1.trim().equals(str2.trim()));
//            System.out.println(str1);
//            System.out.println(str2);
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//    }
//}

//    public static Map<Map<String, Object>, String> generate(String filePath1, String filePath2) {
//        Map<String, Object> file1 = Parser.parse(filePath1);
//        Map<String, Object> file2 = Parser.parse(filePath2);
//
//        Map<Map<String, Object>, String> result = new LinkedHashMap<>();
//        Set<String> mergedKeys = new HashSet<>(file1.keySet());
//        mergedKeys.addAll(file2.keySet());
//
//        mergedKeys.stream()
//                .sorted()
//                .map(e -> {
//                    Map<Map<String, Object>, String> diffMap = new LinkedHashMap<>();
//                    Map<String, Object> nestedMap = new LinkedHashMap<>();
//                    if (file1.containsKey(e) && file2.containsKey(e)) {
//                        if (Objects.deepEquals(file1.get(e), file2.get(e))) {
//                            nestedMap.put(e, file1.get(e));
//                            diffMap.put(new LinkedHashMap<>(nestedMap), "unchanged");
//                        } else {
//                            nestedMap.put(e, file1.get(e));
//                            diffMap.put(new LinkedHashMap<>(nestedMap), "updated removed");
//                            nestedMap.put(e, file2.get(e));
//                            diffMap.put(new LinkedHashMap<>(nestedMap), "updated added");
//                        }
//                    } else if (file1.containsKey(e) && !(file2.containsKey(e))) {
//                        nestedMap.put(e, file1.get(e));
//                        diffMap.put(new LinkedHashMap<>(nestedMap), "removed");
//                    } else {
//                        nestedMap.put(e, file2.get(e));
//                        diffMap.put(new LinkedHashMap<>(nestedMap), "added");
//                    }
//                    return diffMap;
//                })
//                .forEach(e -> result.putAll(e));
//        return result;
//    }
