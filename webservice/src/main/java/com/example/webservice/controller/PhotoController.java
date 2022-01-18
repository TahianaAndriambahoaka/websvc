package com.example.webservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.exception.ResourceNotFoundException;
import com.example.webservice.model.Photo;
import com.example.webservice.repository.PhotoRepository;

@RestController
@RequestMapping("/")
public class PhotoController {
	@Autowired
    private PhotoRepository photoRepository;

	// all
	@GetMapping("/photos")
	public List<Photo> getAllPhoto() throws Exception
	{
		return photoRepository.findAll();
	}
	
	// get photo by id
	@GetMapping("/photo/{id}")
	public ResponseEntity<Photo> getPhotoById(@PathVariable(value = "id") long idPhoto) throws Exception
	{
		Photo photo = photoRepository.findById(idPhoto).orElseThrow(()->new ResourceNotFoundException("Photo not found for this id :: " ));
        return ResponseEntity.ok().body(photo);
	}
	
	// insert
	@PostMapping("/photo")
	public Photo createPhoto(@RequestBody Photo photo) throws Exception
	{
		return this.photoRepository.save(photo);
	}
	
	// update
	@PutMapping("/photo/{id}")
	public ResponseEntity<Photo> updatePhoto(@PathVariable(value = "id") Long idPhoto , @Valid @RequestBody Photo photoDetails) throws Exception
	{
		Photo photo = photoRepository.findById(idPhoto).orElseThrow(()->new ResourceNotFoundException("Photo not found for this id"));
        photo.setIdSignalement(photoDetails.getIdSignalement());
        photo.setPhoto(photoDetails.getPhoto());
        return ResponseEntity.ok(this.photoRepository.save(photo));
	}
	
	// delete
	@DeleteMapping("/photo/{id}")
	public Map<String,Boolean> deletePhoto(@PathVariable(value = "id") long idPhoto) throws Exception
	{
		Photo photo = photoRepository.findById(idPhoto).orElseThrow(()->new ResourceNotFoundException("Photo not found for this id"));
        this.photoRepository.delete(photo);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
	}
}
