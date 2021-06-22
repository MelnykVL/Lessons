package edu.lessons.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LStream {
    public static void main(String[] args) {

        Supplier<Integer> randomizer = () -> new Random().nextInt(100);

        Integer[] arr = Stream.generate(randomizer).limit(20).toArray(Integer[]::new);

        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));

    }
}
