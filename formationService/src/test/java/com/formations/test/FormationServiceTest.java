package com.formations.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formations.model.Formation;
import com.formations.service.IFormationService;

public class FormationServiceTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");

		IFormationService formationService = (IFormationService) appContext.getBean("formationService");

		List<Formation> allFormations = formationService.getAllFormations();

		for (Formation formation : allFormations) {
			System.out.println(formation);
		}

	}

}
