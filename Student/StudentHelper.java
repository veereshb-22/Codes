package com.students;

import java.util.Scanner;

public class StudentHelper {
	StudentOperation so=new StudentOperation();
	Scanner sc=new Scanner(System.in);
	public void displayOperation() {
		while(true) {
		System.out.println("Enter Choice");
		System.out.println("store: Store Details");
		System.out.println("results: Display student Result");
		System.out.println("details: Display Student Details");
		String choice=sc.next();
			
			switch(choice) {
			case "store": so.storeStudentDetails();
						break;
			case "results": so.showStudentResult();
						break;
			case "details":so.showStudentDetails();
						break;
			default:System.out.println("If you want to continue or not press y/n");	
					choice=sc.next();
					if(choice=="n") {
						System.exit(0);
					}
					break;
				}
		}
	}
	
}
