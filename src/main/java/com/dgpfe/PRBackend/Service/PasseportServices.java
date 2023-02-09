package com.dgpfe.PRBackend.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.dgpfe.PRBackend.Exception.ResourceNotFoundException;
import com.dgpfe.PRBackend.Model.Mission;
import com.dgpfe.PRBackend.Model.Passeport;
import com.dgpfe.PRBackend.Repository.PasseportRepository;
import com.dgpfe.PRBackend.Repository.PersonneRepository;

@Service
public class PasseportServices {

	@Autowired
	private PasseportRepository passeportRepository;
	@Autowired
	private PersonneRepository personneRepository;
	
	//add a new passport
	public Passeport addPasseport(long cin, Passeport passeportRequest){
		Passeport passeport = personneRepository.findById(cin).map(personne -> {
			passeportRequest.setPersonne(personne);
			return passeportRepository.save(passeportRequest);
		}).orElseThrow(()-> new ResourceNotFoundException("Not found personne with id="+cin));
	return passeport;			
	}

	//get all passports
	public List<Passeport> getAllPassports(){
		return passeportRepository.findAll();
	}
	
	
	 //get all missions By person cin
	 public ResponseEntity<List<Passeport>> getAllPasseportsByPersonId(Long cin) {
	   if (!personneRepository.existsById(cin)) {
	     throw new ResourceNotFoundException("Not found person with cin = " + cin);
	   }

	   List<Passeport> passeports = passeportRepository.findByPersonneCin(cin);
	   return new ResponseEntity<>(passeports, HttpStatus.OK);
	 }
	
	
	//Recuper a passport with id
	public ResponseEntity<Passeport> getPasseportById(String numero){
		Passeport passeport = passeportRepository.findById(numero)
				.orElseThrow(() -> new ResourceNotFoundException("passeport n'existe pas :"+numero));
		return ResponseEntity.ok(passeport);
	}
	
	//update a passport
	public ResponseEntity<Passeport> updatePasseport(String numero, Passeport passeportDetails){
		Passeport passeport = passeportRepository.findById(numero)
				.orElseThrow(() -> new ResourceNotFoundException("passeport n'existe pas:"+numero));		
		passeport.setDateEmission(passeportDetails.getDateEmission());
		passeport.setDateValidite(passeportDetails.getDateValidite());
		Passeport updatePasseport = passeportRepository.save(passeport);
		return ResponseEntity.ok(updatePasseport);
	}
	
	//delete a passport
	public ResponseEntity<Map<String, Boolean>> deletePasseport(String numero){
		Passeport passeport = passeportRepository.findById(numero)
				.orElseThrow(() -> new ResourceNotFoundException("Passeport n'existe pas :" + numero) );	
		passeportRepository.delete(passeport);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
