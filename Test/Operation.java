package com.test;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Operation {
	Scanner sc=new Scanner(System.in);
	Person  p;
	List<Person> pr=new ArrayList<>();	
	void add() {

		System.out.println("Number of Passenger");
		int num=sc.nextInt();
		for(int i=0;i<num;i++) {
			p=new Person();
			System.out.println("Enter Passenger ID");
			p.setId(sc.next());
			System.out.println("Enter FirstName");
			p.setFname(sc.next());
			System.out.println(" Enter LastName");
			p.setLname(sc.next());
			System.out.println("Enter Age");
			int age=sc.nextInt();
			if(age<0) {
				try {
					throw new IllegalAgeException("Wrong Age");
				} catch (IllegalAgeException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
			System.out.println("Enter the Date of Birth in YYYY-MM-DD");
			p.setDob(sc.next());
			System.out.println("Enter the Date of Validity of Passport YYYY-MM-DD");
			p.setValid_date(sc.next());
			p.setExpiredDate(validityRemaining(p.getValid_date()));
			pr.add(p);
		
		}			
	}
	int validityRemaining(String data) {
		int year;
		LocalDate dateofvalidity =LocalDate.parse(data);
		LocalDate current=LocalDate.now();
		year=Period.between(dateofvalidity,current).getYears();
		return year;
	}

	void expiredpass() {
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("Person Expired");
		pr.stream().filter(e->e.getExpiredDate()==0).map(Person::getFname).forEach(System.out::print);
		System.out.println();
		
	}
	void ageGreater() {
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("Age ");
		pr.stream().filter(e->e.getAge()>17).map(Person::getFname).forEach(System.out::print);
		System.out.println();
		
	}
	void greaterThree() {
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("EXPIRY GREATER THAN 3 YEARS");
		pr.stream().filter(e->e.getExpiredDate()>3).map(Person::getFname).forEach(System.out::print);
		System.out.println();
		
	}
	void startWithKA() {
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("NAME of ID START WITH");
		pr.stream().filter(e->e.getId().startsWith("KA")).map(Person::getFname).forEach(System.out::print);
		System.out.println();
		
	}
	void passout() {
		System.out.println("-----------------------------");
		System.out.println();
		pr.stream().filter(e->e.getExpiredDate()<0).map(Person::getFname).forEach(System.out::print);
		}
	
	
	public 	void operation() {	
			while(true) {
				System.out.println(" Press 's' to store data \n Press 'q' to execute all query");
				String x=sc.next();
					switch(x) {
						case "s" :add();
									break;		
						case "q"  :expiredpass();
									ageGreater();
									greaterThree();
									startWithKA();
									passout();
									break;
							
						default:System.out.println("Default : Wrong Option Press y to exit n to operate ");
						String choice=sc.next();
						if(choice=="y") {
							System.exit(0);
						}
					}
				}
	}
	
	
}
