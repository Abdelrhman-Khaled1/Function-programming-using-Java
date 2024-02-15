package functionalInterface;

import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        Customer abdo = new Customer("Abdo", "0123456");
        //Normal java function
        greetCustomer(abdo);

        //Consumer Functional interface
        greetCustomerConsumer.accept(abdo);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number " + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " + customer.customerPhoneNumber);
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;
        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
