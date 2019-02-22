package com.skilldistillery.makechange;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double totalPrice, cashTendered;
		CashRegister register;

		System.out.print("Use the GUI? Y/N: ");

		if (sc.next().equalsIgnoreCase("y")) {
			useGui();
		} else {

			String tryAgain;
			do {
				try {
					System.out.print("Enter the purchase price: ");
					totalPrice = sc.nextDouble();

					System.out.print("How much cash do you have? ");
					cashTendered = sc.nextDouble();

					register = new CashRegister(totalPrice, cashTendered);
					System.out.println(register.makeChange());

				} catch (InputMismatchException e) {
					System.out.print("Invalid input.");
				}
				System.out.print("\nTry again? (Y/N)");
				tryAgain = sc.next();
			} while (tryAgain.equalsIgnoreCase("y"));
		}
		sc.close();

	}

	public static void useGui() {
		CashRegisterGUI gui = new CashRegisterGUI();
		gui.init();
	}
}
