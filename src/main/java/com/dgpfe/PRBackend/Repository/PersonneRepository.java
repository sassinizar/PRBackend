package com.dgpfe.PRBackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dgpfe.PRBackend.Model.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long>{

}
