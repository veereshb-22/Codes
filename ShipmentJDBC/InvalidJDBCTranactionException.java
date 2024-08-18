package com.shipment.exception;

public class InvalidJDBCTranactionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidJDBCTranactionException(String e) {
		super(e);
	}
}
