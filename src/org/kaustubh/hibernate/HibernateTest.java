package org.kaustubh.hibernate;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.kaustubh.krishagni.dto.Address;
import org.kaustubh.krishagni.dto.UserDetails;
import org.kaustubh.krishagni.dto.Vehicle;

public class HibernateTest {
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		user.setVehicle(vehicle);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		
		session.close();
				
	}
}
