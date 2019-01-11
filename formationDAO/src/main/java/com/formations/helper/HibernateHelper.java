package com.formations.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateHelper {
	private static Session session;

	public static Session getSession() {
		if (session != null) {
			return session;
		}

		// Create configuration instance
		Configuration configuration = new Configuration();

		// Pass hibernate configuration file
		configuration.configure("hibernate.cfg.xml");

		// Since version 4.x, service registry is being used
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		// Create session factory instance
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		// Get current session or open it
		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (org.hibernate.HibernateException he) {
			session = factory.openSession();
		}
		return session;
	}

	public static void main(String[] args) {

		List<String> listStr = new ArrayList<>();

		Set<String> setString = (Set<String>) listStr;
	}

}
