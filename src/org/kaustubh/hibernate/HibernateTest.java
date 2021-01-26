package org.kaustubh.hibernate;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.kaustubh.krishagni.dto.Address;
import org.kaustubh.krishagni.dto.UserDetails;

public class HibernateTest {
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		
		//user.setAddress("First User Address");
		//user.setJoinedDate(new Date());
		//user.setDescription("First user description goes here");
		
		Address addr = new Address();
		
		addr.setStreet("Street Name");
		addr.setCity("City Name");
		
		user.setHomeAddress(addr);
		
		Address addr2 = new Address();
		
		addr2.setStreet("Second Street Name");
		addr2.setCity("Secomd City Name");
		
		user.setOfficeAddress(addr2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);

		session.getTransaction().commit();
		session.close();
		
		/*user = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println("User Name Retrieved is " + user.getUserName());
		*/
		
	}
}
