package com.banking.p1;
public class LowDepositeException extends Exception{
	public LowDepositeException(String s) {
		super(s);
	}

	@Override
	public String toString() {
		return getMessage();
	}
	
	
}
