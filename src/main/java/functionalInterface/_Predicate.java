package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid("01234567890"));
        System.out.println(isPhoneNumberValid("0134567890"));
        System.out.println(isPhoneNumberValid("09234567890"));

        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("01234567890"));
        System.out.println(isPhoneNumberValidPredicate.test("0134567890"));
        System.out.println(isPhoneNumberValidPredicate.test("09234567890"));

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("01234567890"));
        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("01244567890"));

        System.out.println(
                "Is phone number valid and contains number 3 or 4 = " +
                        isPhoneNumberValidPredicate.and(containsNumber3.or(containsNumber4)).test("01244567890"));


    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("01") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("01") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");

    static Predicate<String> containsNumber4 = phoneNumber ->
            phoneNumber.contains("4");
}
