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
import com.dgpfe.PRBackend.Repository.PersonneRepository;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/v1/")
public class MissionController {

	@Autowired
	private MissionRepository missionRepository;
	
	@Autowired 
	private PersonneRepository perssoneRepository;
	
	
	//get All persons
	@CrossOrigin(origins ="http://localhost:4200")
	@GetMapping("/missions")
	public List<Mission> getAllMissions(){
		return missionRepository.findAll();
		
	}
	
	//save a mission
	@PostMapping("/missions")
	public Mission createMission(@RequestBody Mission mission) {
		return missionRepository.save(mission);
	}
	
	/*
	//get persons by numord
	@GetMapping("/personnes/{personneID}/missions")
	  public ResponseEntity<List<Mission>> getAllMissionsByPersonneId(@PathVariable(value = "personneID") Long personneID) {

	    List<Mission> missions = missionRepository.findByPersonneId(personneID);
	    return new ResponseEntity<>(missions, HttpStatus.OK);
	  }
	*/
	//update mission
	@PutMapping("/mission/{id}")
	public ResponseEntity<Mission> updateMission(@PathVariable String numord, @RequestBody Mission missionDetails){
		Mission mission = missionRepository.findById(numord)
				.orElseThrow(() -> new ResourceNotFoundException("mission n'existe pas:"+numord));		
		mission.setDateDebut(missionDetails.getDateDebut());
		mission.setDateFin(missionDetails.getDateFin());
		mission.setDestination(missionDetails.getDestination());
		mission.setMotif(missionDetails.getMotif());
		
		Mission updateMission = missionRepository.save(mission);
		return ResponseEntity.ok(updateMission);
	}
	
	//delete misssion rest api
	@DeleteMapping("/mission/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMission(@PathVariable String numord){
		Mission mission = missionRepository.findById(numord)
				.orElseThrow(() -> new ResourceNotFoundException("Mission n'existe pas :" + numord) );
		
		missionRepository.delete(mission);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
