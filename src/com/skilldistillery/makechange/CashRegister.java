package com.skilldistillery.makechange;

public class CashRegister {
    private double purchasePrice;
    private double cashTendered;
    private byte twenty, ten, five, one, quarter, dime, nickel, penny;
    private double changeDue;

    CashRegister(double price, double cash) {
	this.purchasePrice = price;
	this.cashTendered = cash;
	this.changeDue = this.cashTendered - this.purchasePrice;
    }

    public String makeChange() {
	if (this.changeDue < 0) {
	    System.out.println("Insufficient funds.");
	    return "";
	} else if (this.purchasePrice <= 0) {
	    System.out.println("Invalid purchase price.");
	    return "";
	} 
	if (this.changeDue >= 1.0) {
	    calcBills();
	}
	if (this.changeDue >= .01) {
	    calcCoins();
	}

	return getChangeSummary();
    }

    private void calcBills() {
	int changeDueRemaining = (int) this.changeDue;
	int temp;
	
	if (changeDueRemaining >= 20) {
	    temp = (byte) (changeDueRemaining / 20);
	    this.twenty += temp;
	    changeDueRemaining -= temp * 20;
	}
	if (changeDueRemaining >= 10) {
	    temp = (byte) (changeDueRemaining / 10);
	    this.ten += temp;
	    changeDueRemaining -= temp * 10;
	}
	if (changeDueRemaining >= 5) {
	    temp = (byte) (changeDueRemaining / 5);
	    this.five += temp;
	    changeDueRemaining -= temp * 5;
	}
	if (changeDueRemaining >= 1) {
	    temp = (byte) (changeDueRemaining / 1);
	    this.one += temp;
	    changeDueRemaining -= temp;
	}
    }

    private void calcCoins() {
	int changeDueRemaining = (int)((this.changeDue - (int)this.changeDue) * 100);
	double temp;

	if (changeDueRemaining >= 25) {
	    temp = changeDueRemaining / 25;
	    this.quarter += temp;
	    changeDueRemaining -= temp * 25;
	}
	if (changeDueRemaining >= 10) {
	    temp = changeDueRemaining / 10;
	    this.dime += temp;
	    changeDueRemaining -= temp * 10;
	}
	if (changeDueRemaining >= 5) {
	    temp = changeDueRemaining / 5;
	    this.nickel += temp;
	    changeDueRemaining -= temp * 5;
	}
	if (changeDueRemaining >= 1) {
	    temp = changeDueRemaining / 1;
	    this.penny += temp;
	    changeDueRemaining -= temp;
	}
    }

    public String getChangeSummary() {
	String change = "";
	
	change += "\nChange due to customer: $" + this.changeDue;
	change += "\n\tTwenties: " + this.twenty + "\n\tTens: " + this.ten + "\n\tFives: " + this.five + "\n\tOnes: "
		+ this.one;
	change += "\n\tQuarters: " + this.quarter + "\n\tDimes: " + this.dime + "\n\tNickels: " + this.nickel
		+ "\n\tPennies: " + this.penny;

	return change;
    }
}
