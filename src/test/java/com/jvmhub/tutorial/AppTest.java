package com.jvmhub.tutorial;

import com.jvmhub.tutorial.entity.MarketingProgram;
import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	public void testApp() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		MarketingProgram marketingProgram = new MarketingProgram();
		session.save(marketingProgram);

		session.getTransaction().commit();
		session.close();
	}
}
