package com.fst.str.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Classe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nom;
	@OneToMany
	private List<Etudiant>etudiants;
	
	public Classe() {
		super();
	}
	public Classe(String nom) {
		super();
	
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Classe [id=" + id + ", nom=" + nom + "]";
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

}
