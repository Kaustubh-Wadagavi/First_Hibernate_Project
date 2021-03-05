package org.kaustubh.hibernate;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.kaustubh.krishagni.dto.Address;
import org.kaustubh.krishagni.dto.FourWheeler;
import org.kaustubh.krishagni.dto.TwoWheeler;
import org.kaustubh.krishagni.dto.UserDetails;
import org.kaustubh.krishagni.dto.Vehicle;

public class HibernateTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porche");
		car.setSteeringWheel("Porche Steering Wheel");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		
		session.getTransaction().commit();
		
		session.close();	
	}
}
