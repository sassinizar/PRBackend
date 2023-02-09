package com.dgpfe.PRBackend.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.dgpfe.PRBackend.Model.Mission;


public interface MissionRepository extends JpaRepository<Mission, String>{

	List<Mission> findByPersonCin(Long cin);
}
