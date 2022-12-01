package com.hibernate.demo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		
		//create session factory
	SessionFactory factory = new Configuration()
			                 .configure("hibernate.cfg.xml")
			                 .addAnnotatedClass(Student.class)
			                 .buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();
	
	try {
		  //use the session object to save java object
		
		//create a student object
		  Student tempstudent= new Student("kcr","reddy","kcr@cm.com");
		  
		  // start transaction
		  session.beginTransaction();
		  
		  //save the student object
		  session.save(tempstudent);
		  
		  //commit transaction
		  session.getTransaction().commit();
		  
		  
		   
		 
		   
	}
	finally {
       factory.close();
       }
}
}