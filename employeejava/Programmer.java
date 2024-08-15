package com.emp.pro;

public class Programmer extends SeniorProgrammer{
	static  int bonus=10;
	
	private int  globalCertifaction;
	
	public Programmer() {		
	}
	
	public int getGlobalCertifaction() {
		return globalCertifaction;
	}

	public void setGlobalCertifaction(int globalCertifaction) {
		this.globalCertifaction = globalCertifaction;
	}

	public int getBonus() {
		return bonus;
	}
	
	public void setBonus(int bonus) {
		Programmer.bonus = bonus;
	}
	
		
}
