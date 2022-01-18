package com.example.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.model.Region;
import com.example.webservice.repository.RegionRepository;

@RestController
@RequestMapping("/")
public class RegionController {
	@Autowired
    private RegionRepository regionRepository;
	
	// all
	@GetMapping("/regions")
	public List<Region> getAllRegion() throws Exception
	{
		return regionRepository.findAll();
	}
}
