package CodeGeneration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

// BEGIN
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Car {
//    @JsonProperty
//    int id;
//    @JsonProperty
//    String brand;
//    @JsonProperty
//    String model;
//    @JsonProperty
//    String color;
//    @JsonProperty
//    User owner;
//    static final ObjectMapper mapper = new ObjectMapper();
//
//    // BEGIN
//    @SneakyThrows
//    public String serialize() {
//        //ObjectMapper mapper = new ObjectMapper();
//        String json = new String();
//        try (Writer writer = new StringWriter()) {
//            mapper.writeValue(writer, this);
//            json = writer.toString();
//        }
//        return json;
//    }
//
//
//    @SneakyThrows
//    public static Car unserialize(String carJson) {
//        //ObjectMapper mapper = new ObjectMapper();
//        Car car = null;
//        try (Reader reader = new StringReader(carJson)) {
//            car = mapper.readValue(reader, Car.class);
//        }
//        return car;
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" +
//                "id=" + id +
//                ", brand='" + brand + '\'' +
//                ", model='" + model + '\'' +
//                ", color='" + color + '\'' +
//                ", owner=" + owner +
//                '}';
//    }
//    // END
//}