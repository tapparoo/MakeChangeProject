package com.skilldistillery.makechange;

public class CashRegister {
    private double purchasePrice;
    private double cashTendered;
    
    CashRegister(double price, double cash){
	this.purchasePrice = price;
	this.cashTendered = cash;
    }
    
    public String makeChange() {
	if (this.cashTendered < this.purchasePrice) {
	    return "Insufficient funds.";
	}
	else if(this.purchasePrice <= 0) {
	    return "Invalid purchase price.";
	}
	else {
	    
	    return "";
	}
    }
    
    public static String calcBills() {
	
	return "";
    }
    
    public static String calcCoins() {
	
	return "";
    }
}
