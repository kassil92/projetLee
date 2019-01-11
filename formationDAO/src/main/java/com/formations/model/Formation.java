package com.formations.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Formation")
public class Formation implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "NOM")
	private String nom;

	@ManyToOne
	@JoinColumn(name = "FORMATEUR_ID")
	private Formateur formateur;

	@ManyToMany
	@JoinTable(name = "FORMATION_ETUDIANT", joinColumns = {
			@JoinColumn(name = "FORMATION_ID", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ETUDIANT_ID", nullable = false) })
	private Set<Etudiant> listEtudiants;

	public Formation(Long id) {
		this.id = id;
	}

	public Formation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Set<Etudiant> getListEtudiants() {
		return listEtudiants;
	}

	public void setListEtudiants(Set<Etudiant> listEtudiants) {
		this.listEtudiants = listEtudiants;
	}

	@Override
	public String toString() {
		return "Formation [id=" + id + ", code=" + code + ", nom=" + nom + ", formateur=" + formateur + "]";
	}

}