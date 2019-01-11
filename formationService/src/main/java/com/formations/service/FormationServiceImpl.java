package com.formations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formations.dao.IFormationDAO;
import com.formations.model.Formateur;
import com.formations.model.Formation;

@Service("formationService")
public class FormationServiceImpl implements IFormationService {

	// @Autowired
	private IFormationDAO formationDAO;

	@Autowired
	public FormationServiceImpl(IFormationDAO formationDAO) {
		this.formationDAO = formationDAO;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Formation> getAllFormations() {
		return formationDAO.getAllFormations();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Formation> getFormationsByFormateur(Formateur formateur) {
		return formationDAO.getFormationsByFormateur(formateur);
	}

	@Override
	@Transactional
	public void saveFormation(Formation formation) {
		if (formation.getId() != null) {
			Formation oldFormation = formationDAO.getFormationById(formation.getId());
			oldFormation.setCode(formation.getCode());
			oldFormation.setNom(formation.getNom());
			formationDAO.saveFormation(oldFormation);
		} else {
			formationDAO.saveFormation(formation);
		}
	}

	@Override
	@Transactional
	public void deleteFormation(Long idFormation) {
		formationDAO.deleteFormation(idFormation);
	}

	@Override
	@Transactional
	public Formation getFormationById(Long idFormation) {
		return formationDAO.getFormationById(idFormation);
	}

}
