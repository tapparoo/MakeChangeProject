package com.skilldistillery.makechange;

public class CashRegister {
    private double purchasePrice;
    private double cashTendered;
    private byte twenty, ten, five, one, quarter, dime, nickel, penny;
    private double changeDue;

    CashRegister(double price, double cash) {
	this.purchasePrice = price;
	this.cashTendered = cash;
	// Rounding/casting because I was getting some pretty random decimals
	this.changeDue = (double)Math.round((this.cashTendered - this.purchasePrice) * 100)/100;
    }

    public String makeChange() {
	if (this.changeDue < 0) {
	    return "Insufficient funds.";
	} else if (this.purchasePrice <= 0) {
	    return "Invalid purchase price.";
	} 
	if (this.changeDue >= 1.0) {
	    calcBills();
	}
	if (this.changeDue >= .01) {
	    calcCoins();
	}

	return printChangeSummary();
    }

    private void calcBills() {
	// Casting to ignore coins
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
	}
    }

    private void calcCoins() {
	// Casting to ignore dollar bills.  Multiply by 100 to work with integers for simplicity
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
	}
    }

    public String printChangeSummary() {
	String change = "";
	
	change += "\nChange due to customer: $" + this.changeDue;
	
	if (this.twenty > 0) {
	    change += "\n\tTwenties: " + this.twenty;
	}
	if (this.ten > 0) {
	    change += "\n\tTens: " + this.ten;
	}
	if (this.five > 0) {
	    change += "\n\tFives: " + this.five;
	}
	if (this.one > 0) {
	    change += "\n\tOnes: " + this.one;
	}
	if (this.quarter > 0) {
	    change += "\n\tQuarters: " + this.quarter;
	}
	if (this.dime > 0) {
	    change += "\n\tDimes: " + this.dime;
	}
	if (this.nickel > 0) {
	    change += "\n\tNickels: " + this.nickel;
	}
	if (this.penny > 0) {
	    change += "\n\tPennies: " + this.penny;
	}
	
	return change;
    }
}
