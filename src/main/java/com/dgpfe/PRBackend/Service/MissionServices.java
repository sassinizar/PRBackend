package com.dgpfe.PRBackend.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dgpfe.PRBackend.Exception.ResourceNotFoundException;
import com.dgpfe.PRBackend.Model.Mission;
import com.dgpfe.PRBackend.Model.Passeport;
import com.dgpfe.PRBackend.Repository.MissionRepository;
import com.dgpfe.PRBackend.Repository.PersonneRepository;

@Service
public class MissionServices {

 @Autowired	
 MissionRepository missionRepository; 
 
 @Autowired
 PersonneRepository personneRepository;
 
 //recuper all missions
 public List<Mission> getAllMissions(){
		return missionRepository.findAll();
	}
 
 
 //get all missions By person cin
 public ResponseEntity<List<Mission>> getAllMissionsByPersonId(Long cin) {
   if (!personneRepository.existsById(cin)) {
     throw new ResourceNotFoundException("Not found person with cin = " + cin);
   }

   List<Mission> missions = missionRepository.findByPersonCin(cin);
   return new ResponseEntity<>(missions, HttpStatus.OK);
 }
 
 
 //add mission
 public Mission createMission(long cin, Mission missionRequest) {
	Mission mission = personneRepository.findById(cin).map(personne -> {
		missionRequest.setPerson(personne);
		return missionRepository.save(missionRequest);
	}).orElseThrow(()-> new ResourceNotFoundException("Not found personne with id="+cin));
 return mission;	
 }

 //get mission by id numero d'ordre
 public ResponseEntity<Mission> MissionsById(String numord) {
    Mission mission = missionRepository.findById(numord)
    .orElseThrow(() -> new ResourceNotFoundException("passeport n'existe pas :"+numord));
  return ResponseEntity.ok(mission);
 }
 
	//update mission
	public ResponseEntity<Mission> updateMission(String numord, Mission missionDetails){
		Mission mission = missionRepository.findById(numord)
				.orElseThrow(() -> new ResourceNotFoundException("mission n'existe pas:"+numord));		
		mission.setDateDebut(missionDetails.getDateDebut());
		mission.setDateFin(missionDetails.getDateFin());
		mission.setDestination(missionDetails.getDestination());
		mission.setMotif(missionDetails.getMotif());
		
		Mission updateMission = missionRepository.save(mission);
		return ResponseEntity.ok(updateMission);
	}
	
	//delete mission
	public ResponseEntity<Map<String, Boolean>> deleteMission(String numord){
		Mission mission = missionRepository.findById(numord)
				.orElseThrow(() -> new ResourceNotFoundException("Mission n'existe pas :" + numord) );
		
		missionRepository.delete(mission);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
 
}
