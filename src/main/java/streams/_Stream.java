package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;


public class _Stream {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Hassan", MALE),
                new Person("Ali", MALE),
                new Person("Aisha", FEMALE),
                new Person("Alice", FEMALE),
                new Person("Hagar", FEMALE)
        );


        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
//              .forEach(gender -> System.out.println(gender));


        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
//        ToIntFunction<String> length = s -> s.length();

//      IntConsumer println = x -> System.out.println(x);
        IntConsumer println = System.out::println; // takes an integer and print out the result

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        ///////////////////////////////

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));
//              .anyMatch(person -> FEMALE.equals(person.gender));

        System.out.println(containsOnlyFemales);

    }


    static class Person {
        private final String name;
        private final Gender gender;
        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender {
        MALE, FEMALE
    }
}
