package com.devflores;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CustomerService {
	public void displayOptionMenu() {
        System.out.println("1. Create an account\n" + "2. Log into account\n"
                + "0. Exit");
    }
    public void displayCustomerMenu () {
        System.out.println("1. Balance\n" + "2. Log out\n" + "0. Exit\n");
    }

    public Integer fetchUserInput(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    public Long generateAccountNumber() {
        Long bankIdentificationNum = 4_000_000_000_000_000L;
        Long accNum = bankIdentificationNum + (long) (Math.random() * 1000000000L);
        System.out.println("Your card number has been created: \n" + accNum);
        return accNum;
    }
    public Integer generatePin() {
        Integer draftPin = ThreadLocalRandom.current().nextInt(9999);
        Integer pin = Integer.parseInt(String.format("%04d", draftPin));
        System.out.println("Your card PIN: \n" + pin + "\n");
        return pin;
    }
    public Boolean validateUserLogin(Long customerAccNumInput, Integer customerPinInput, Customer customer) {
        return customerAccNumInput.equals(customer.getAccountNumber()) && customerPinInput.equals(customer.getPin());
    }
    public Long fetchUserCardNumInput(Scanner scanner) {
        System.out.println("\nEnter your card number: ");
        return Long.parseLong(scanner.nextLine());
    }
    public Integer fetchUserPinInput(Scanner scanner) {
        System.out.println("Enter your PIN: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
