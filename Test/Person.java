package com.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person  extends Passport{
	public 	String id;
	public	String fname;
	public	String lname;
	public	String Valid_date;
	public	String dob;
	public	int age;
	public	int expiredDate;


}
