package com.devflores;

import java.util.Scanner;

public class MainBankingApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		CustomerService customerService = new CustomerService();
		Customer customer = null;
		try {
			customerService.displayOptionMenu();
			while (true) {
				Integer userSelectionInput = customerService.fetchUserInput(scanner);
				if (userSelectionInput.equals(0)) {
					break;
				} else if (userSelectionInput.equals(1)) {
					System.out.println("\nYour card has been created");
					Long accNum = customerService.generateAccountNumber();
					Integer pinNum = customerService.generatePin();
					customer = new Customer(pinNum, accNum);
					customerService.displayOptionMenu();
				} else if (userSelectionInput.equals(2)) {
					// Log into account;
					Long customerAccNumInput = customerService.fetchUserCardNumInput(scanner);
					Integer customerPinInput = customerService.fetchUserPinInput(scanner);
					// if user successfully logs in then the program will enter while loop
					// if not, program will return to menu
					if (customerService.validateUserLogin(customerAccNumInput, customerPinInput, customer)) {
						System.out.println("\nYou have successfully logged in!\n");
						customerService.displayCustomerMenu();
						while (true) {
							Integer customerMenuInput = customerService.fetchUserInput(scanner);
							if (customerMenuInput.equals(1)) {
								System.out.println("\nBalance: 0\n");
								customerService.displayCustomerMenu();
							} else if (customerMenuInput.equals(2)) {
								System.out.println("\nYou have successfully logged out!\n");
								customerService.displayOptionMenu();
								break;
							} else {
								System.out.println("\nBye!");
								System.exit(0);
							}
						}
					} else {
						System.out.println("Wrong card number or PIN");
						customerService.displayOptionMenu();
					}
				} else {
					System.out.println("Please enter a valid menu option.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
