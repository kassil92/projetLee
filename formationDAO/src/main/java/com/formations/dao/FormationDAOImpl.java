package com.formations.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formations.model.Formateur;
import com.formations.model.Formation;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@Repository("formationDAO")
public class FormationDAOImpl implements IFormationDAO {

	public Connection connexion;
	  public Statement statement;
	  public ResultSet resultat;
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Formation> getAllFormations() {
		String getAllFormationsQuery = "FROM Formation";
		Query query = sessionFactory.getCurrentSession().createQuery(getAllFormationsQuery);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Formation> getFormationsByFormateur(Formateur formateur) {
		String getAllFormationsQuery = "FROM Formation formation INNER JOIN formation.formateur formateur WHERE  formateur.id = :idFormateur";
		Query query = sessionFactory.getCurrentSession().createQuery(getAllFormationsQuery);
		query.setParameter("idFormateur", formateur.getId());
		return query.list();
	}

	@Override
	public void saveFormation(Formation formation) {
		sessionFactory.getCurrentSession().saveOrUpdate(formation);
	}

	@Override
	public void deleteFormation(Long idFormation) {
		sessionFactory.getCurrentSession().delete(getFormationById(idFormation));
	}

	@Override
	public Formation getFormationById(Long idFormation) {
		String getFormationById = "FROM Formation formation WHERE formation.id = :idFormation";
		Query query = sessionFactory.getCurrentSession().createQuery(getFormationById);
		query.setParameter("idFormation", idFormation);

		return (Formation) query.uniqueResult();
	}

	@Override
	public 	Formateur Authentification(String login,String password) throws SQLException, ClassNotFoundException
	{  
		Class.forName("com.mysql.jdbc.Driver");
		connexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root", "mounir123");
		Statement st;
		  st = (Statement) connexion.createStatement();

	     //ResultSet est une table qui contient le resultat de laffichage
	  ResultSet resultat=st.executeQuery("SELECT * from utilisateur");
	  Formateur F=new Formateur();

	     boolean b=false;
	     while(resultat.next())
	     {
	    	 if(    (resultat.getString(1).equals(login)) &&( resultat.getString(2).equals(password))  ){
	    	 
	    	
	    	F=new Formateur (resultat.getString(1), resultat.getString(2), resultat.getString(3));
	    }
	     }
	    	
	    	return F;
	     
	
		 
		 }
		
	
  	

}
