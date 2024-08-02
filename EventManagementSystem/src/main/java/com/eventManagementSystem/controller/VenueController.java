package com.eventManagementSystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventManagementSystem.entities.Venues;
import com.eventManagementSystem.service.VenueService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
	
	@Autowired
	private VenueService venueService;
	
	
	//creating new venue
	@PostMapping
	public ResponseEntity<Venues> createVenue(@RequestBody Venues venue){
		Venues createdVenue = venueService.createVenue(venue);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdVenue);
	}
	
	//get venue by ID
	@GetMapping("/{id}")
	public ResponseEntity<Venues> getVenueById(@PathVariable int id){
		Optional<Venues> venue= venueService.getVenueById(id);
		if(venue.isPresent()) {
			
			return ResponseEntity.ok(venue.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// update venue
	@PutMapping("/{id}")
	public ResponseEntity<Venues> updateVenue(@PathVariable int id, @RequestBody Venues venue){
		try {
			Venues updatedVenue= venueService.updateVenue(id, venue);
			return ResponseEntity.ok(updatedVenue);
			
		}
		catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	// delete venue by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVenue(@PathVariable int id){
		venueService.deleteVenue(id);
		return ResponseEntity.noContent().build();
	}
	
}
