package com.banking.p1;
import java.util.ArrayList;
import java.util.Scanner;
public class BankingOperation {
	Scanner sc=new Scanner(System.in);
	public ArrayList<Users> users;
	public static int amount;
	public BankingOperation() {
		users=new ArrayList<>();
		
	}
	public boolean userexist(String  user_id,String password) {
		for(Users user:users) {
			if(user.getUser_id().equals(user_id)&& user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;		
	} 
	
	public  void CheckAccount() {
		 CheckingAccount c=new  CheckingAccount(amount);
		 System.out.println("Enter Monthly Fee:");
		 double interest=sc.nextDouble();
		 c.setMonthly_fee(interest);
		 System.out.println("BALANCE AFTER MONTHLY DEDUCTATION IS"+c.applymonthlyfee());
	}
	public void  acc(double amount) {
		BankAccount b=new BankAccount(amount);
		b.deposite(amount);
		System.out.println(b.getBalance());
	}
	public void saving() {
		SavingAccount s=new SavingAccount(amount);
		System.out.println("Enter Custom Interest rate");
		double interest_rate=sc.nextDouble();
		s.set_Interest_Rate(interest_rate);
		System.out.println("MONTHLY INTEREST RATE"+s.getInterest_rate());
	}
	
	public void createAccount() {
		System.out.println("ENTER USER NAME");
		String user=sc.next();
		System.out.println("ENTER USER ID");
		String user_id=sc.next();
		System.out.println("ENTER USER PASSWORD");
		String password=sc.next();
		System.out.print(" ENTER ACCOUNT NUMBER");
		String account_num=sc.next();
		System.out.println("Enter the amount");
		amount=sc.nextInt();
		
		
		if(userexist(user_id,password)) {
			System.out.println("USER ALREADY EXISTS");
		}
		else {
			Users s=new Users(user,user_id,account_num,password);
			users.add(s);
			acc(amount);
		}
	}
	public void Operation() {
		 int condition=1;
		 System.out.println("Application Started");
		 while(condition>0) {
			 System.out.println("Choose Your Option");
			 System.out.println("Type reg For Register \n Type log to Login \n Type exit to Exit");
			 String option=sc.next();
			 switch(option) {
			 case "reg" : createAccount();
			 				break;
			 case "log" :login();
			 				break;
			 case "exit" : condition=-1;
			 				break;
			 default :System.out.println("WRONG OPTION");
			 }
		 }
	}
	public void login() { 
		 System.out.println("Enter User_id");
		 String user_id=sc.next();
		 System.out.println("Enter password");
		 String password=sc.next();
			 if(userexist(user_id,password)) {
				 System.out.println(" Enter current for current , saving for interest Rate , exit to logout"); 
				 String checkcase=sc.next();
				 boolean opp=true;
				 while(opp) {
					 switch(checkcase) {
					 case "current":
						 System.out.println("");
						 CheckAccount();
						 break;
					 case "saving":
						 System.out.println("");
						 saving();
						 break;	
					 case "exit":opp=false;
					 	System.out.println(" Logout Sucxess");
					 	break;
					 
					 default:System.out.println("INVALID ENTRY Enter again");
					 }	 
				 
				 }
			 }
			 else {
				 System.out.println("INVALID PASSWORD OR USERID");
			 }
		 }
	
		 
	}

