package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional.ofNullable("abdo@gmail.com")
                .ifPresentOrElse(
                        value -> System.out.println("sending email to " + value),
                        () -> System.out.println("Cannot send email ")
                );

//        Optional.ofNullable("ali@gmail.com")
//                .ifPresent(System.out::println);

    }
}
