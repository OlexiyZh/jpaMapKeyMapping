package com.jvmhub.tutorial;

import com.jvmhub.tutorial.entity.MarketingProgram;
import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	private String PERSISTENCE_UNIT_NAME = "defaultPersistenceUnit";

	private static EntityManagerFactory factory;

	@Test
	public void testApp() {

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		MarketingProgram marketingProgram = (MarketingProgram) em.find(MarketingProgram.class, 1);

		System.out.println(marketingProgram.getId());
		System.out.println(marketingProgram.getName().toString());

		assertThat(1, is(equalTo(marketingProgram.getId())));

		em.close();
	}
}
