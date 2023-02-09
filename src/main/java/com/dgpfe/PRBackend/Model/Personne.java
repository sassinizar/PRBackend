package com.dgpfe.PRBackend.Model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.mapping.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Personne implements Serializable{

	@Id
	private long cin;
	private String nom;
	private String prenom;
	private String fonction;
	private String direction;

	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "personne_cin")
	private List<Passeport> passeports = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "person_cin")
	private List<Mission> missions = new ArrayList<>();
	
	
	public List<Passeport> getPasseports() {
		return passeports;
	}

	public void setPasseports(List<Passeport> passeports) {
		this.passeports = passeports;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
/*
	public Personne( String nom, String prenom, String fonction, String direction) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.direction = direction;
	}
	public Personne() {
		
		// TODO Auto-generated constructor stub
	}
*/
	@Override
	public String toString() {
		return "Personne [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", fonction=" + fonction
				+ ", direction=" + direction + "]";
	}

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
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

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}
