package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {


        Customer customer = new Customer(
                "Abdelrhman",
                "kabdo17013@gamil.com",
                "0123456789",
                LocalDate.of(2002, 4, 2)
        );

//        System.out.println(new CustomerValidatorService().isValid(customer));
        // if valid we can store in db

        //lazy
        CustomerRegistrationValidator validator = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult());

        ValidationResult result = validator.apply(customer);

        System.out.println(result);

        if(result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
