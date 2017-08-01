package com.jvmhub.tutorial;

import com.github.database.rider.core.DBUnitRule;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.util.EntityManagerProvider;
import com.jvmhub.tutorial.entity.MarketingProgram;
import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for simple App.
 */
@RunWith(JUnit4.class)
public class AppTest extends TestCase {

	private static final String PERSISTENCE_UNIT_NAME = "defaultPersistenceUnit";

	private static EntityManagerFactory factory;


	@Rule
	public EntityManagerProvider emProvider = EntityManagerProvider.instance(PERSISTENCE_UNIT_NAME);

	@Rule
	public DBUnitRule dbUnitRule = DBUnitRule.instance(emProvider.connection());


	@Test
	@DataSet(value = "marketingPrograms.xml", cleanBefore = true)
	public void testApp() {

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		MarketingProgram marketingProgram = (MarketingProgram) em.find(MarketingProgram.class, 1);

		System.out.println(marketingProgram.getId());
		System.out.println(marketingProgram.getName().toString());

		assertThat(7, is(equalTo(marketingProgram.getReceiptSubmissionDays())));

		em.close();
	}
}
