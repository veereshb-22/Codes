package com.c1.hibernateexampleusingannotation.entity;

import javax.persistence.*;

@Entity
@Table(name="student_info")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int student_id;
	@Column(name="student_name",nullable=false)
	private String studentName;
	@Column(name="student_email")
	private String studentEmail;
	
	
	public Student() {
		
	}
	public Student(int student_id, String studentName, String studentEmail) {
		super();
		this.student_id = student_id;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
	}
	
	public int getStudent_id() {
		return student_id;
	}
	
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentEmail() {
		return studentEmail;
	}
	
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ "]";
	}
}
