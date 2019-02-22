package com.skilldistillery.makechange;

public class CashRegister {
	private double purchasePrice;
	private double cashTendered;
	private int twenty, ten, five, one, quarter, dime, nickel, penny;
	private double changeDue;

	CashRegister(double price, double cash) {
		this.purchasePrice = price;
		this.cashTendered = cash;
		// Rounding/casting because I was getting some pretty random decimals
		this.changeDue = (double) Math.round((this.cashTendered - this.purchasePrice) * 100) / 100;
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

		if (changeDueRemaining >= 20) {
			this.twenty += changeDueRemaining / 20;
			changeDueRemaining = changeDueRemaining % 20;
		}
		if (changeDueRemaining >= 10) {
			this.ten += changeDueRemaining / 10;
			changeDueRemaining = changeDueRemaining % 10;
		}
		if (changeDueRemaining >= 5) {
			this.five += changeDueRemaining / 5;
			changeDueRemaining = changeDueRemaining % 5;
		}
		if (changeDueRemaining >= 1) {
			this.one += changeDueRemaining;
		}
	}

	private void calcCoins() {
		// Casting to ignore dollar bills. Multiply by 100 to work with integers for
		// simplicity
		int changeDueRemaining = (int) Math.round((this.changeDue - (int) this.changeDue) * 100);

		if (changeDueRemaining >= 25) {
			this.quarter += changeDueRemaining / 25;
			changeDueRemaining = changeDueRemaining % 25;
		}
		if (changeDueRemaining >= 10) {
			this.dime += changeDueRemaining / 10;
			changeDueRemaining = changeDueRemaining % 10;
		}
		if (changeDueRemaining >= 5) {
			this.nickel += changeDueRemaining / 5;
			changeDueRemaining = changeDueRemaining % 5;
		}
		if (changeDueRemaining >= 1) {
			this.penny += changeDueRemaining / 1;
		}
	}

	public String printChangeSummary() {
		String change = "";

		change += "\nChange due to customer: $" + this.changeDue;

		if (this.twenty > 0) {
			change += String.format("\n%15s => %3d", "Twenties:", this.twenty);
		}
		if (this.ten > 0) {
			change += String.format("\n%15s => %3d", "Tens:", this.ten);
		}
		if (this.five > 0) {
			change += String.format("\n%15s => %3d", "Fives:", this.five);
		}
		if (this.one > 0) {
			change += String.format("\n%15s => %3d", "Ones:", this.one);
		}
		if (this.quarter > 0) {
			change += String.format("\n%15s => %3d", "Quarters:", this.quarter);
		}
		if (this.dime > 0) {
			change += String.format("\n%15s => %3d", "Dimes:", this.dime);
		}
		if (this.nickel > 0) {
			change += String.format("\n%15s => %3d", "Nickels:", this.nickel);
		}
		if (this.penny > 0) {
			change += String.format("\n%15s => %3d", "Pennies:", this.penny);
		}

		return change;
	}
}
