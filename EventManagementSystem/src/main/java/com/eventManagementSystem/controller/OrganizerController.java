package com.eventManagementSystem.controller;

import java.util.Optional;
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

import com.eventManagementSystem.entities.Organizer;
import com.eventManagementSystem.service.OrganizerService;

@RestController
@RequestMapping("/api/organizer")
public class OrganizerController {

	@Autowired
	private OrganizerService organizerService;
	
	// create organizer
	@PostMapping
	public ResponseEntity<Organizer> createOrganizer(Organizer organizer){
		Organizer createdOrganizer = organizerService.createOrganizer(organizer);
		return ResponseEntity.ok(createdOrganizer);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Organizer> getOrganizerById(@PathVariable int id){
		Optional<Organizer> organizer = organizerService.findById(id);
		if(organizer.isPresent()) {
			return ResponseEntity.ok(organizer.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//update Organizer
	@PutMapping("/{id}")
	public ResponseEntity<Organizer> updateOrganizer(@PathVariable int id , @RequestBody Organizer organizer){
		Organizer updatedOrganizer = organizerService.updateOrganizer(id, organizer);
		if(updatedOrganizer !=null) {
			return ResponseEntity.ok(updatedOrganizer);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	//delete organizer by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrganizer(@PathVariable int id){
		organizerService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
