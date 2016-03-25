package ch.frankel.training.testing;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    public String compute(int end) { // # tag::compute[]
        try (IntStream stream = IntStream.range(1, end)) {
            return stream.mapToObj(i -> {
                if (i % 3 == 0 && i % 5 == 0) {
                    return "FizzBuzz";
                } else if (i % 3 == 0) {
                    return "Fizz";
                } else if (i % 5 == 0) {
                    return "Buzz";
                } else {
                    return String.valueOf(i);
                }
            }).collect(Collectors.joining());
        }
    } // # end::compute[]
}
