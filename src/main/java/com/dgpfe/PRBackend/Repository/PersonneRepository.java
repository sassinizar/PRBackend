package com.dgpfe.PRBackend.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dgpfe.PRBackend.Model.Mission;
import com.dgpfe.PRBackend.Model.Passeport;
import com.dgpfe.PRBackend.Model.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long>{
	
	@Query("SELECT missions From Personne WHERE cin = ?1")
    List<Mission> getMissionsByPersonne(long cin);

	@Query("SELECT passeports From Personne WHERE cin = ?1")
    List<Passeport> getPasseportsByPersonne(long cin);
} 
