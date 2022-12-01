package com.hibernate.demo2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class GetStudentDemo {

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
    	 /* //get all data
    	  List<Student>  students=session.createQuery("from Student").getResultList();
    	  */
    	  
    	//get all particular data
    	  List<Student>  students=session.createQuery("from Student s where s.lastName='surangi'").getResultList();
    	  
    	 for(Student tempstudent : students) {
    		 System.out.println(tempstudent);
    	 }
    	  
    	  session.getTransaction().commit();
    	  
      }finally {
    	  factory.close();
      }
	}

}
