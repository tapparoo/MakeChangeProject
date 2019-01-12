package com.skilldistillery.makechange;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MakeChangeApp {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	double totalPrice = 0;
	double cashTendered = 0;
	CashRegister register;

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

	sc.close();
    }
}
