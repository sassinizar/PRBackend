package com.dgpfe.PRBackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.dgpfe.PRBackend.Exception.ResourceNotFoundException;
import com.dgpfe.PRBackend.Model.Mission;
import com.dgpfe.PRBackend.Model.Personne;
import com.dgpfe.PRBackend.Repository.MissionRepository;
import com.dgpfe.PRBackend.Repository.PersonneRepository;
import com.dgpfe.PRBackend.Request.PersonneRequest;

@Service
public class PersonneServices {

	@Autowired
	private PersonneRepository personneRepository;
	
	@Autowired 
	private MissionRepository missionRepository;
	
	public PersonneServices() {}
	
	//add a new person
	public Personne addPerson(Personne personne) {
		return personneRepository.save(personne);
	
	}
	
	//get person by id
	public ResponseEntity<Personne> personById(long cin) {
		Personne personne = personneRepository.findById(cin)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Person with cin = " + cin));
		return new ResponseEntity<>(personne, HttpStatus.OK);
	}
	
	//get All persons
	public List<Personne> getAllPersonnes(){
		return personneRepository.findAll();
	}
	
	//update a person
	  public ResponseEntity<Personne> updatePerson(long cin, Personne personne) {
	    Personne _personne = personneRepository.findById(cin)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + cin));

	    _personne.setDirection(personne.getDirection());
	    _personne.setFonction(personne.getFonction());
	    _personne.setNom(personne.getNom());
	    _personne.setPrenom(personne.getPrenom());	    
	    return new ResponseEntity<>(personneRepository.save(_personne), HttpStatus.OK);
	  }
	  
	//delete a person
	  public ResponseEntity<HttpStatus> deletePersonne(long cin) {
	    personneRepository.deleteById(cin);
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
}