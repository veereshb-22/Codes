package com.banking.p1;

public class CheckingAccount extends BankAccount {
	protected double monthly_fee;
	public static double default_fee=5.00d;
	public CheckingAccount(int amount) { 
		super(amount);
	monthly_fee=default_fee;	
	}
	public CheckingAccount(double new_monthly_fee ) {
		monthly_fee=new_monthly_fee;	
	}
	
	public double  applymonthlyfee() {
		return balance-=monthly_fee;
	}
	
	public double getMonthly_fee() {
		return monthly_fee;
	}
	
	public void setMonthly_fee(double monthly_fee) {
		System.out.println("SET NEW MONTHLY FEE");
		this.monthly_fee = monthly_fee;
	}
	@Override
	public String toString() {
		return "Account Balance "+balance+" Monthly Maintenance fees="+monthly_fee;
	}
	
	
}
