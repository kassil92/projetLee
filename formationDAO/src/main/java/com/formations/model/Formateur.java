package com.formations.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FORMATEUR")
public class Formateur extends Personne {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Formateur(String login, String password, String role) {
		super();
		Login = login;
		Password = password;
		Role = role;
		
	}



	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Formateur(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}



	@Column(name = "Login")
	private String Login;

	@Column(name = "Password")
	private String Password;
	
	@Column(name = "Role")
	private String Role;
	
	@ManyToOne
	@JoinColumn(name="ADMINISTRATEUR_ID")
	private Administrateur Administrateur;
	
	
	private Set<Formation> listFormations;

	public Set<Formation> getListFormations() {
		return listFormations;
	}
	
	

	public String getLogin() {
		return Login;
	}



	public void setLogin(String login) {
		Login = login;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}



	public String getRole() {
		return Role;
	}



	public void setRole(String role) {
		Role = role;
	}



	public void setListFormations(Set<Formation> listFormations) {
		this.listFormations = listFormations;
	}

}