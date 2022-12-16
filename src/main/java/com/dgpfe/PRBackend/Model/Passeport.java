package com.dgpfe.PRBackend.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Passeport implements Serializable {

	@Id
	private String numpasseport;
	private Date dateEmission;
	private Date dateValidite;
	
	 @ManyToOne
	 private Personne personne;

	
	public Personne getPersonne() {
		return personne;
	}


	public void setPersonne(Personne personne) {
		this.personne = personne;
	}


	public Passeport( Date dateEmission, Date dateValidite) {
		super();
		this.dateEmission = dateEmission;
		this.dateValidite = dateValidite;
	}


	public Passeport() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Passeport [numpasseport=" + numpasseport + ", dateEmission=" + dateEmission + ", dateValidite="
				+ dateValidite + "]";
	}


	public String getNumpasseport() {
		return numpasseport;
	}


	public void setNumpasseport(String numpasseport) {
		this.numpasseport = numpasseport;
	}


	public Date getDateEmission() {
		return dateEmission;
	}


	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}


	public Date getDateValidite() {
		return dateValidite;
	}


	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}
	
	
	
}
