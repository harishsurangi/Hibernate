package com.hibernate.demo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//create session
Session session=factory.getCurrentSession();
		
		
		try {
			 
			session.beginTransaction();
			int studentId=3;
			Student myStudent = session.get(Student.class,studentId);
			
			//update the first Name to scobby
			myStudent.setLastName("jerry");
			
			
			/*
			//update email for all students
			session.createQuery("update Student set email='@gmail.com'").executeUpdate();
			*/
			
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
		}
	}

}
