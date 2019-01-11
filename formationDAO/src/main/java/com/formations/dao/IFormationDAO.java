package com.formations.dao;

import java.sql.SQLException;
import java.util.List;

import com.formations.model.Formateur;
import com.formations.model.Formation;

/**
 * Interface d'accès aux données des formations
 * 
 * @author Mounir
 *
 */
public interface IFormationDAO {

	
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
	 *            formation à supprimer
	 */
	void deleteFormation(Long idFormation);

	Formation getFormationById(Long idFormation);
	
	public 	Formateur Authentification(String login,String password) throws SQLException, ClassNotFoundException;
	     

	     
		 
		 
		
}
