package com.banking.p1;

public class BankAccount implements Account {
protected double balance;
protected double amount;
	public BankAccount() {
		
	}
	public BankAccount(int amount) {
		balance=amount;
	}
	
	public BankAccount(double initalBalance) { 
		try{
			if(initalBalance<min_balance) {
					throw new LowDepositeException("Minimum Deposite should be 6000");
				}
			balance+=initalBalance;
		
			} catch (LowDepositeException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	
	
	public double getBalance() {
		return balance;
	}
	
	public void deposite(double amount) {
		balance+=amount;
	}
	
	public void withdraw(double amount) {
	try {
		if(balance<min_balance) {
			throw new LowDepositeException("Minimum Depsoite amount should be 6000");
		}
		
	}catch(LowDepositeException e) {
		e.getMessage();
	}
	 	
	}

	@Override
	public String toString() {
		return "BankAccount Balance=" + balance;
	}
	

}
