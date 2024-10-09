package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class App2 {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String[] numbers = reader.readLine().split(" ");
//        int result = Arrays.stream(numbers).map(Integer::parseInt).sorted().skip(1L).findFirst().get();
//        writer.write(String.valueOf(result));
//
//        reader.close();
//        writer.close();
//        foo();
        Object[] array = new Object[]{new Cat(), new Dog(), new Object()};
        System.out.println(getNames(array));

    }
//    static void foo() {
//
//        String m = "Hello";
//        System.out.print(m);
//        bar(m);
//        System.out.print(m);
//    }
//    static void bar(String m) {
//        m += " World!";
//    }
    static List<? extends Class> getNames(Object[] array) {
        return Arrays.asList(array).stream().map(o -> o.getClass()).toList();
    }

}

class Cat {

}

class Dog {

}
