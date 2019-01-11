package com.formations.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.formations.model.Etudiant;
import com.formations.model.Formateur;
import com.formations.model.Formation;

public class TestHibernate {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		configureUsingHibernateConfigXMLFile();
	}

	public static void configureUsingHibernateConfigXMLFile() {
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

		// Begin transaction
		session.getTransaction().begin();

		Etudiant etudiant;
		Formation formation;
		Set<Etudiant> listEtudiants;
		Formateur formateur;
		for (int i = 1; i <= 4; i++) {
			formation = new Formation();
			formation.setNom("nom_formation " + i);
			formation.setCode("code_formation " + i);

			listEtudiants = new HashSet<>();
			for (int j = 1; j <= 3; j++) {
				etudiant = new Etudiant();
				etudiant.setNom("nom_etudiant " + i + "" + j);
				etudiant.setPrenom("prenom_etudiant " + i + "" + j);
				session.save(etudiant);

				listEtudiants.add(etudiant);
			}
			formation.setListEtudiants(listEtudiants);

			formateur = new Formateur();
			formateur.setNom("nom_formateur " + i);
			formateur.setPrenom("prenom_formateur " + i);
			session.save(formateur);
			formation.setFormateur(formateur);

			session.save(formation);
		}

		// Commit transaction
		session.getTransaction().commit();

		System.exit(0);
	}


}
