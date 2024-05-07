package com.fst.str.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Etudiant {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
	@Column(name="name")
private String nom;
private String prenom;
private String email;
public Etudiant(String nom, String prenom, String email, Classe classe) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.classe = classe;
}
@ManyToOne
private Classe classe;
public Classe getClasse() {
	return classe;
}
public void setClasse(Classe classe) {
	this.classe = classe;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Etudiant(long id, String nom, String prenom, String email) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
}
public Etudiant(long id, String nom, String prenom, String email, Classe classe) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.classe = classe;
}
public Etudiant(String nom, String prenom, String email) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
}
public Etudiant() {
	super();
}

	
	
}
