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


@Entity
public class Personne implements Serializable{

	@Id
	private long cin;
	private String nom;
	private String prenom;
	private String fonction;
	private String direction;

	@OneToMany(mappedBy="personne", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Passeport> passeports;
	
	@OneToMany(mappedBy="person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<Mission> missions;
	
	public Collection<Passeport> getPasseports() {
		return passeports;
	}

	public void setPasseports(Collection<Passeport> passeports) {
		this.passeports = passeports;
	}

	public Collection<Mission> getMissions() {
		return missions;
	}

	public void setMissions(Collection<Mission> missions) {
		this.missions = missions;
	}

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
