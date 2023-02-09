package com.dgpfe.PRBackend.Request;

import java.util.List;

import com.dgpfe.PRBackend.Model.Mission;
import com.dgpfe.PRBackend.Model.Passeport;

public class PersonneRequest {

	
	public int id;
	
	public String nom;
	
	public String prenom;
	
	public String fonction;
	
	public String direction;
	
	public List<Passeport> passeports;
	
	public List<Mission> missions;
	
}
