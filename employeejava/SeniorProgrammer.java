package com.emp.pro;

public class SeniorProgrammer extends Employee {
	private int stock;
	private int teamSize;
	static  int increaseBonus=20;
	private double seniorBonus;
	public SeniorProgrammer() {
		
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getTeamSize() {
		return teamSize;
	}
	
	public static int getIncreaseBonus() {
		return increaseBonus;
	}
	public static void setIncreaseBonus(int increaseBonus) {
		SeniorProgrammer.increaseBonus = increaseBonus;
	}
	public double getSeniorBonus() {
		return seniorBonus;
	}
	public void setSeniorBonus(double seniorBonus) {
		this.seniorBonus = seniorBonus;
	}
	
	
	
}
