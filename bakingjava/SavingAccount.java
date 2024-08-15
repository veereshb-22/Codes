package com.banking.p1;

public class SavingAccount extends BankAccount{
protected  double interest_rate;
public double default_rate=0.03;
public SavingAccount(int amount) {
	super(amount);
}
	public double getInterest_rate() {
		return interest_rate;
	}
	
	public void set_Interest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}
	
	public double apply_Interest_rate() {
		return balance-=balance*interest_rate;
	}
	
	public void set_Interest_Rate(double interest_rate) {
		this.interest_rate=interest_rate;
	}

}
