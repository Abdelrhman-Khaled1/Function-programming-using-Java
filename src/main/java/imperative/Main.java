package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Ali", MALE),
                new Person("Hassan", MALE),
                new Person("Aisha", FEMALE),
                new Person("Alice", FEMALE),
                new Person("Hagar", FEMALE)
        );


        //imperative approach how many females we have
        int count = 0;
        for (Person person : people) {
            if (person.gender.name().equals("FEMALE")) {
                count++;
            }
        }
        System.out.println(count);

        //Amigoscode
        System.out.println("//imperative approach");
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (FEMALE.equals(person.gender))
                females.add(person);
        }
        for (Person female : females) {
            System.out.println(female);
        }

        //declarative approach
        System.out.println("//declarative approach");
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        //this predicate accept a person , and returns true or false based of that person , whether the person is of type FEMALE
        List<Person> females2 = people.stream()
                                    .filter(personPredicate)
                                    .collect(Collectors.toList());
        females2.forEach(System.out::println);
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
