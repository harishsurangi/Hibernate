package com.hibernate.demo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteDemo {

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
			
			session.delete(myStudent);
		/*
			//another way of doing it 
			
			session.createQuery("delete from Student where id=3").executeUpdate();
			*/
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
		}
	}

}
