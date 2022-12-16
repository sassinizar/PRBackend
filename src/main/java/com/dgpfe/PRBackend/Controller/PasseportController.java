package com.dgpfe.PRBackend.Controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.dgpfe.PRBackend.Repository.MissionRepository;
import com.dgpfe.PRBackend.Repository.PasseportRepository;


@RestController
@RequestMapping("api/v1/")
public class PasseportController {

	@Autowired
	private PasseportRepository passeportRepository;
	
	//get All passeports
	@CrossOrigin(origins ="http://localhost:4200")
	@GetMapping("/passeports")
	public List<Passeport> getAllPassports(){
		return passeportRepository.findAll();
	}
	
	//save a passeport
	@PostMapping("/passeports")
	public Passeport createPasseport(@RequestBody Passeport passeport) {
		return passeportRepository.save(passeport);
	}
	
	//get passeport by numero
	@GetMapping("/passeports/{id}")
	public ResponseEntity<Passeport> getPasseportById(@PathVariable String numero){
		Passeport passeport = passeportRepository.findById(numero)
				.orElseThrow(() -> new ResourceNotFoundException("passeport n'existe pas :"+numero));
		return ResponseEntity.ok(passeport);
	}
	
	//update passeport
	@PutMapping("/passeport/{id}")
	public ResponseEntity<Passeport> updatePasseport(@PathVariable String numero, @RequestBody Passeport passeportDetails){
		Passeport passeport = passeportRepository.findById(numero)
				.orElseThrow(() -> new ResourceNotFoundException("passeport n'existe pas:"+numero));		
		passeport.setDateEmission(passeportDetails.getDateEmission());
		passeport.setDateValidite(passeportDetails.getDateValidite());
		
		Passeport updatePasseport = passeportRepository.save(passeport);
		return ResponseEntity.ok(updatePasseport);
	}
	
	//delete passeport rest api
	@DeleteMapping("/passeport/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePasseport(@PathVariable String numero){
		Passeport passeport = passeportRepository.findById(numero)
				.orElseThrow(() -> new ResourceNotFoundException("Passeport n'existe pas :" + numero) );
		
		passeportRepository.delete(passeport);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
