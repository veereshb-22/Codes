package com.c1.hibernateexampleusingannotation.entity;

import java.util.Scanner;

public class HibernateOperation {
	Scanner sc=new Scanner(System.in);
	HibernateMethods hm=new HibernateMethods();
	String name;
	String email;
	int id;
	String  choice;
	
	public void Operation() {
		while(true) {
				System.out.println("Enter 'display' :For Dispaly All Data");
				System.out.println("Enter 'insert' :To Insert Data ");
				System.out.println("Enter 'delete': To delete All Data");
				System.out.println("Enter 'deleteID' : Delete Data by ID");
				choice=sc.next();
				
				switch(choice) {
				
				case "display": hm.display();
								break;
								
				case "insert":System.out.println("Enter the name and email ");
								name=sc.next();
								email=sc.next();
								hm.addData(name, email);
								break;
								
				case "update": System.out.println("Enter Studen_id and email_id");
								id=sc.nextInt();
								email=sc.next();
								hm.updateQuery(email, id);
								break;
								
				case "delete": hm.deleteAll();
								break;
								
				case "deleteID":System.out.println("Enter student_id to delete");
								id=sc.nextInt();
								hm.deletebyID(id);
								break;
								
				default :System.out.println("Wrong Choice Enter ' y /n' y to continue n to stop operation");
							choice="n";
							if(choice =="n") {
								System.exit(0);
							}
			}
		}		
		
	}
	
}
