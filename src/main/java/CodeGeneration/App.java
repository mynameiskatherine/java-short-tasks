package CodeGeneration;

import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, world");
    }

    @SneakyThrows
    public static void save(Path filePath, Car car) {
        String json = car.serialize();
        try (OutputStream output = Files.newOutputStream(filePath)) {
            output.write(json.getBytes());
        }
    }

    @SneakyThrows
    public static Car extract(Path filePath) {
        String json = new String();
        try (InputStream input = Files.newInputStream(filePath)) {
            byte[] buffer = input.readAllBytes();
            json = new String(buffer);
        }
        return Car.unserialize(json);
    }
}