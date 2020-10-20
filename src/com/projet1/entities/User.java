package com.projet1.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_user;
	@Column(length=50)
	private  String nom_user;
	@Column(length=100)
	private  String prenom_user;
	@Column(length=100)
	private  String email;
	@Column(length=100)
	private  String password;
	private int etat;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


	public String getNom_user() {
		return nom_user;
	}


	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}


	public String getPrenom_user() {
		return prenom_user;
	}


	public void setPrenom_user(String prenom_user) {
		this.prenom_user = prenom_user;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getEtat() {
		return etat;
	}


	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	
}
