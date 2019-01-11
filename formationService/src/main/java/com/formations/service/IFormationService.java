package com.formations.service;

import java.util.List;

import com.formations.model.Formateur;
import com.formations.model.Formation;

/**
 * Interface des services des formations
 * 
 * @author Mounir
 *
 */
public interface IFormationService {

	/**
	 * Récupère toutes les formations
	 * 
	 * @return {@link List} des {@link Formation}
	 */
	List<Formation> getAllFormations();

	/**
	 * Récupère toutes les formations d'un formateur
	 * 
	 * @param formateur
	 *            formateur concerné
	 * @return {@link List} des {@link Formation}
	 */
	List<Formation> getFormationsByFormateur(Formateur formateur);

	/**
	 * Enregistre les données d'une formation
	 * 
	 * @param formation
	 *            formation à enregistrer
	 */
	void saveFormation(Formation formation);

	/**
	 * Supprime une formation
	 * 
	 * @param idFormation
	 *            id de formation à supprimer
	 */
	void deleteFormation(Long idFormation);

	Formation getFormationById(Long idFormation);
}
