package com.jvmhub.tutorial;


import com.jvmhub.tutorial.entity.MarketingProgram;
import com.jvmhub.tutorial.entity.MarketingProgramLocalized;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
	public static void main(String[] args) {

		printMarketingProgram();
		// printMarketingProgramLocalized();

	}

	private static void printMarketingProgram() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		MarketingProgram marketingProgram = (MarketingProgram) session.get(MarketingProgram.class, 1);

		System.out.println(marketingProgram.getId());
		System.out.println(marketingProgram.getName().toString());

		session.getTransaction().commit();
		session.close();
	}

	private static void printMarketingProgramLocalized() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<MarketingProgramLocalized> marketingProgramLocalizedList = session.createCriteria(MarketingProgramLocalized.class).list();
		System.out.println(marketingProgramLocalizedList.get(0).getLocale());

		session.getTransaction().commit();
		session.close();
	}

}
