package com.example.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.model.Signalement;
import com.example.webservice.repository.SignalementRepository;

@RestController
@RequestMapping("/")
public class SignalementController {
	@Autowired
    private SignalementRepository signalementRepository;

	// Signalements dans une région
	@GetMapping("/signalements/idRegion")
	public List<Signalement> getResponsableRegionByIdRegion(@RequestParam long idRegion) throws Exception
	{
		return this.signalementRepository.findByIdRegion(idRegion);
	}
	
	// all
	@GetMapping("/signalements")
	public List<Signalement> getAllSignalement() throws Exception
	{
		return this.signalementRepository.findAll();
	}
}
