package fr.m2i.models;

import java.beans.JavaBean;
import java.sql.Date;

@JavaBean
public class Personne {
	
	private String nom;
	private String prenom;
	private Date date_modif;
	
	public Personne(String nom, String prenom) {
		this.setNom(nom);
		this.setPrenom(prenom);
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getdate_modif() {
		return date_modif;
	}
	public void setdate_modif(Date date_modif) {
		this.date_modif = date_modif;
	}
}
