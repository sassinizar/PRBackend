package com.dgpfe.PRBackend.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionService;

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
import com.dgpfe.PRBackend.Service.MissionServices;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api/v1/")
public class MissionController {

	@Autowired
	private MissionRepository missionRepository;
	
	@Autowired
	private MissionServices missionService;
	
	//get All persons
	@GetMapping("/missions")
	public List<Mission> getAllMissions(){
		return missionService.getAllMissions();
		
	}
	
	//save a mission
	@PostMapping("/personne/{id}/mission")
	public Mission createMission(@PathVariable("id") long cin, @RequestBody Mission mission) {
		return missionService.createMission(cin,mission);
	}
	
	//get all missions by person cin
	 @GetMapping("/personne/{cin}/missions")
     public ResponseEntity<List<Mission>> AllMissionsBypersonId(@PathVariable("cin") Long cin) {
		 return missionService.getAllMissionsByPersonId(cin);
    }
	 	
	//get mission by numord
	@GetMapping("/mission/{missionID}")
	  public ResponseEntity<Mission> getAllMissionsByPersonneId(@PathVariable("missionID") String missionID) {
		return missionService.MissionsById(missionID);
	  }
	
	//update mission
	@PutMapping("/mission/{numord}")
	public ResponseEntity<Mission> updateMission(@PathVariable("numord") String numord, @RequestBody Mission missionDetails){
		return missionService.updateMission(numord, missionDetails);
	}
	
	//delete misssion rest api
	@DeleteMapping("/mission/{numOrd}")
	public ResponseEntity<Map<String, Boolean>> deleteMission(@PathVariable("numOrd") String numOrd){
		
		return missionService.deleteMission(numOrd);
	}
	

}
