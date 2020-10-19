package com.projet1.entities;

import java.io.Serializable;

public class Client implements Serializable {
	private Long id_client;
	private String nom_client;
	private String adresse_client;
	private String telephone_client;
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", nom_client=" + nom_client + ", adresse_client=" + adresse_client
				+ ", telephone_client=" + telephone_client + "]";
	}


	public Long getId_client() {
		return id_client;
	}


	public void setId_client(Long id_client) {
		this.id_client = id_client;
	}


	public String getNom_client() {
		return nom_client;
	}


	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}


	public String getAdresse_client() {
		return adresse_client;
	}


	public void setAdresse_client(String adresse_client) {
		this.adresse_client = adresse_client;
	}


	public String getTelephone_client() {
		return telephone_client;
	}


	public void setTelephone_client(String telephone_client) {
		this.telephone_client = telephone_client;
	}
	
	

}
