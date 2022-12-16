package com.dgpfe.PRBackend.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Mission implements Serializable{

	@Id
	private String numOrd;
	private Date dateDebut;
	private Date dateFin;
	private String destination;
	private String motif;
	
	 @ManyToOne
	 private Personne person;
	
	public Personne getPerson() {
		return person;
	}
	public void setPersonne(Personne personne) {
		this.person = personne;
	}
	public Mission( Date dateDebut, Date dateFin, String destination, String motif) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.destination = destination;
		this.motif = motif;
	}
	public Mission() {
		// TODO Auto-generated constructor stub
	}
	public String getNumOrd() {
		return numOrd;
	}
	public void setNumOrd(String numOrd) {
		this.numOrd = numOrd;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	
	
}
