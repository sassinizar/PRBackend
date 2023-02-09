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
import org.springframework.web.bind.annotation.RestController;
import com.dgpfe.PRBackend.Exception.ResourceNotFoundException;
import com.dgpfe.PRBackend.Model.Mission;
import com.dgpfe.PRBackend.Model.Passeport;
import com.dgpfe.PRBackend.Model.Personne;
import com.dgpfe.PRBackend.Repository.PersonneRepository;
import com.dgpfe.PRBackend.Request.PersonneRequest;
import com.dgpfe.PRBackend.Service.PersonneServices;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/")
public class PersonneController {

	
	@Autowired
	private PersonneServices personneService;
	
	 //add person
	@PostMapping("/person")
	public Personne addPerson(@RequestBody Personne personneRequest) {
		return personneService.addPerson(personneRequest);
	}
	
	//get person by id
	@GetMapping("/personne/{cin}")
	public ResponseEntity<Personne> getPersonByCin(@PathVariable("cin") long cin){
		return personneService.personById(cin);
	}

	//get All persons
	@GetMapping("/personnes")
	public List<Personne> AllPersonnes(){
		return personneService.getAllPersonnes();
	}
	
	@PutMapping("/personnes/{cin}")
	public ResponseEntity<Personne> updatePersonne(@PathVariable("cin") long cin, @RequestBody Personne personne) {
		return personneService.updatePerson(cin, personne);
	  }

	@DeleteMapping("/personnes/{cin}")
	public ResponseEntity<HttpStatus> deleteAllTutorials(@PathVariable("cin") long cin) {
	    return personneService.deletePersonne(cin);
	  }
	 
/*	
	//save a person
	@PostMapping("/personnes")
	public Personne createPersonne(@RequestBody Personne personne) {
		return personneRepository.save(personne);
				
	}
	
	
	
	//get persons by cin
	@GetMapping("/personnes/{cin}")
	public ResponseEntity<Personne> getPersonneById(@PathVariable long cin){
		Personne personne = personneRepository.findById(cin)
				.orElseThrow(() -> new ResourceNotFoundException("personne n'existe pas :" + cin));
		return ResponseEntity.ok(personne);
	}

	//get all missions of the person
	@GetMapping("/personnes/{cin}/missions")
	public List<Mission> getMissionsByPerson(@PathVariable("cin") long  cin){		
		return personneRepository.getMissionsByPersonne(cin);	
	}

	//get all passports of the person
		@GetMapping("/personnes/{cin}/passeports")
		public List<Passeport> getPasseportsByPerson(@PathVariable("cin") long  cin){		
			return personneRepository.getPasseportsByPersonne(cin);	
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
*/	
	

}
