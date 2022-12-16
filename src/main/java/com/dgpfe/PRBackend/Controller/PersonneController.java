package com.dgpfe.PRBackend.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dgpfe.PRBackend.Exception.ResourceNotFoundException;
import com.dgpfe.PRBackend.Model.Mission;
import com.dgpfe.PRBackend.Model.Personne;
import com.dgpfe.PRBackend.Repository.MissionRepository;
import com.dgpfe.PRBackend.Repository.PasseportRepository;
import com.dgpfe.PRBackend.Repository.PersonneRepository;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/v1/")
public class PersonneController {

	@Autowired
	private PersonneRepository personneRepository;
	
	@Autowired
	private MissionRepository missionRepository;
	
	@Autowired
	private PasseportRepository passeportRepository;
	
	//get All persons
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/personnes")
	public List<Personne> getAllPersonnes(){
		return personneRepository.findAll();
	}

	
	//save a person
	@PostMapping("/personnes")
	public Personne createPersonne(@RequestBody Personne personne) {
		return personneRepository.save(personne);
	}
	
	//get persons by cin
	@GetMapping("/personnes/{cin}")
	public ResponseEntity<Personne> getPersonneById(@PathVariable long cin){
		Personne personne = personneRepository.findById(cin)
				.orElseThrow(() -> new ResourceNotFoundException("personne n'existe pas :"+cin));
		return ResponseEntity.ok(personne);
	}
	
	
	
	//update person
	@PutMapping("/personnes/{cin}")
	public ResponseEntity<Personne> updatePersonne(@PathVariable long cin, @RequestBody Personne personneDetails){
		Personne personne = personneRepository.findById(cin)
				.orElseThrow(() -> new ResourceNotFoundException("Personne n'existe pas:"+cin));		
		personne.setNom(personneDetails.getNom());
		personne.setDirection(personneDetails.getDirection());
		personne.setPrenom(personneDetails.getPrenom());
		personne.setCin(personneDetails.getCin());
		personne.setFonction(personneDetails.getFonction());
		
		Personne updatePersonne = personneRepository.save(personne);
		return ResponseEntity.ok(updatePersonne);
	}
	
	//delete person rest api
	@DeleteMapping("/personnes/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePersonne(@PathVariable long id){
		Personne personne = personneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Personne n'existe pas :" + id) );
		
		personneRepository.delete(personne);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
