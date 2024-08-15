package com.emp.pro;
import java.util.Scanner;

public class Operation  {
	
	Scanner sc=new Scanner(System.in);
	Programmer p=new Programmer();
	public void addData() {
		System.out.println("Enter Employee name");
		p.setEmployeename(sc.next());
		System.out.println("Enter Employee ID");
		p.setEmployeeID(sc.next());
		System.out.println("Enter Empoyee Address");
		sc.nextLine();
		p.setEmployeeAddress(sc.nextLine());
		System.out.println("Enter Employee Age");
		p.setAge(sc.nextInt());
		System.out.println("Enter Employee Designation");
		sc.nextLine();
		p.setEmployeeDesignation(sc.next());
		System.out.println("Enter Employee Project_id");
		p.setProject_id(sc.next());
		System.out.println("Enter Employee Manager Name");
		sc.nextLine();
		p.setManager(sc.nextLine());
		System.out.println("Enter Employee Experience");
		p.setExperience(sc.nextInt());
		
		if(p.getExperience()>2) {
			System.out.println("Enter Number of stock");
			p.setStock(sc.nextInt());
				
		}	
		else { 
			System.out.println("Enter Number of Certification");
			p.setGlobalCertifaction(sc.nextInt());	
		}
	}
	
	public void display() {
	System.out.println("Employee name"+p.getEmployeename());
	System.out.println("Employee ID"+p.getEmployeeID());
	System.out.println("Employee Age"+p.getAge());
	System.out.println("Employee Experience");
	System.out.println("Employee Salary"+p.getSalary());
	System.out.println("Employee Address"+p.getEmployeeAddress());
	System.out.println("Employee Designation"+p.getEmployeeDesignation());
	System.out.println("Employee Project ID"+p.getProject_id());
	System.out.println("Employee Project ID"+p.getManager());
	System.out.println("Employee Bonus"+p.getBonus());
	if(p.getExperience()>2) {
		System.out.println(" Employee Bonus is"+p.applyBonus(SeniorProgrammer.increaseBonus));
		System.out.println(" Employee Stock"+p.getStock());
	}
	else {
		System.out.println(" Employee Bonus is"+p.applyBonus(Programmer.bonus));
		System.out.println(" Employee Certification");
		}
	}
	
	void process() {
		 
		 
		 int i=1;
		 while(i>0) {
			 System.out.println("Enter 1 to add data || 2 to display data || 2 to exit");
			 int operation=sc.nextInt();
			 switch(operation) {
			 case 1: addData();break;
			 case 2:display(); break;
			 case 3:i=-1;
			 default :System.out.println(" Wrong");
			 }
		 }
	}
	
}
