package com.example.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.exception.ResourceNotFoundException;
import com.example.webservice.model.Type;
import com.example.webservice.repository.TypeRepository;

@RestController
@RequestMapping("/")
public class TypeController {
	@Autowired
    private TypeRepository typeRepository;
	
    // all
 	@GetMapping("/types")
 	public List<Type> getAllTypes() throws Exception
 	{
 		return this.typeRepository.findAll();
 	};

    // Type par id
 	@GetMapping("/type/{id}")
 	public ResponseEntity<Type> getTypeById(@PathVariable(value = "id") long idType) throws Exception
 	{
 		Type type = typeRepository.findById(idType).orElseThrow(()->new ResourceNotFoundException("Employee not found for this id :: " ));
        return ResponseEntity.ok().body(type);
 	};
}
