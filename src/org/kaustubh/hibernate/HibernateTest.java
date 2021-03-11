package org.kaustubh.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.kaustubh.krishagni.dto.UserDetails;

public class HibernateTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user = (UserDetails)session.get(UserDetails.class, 6);
		user.setUserName("Updated user");
		session.update(user);
		
		session.getTransaction().commit();
		session.close();
	}
}
