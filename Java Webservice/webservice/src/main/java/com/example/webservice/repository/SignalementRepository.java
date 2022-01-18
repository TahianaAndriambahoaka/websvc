package com.example.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webservice.model.Signalement;

@Repository
public interface SignalementRepository extends JpaRepository<Signalement, Long> {
	
	List<Signalement> findByIdRegion(long idRegion);
}
