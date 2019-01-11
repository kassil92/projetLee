package com.formations.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ADMINISTRATEUR")
public class Administrateur {

	@Column(name = "Login")
	private String Login;

	@Column(name = "Password")
	private String Password;
	

	@Column(name = "Role")
	private String Role;
	
	@OneToMany(mappedBy = "Administrateur", fetch= FetchType.EAGER)
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

	public Administrateur() {
		// TODO Auto-generated constructor stub
	}

}
