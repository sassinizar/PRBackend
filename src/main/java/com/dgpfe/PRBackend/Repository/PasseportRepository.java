package com.dgpfe.PRBackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dgpfe.PRBackend.Model.Passeport;


public interface PasseportRepository extends JpaRepository<Passeport, String>{
	List<Passeport> findByPersonneCin(long cin);
}
