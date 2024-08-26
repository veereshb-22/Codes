package com.c1.hibernateexampleusingannotation.entity;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateMethods {
	Transaction tx= null;
	
	public void addData(String name,String email) {
		Session dbSession=null;
			dbSession=HibernateUtil.getSessionFactory().openSession();
			Student st=new Student();
			st.setStudentName(name);
			st.setStudentEmail(email);
			tx=dbSession.beginTransaction();
			
			dbSession.save(st);
			tx.commit();
	}
	
	public void deletebyID(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 tx= session.beginTransaction();
			Query deleteQuery = session.createQuery("delete from Student where student_id = :id");
			deleteQuery.setInteger("id", id);
			int rowCount = deleteQuery.executeUpdate();
			if(rowCount!=0){
				System.out.println("rows deleted = "+rowCount);
			}else{
				System.out.println("no rows found");
			}
			tx.commit();
		}
		
		
	}
	
	
	public void deleteAll() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx= session.beginTransaction();
			Query deleteQuery = session.createQuery("delete from Student");
			int rowCount = deleteQuery.executeUpdate();
			if(rowCount!=0){
				System.out.println("rows deleted = "+rowCount);
			}else{
				System.out.println("no rows found");
			}
			tx.commit();
		}
		
	}

	public void updateQuery( String email,int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			 tx=session.beginTransaction();
			 Query update=session.createQuery("update Student set studentEmail = :email where student_id =:id ");
			 update.setString("email",email);
			 update.setInteger("id",id);
			 int status=update.executeUpdate();
			 if(status!=0) {
				 System.out.println("UPDATED");
					tx.commit();
			 }
			 else {
				 System.out.println("NOT UPDATED");
				 
			 }
		}
	}
	public void display() {	
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			Transaction tr=session.beginTransaction();
			List<Student> student=session.createQuery("from Student",Student.class).list();
			//class name is used in query
			student.stream().forEach(System.out::println);	
			}
		
	}
}
