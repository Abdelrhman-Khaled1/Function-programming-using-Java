package lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<String, String> upperCaseName = name -> name.toUpperCase();

        Function<String, String> upperCaseName2 = String::toUpperCase;

        Function<String, String> upperCaseName3 = name -> {
            //logic
            if (name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> upperCaseName4 = (name ,age)-> {
            if (name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };
        System.out.println(upperCaseName4.apply("Abdelrhman",22));

    }
}
