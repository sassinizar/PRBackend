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
import com.dgpfe.PRBackend.Service.PasseportServices;
import com.fasterxml.jackson.annotation.JsonIgnore;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/")
public class PasseportController {

	@Autowired
	private PasseportRepository passeportRepository;
	
	@Autowired
	private PasseportServices passeportService;

	
	//save a passeport
	@PostMapping("/personne/{cin}/passeport")
	public Passeport addPasseport(@PathVariable(value = "cin") long cin, @RequestBody Passeport passeport) {
		return passeportService.addPasseport(cin, passeport);
	}
	
	//get All passeports
	@GetMapping("/passeports")
	public List<Passeport> getAllPassports(){
		return passeportService.getAllPassports();
	}
	
	//get all missions by person cin
	@GetMapping("/personne/{cin}/passeports")
	 public ResponseEntity<List<Passeport>> AllPasseportsBypersonId(@PathVariable("cin") Long cin) {
		return passeportService.getAllPasseportsByPersonId(cin);
	    }
	
	
	//get passeport by numero
	@GetMapping("/passeport/{id}")
	public ResponseEntity<Passeport> getPasseportById(@PathVariable("id") String numero){
		return passeportService.getPasseportById(numero);
    }
	
	//update passeport
	@PutMapping("/passeport/{id}")
	public ResponseEntity<Passeport> updatePasseport(@PathVariable("id") String numero, @RequestBody Passeport passeportDetails){
		return passeportService.updatePasseport(numero, passeportDetails);
	}

	//delete passeport rest api
	@DeleteMapping("/passeport/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePasseport(@PathVariable("id") String numero){
       return passeportService.deletePasseport(numero);
	}
}
