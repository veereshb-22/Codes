package com.students;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentOperation {
	
	List<Students> s1=new ArrayList<Students>();
	
	Students s=null;
	Scanner sc=new Scanner(System.in);
	public void storeStudentDetails() {
			System.out.println("Enter the number of student Semester");
			int num=sc.nextInt();
			for(int j=0;j<num;j++) {
				s=new Students();
				HashMap<Integer,Float> lm=new HashMap<>();
				ArrayList<String> skills =new ArrayList<>();
				System.out.println("Enter Number of Students");
				s.setStudentname(sc.next());
				System.out.println("Enter Student ID");
				s.setStudentID(sc.next());
				System.out.println("Enter the Total Semester");
				int stsem=sc.nextInt();
				for(int i=0;i<stsem;i++) {
					System.out.println(" Enter Sem");
					int se=sc.nextInt();
					System.out.println("Enter Percatenage");
					float per=sc.nextFloat();
					lm.put(se,per);
					
				}
				System.out.println("Enter the number of Skills");
				int sk=sc.nextInt();String skillsname;
				for(int i=0;i<sk;i++) {
					System.out.println(" Enter  Skills");
					 skillsname=sc.next();
					if(!check(skillsname)) {
						try {
							throw new SkillCannotAddException(" Add Proper Skill Name");
						} catch (SkillCannotAddException e) {
							System.out.println(e);
							
						}	
					}
					skills.add(skillsname);
					
						
						
				}
				s.setStudentper(lm);
				s.setStudentskill(skills);
				s1.add(s);
			}
	}

	public void showStudentResult() {
		System.out.println("Results");
		System.out.println("Students Result");
		List<HashMap<Integer, Float>> percentages = s1.stream()
                .flatMap(student -> Stream.of(student.getStudentper())) // Create a stream of percentage values
                .collect(Collectors.toList());
		System.out.println(percentages);
	}

	public void showStudentDetails() {
		System.out.println("Show");
		System.out.println(s1);	
	}
	public boolean check(String s) {
		if(s.matches("[a-zA-Z]+")) {
			return true;
		}
		return false;
	}

}
