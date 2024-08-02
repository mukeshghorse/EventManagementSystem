package com.eventManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventManagementSystem.entities.Events;
import com.eventManagementSystem.entities.Organizer;
import com.eventManagementSystem.entities.Venues;
import com.eventManagementSystem.service.EventService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/events")
public class EventController {

	@Autowired
	private EventService eventService;

	// create event
	@PostMapping
	public ResponseEntity<Events> createEvent(@RequestBody Events event) {
		Events createdEvent = eventService.createEvent(event);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);

	}

	// get all events
	@GetMapping
	public ResponseEntity<List<Events>> getAllEvents() {
		List<Events> events = eventService.getAllEvents();
		return ResponseEntity.ok(events);
	}

	// get event by ID
	@GetMapping("/{id}")
	public ResponseEntity<Events> getEventById(@PathVariable int id) {
		Optional<Events> event = eventService.getEventById(id);
		if (event.isPresent()) {
			return ResponseEntity.ok(event.get());
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	// update event
	@PutMapping("/{id}")
	public ResponseEntity<Events> updateEvent(@PathVariable int id, @RequestBody Events event) {
		try {
			Events updatedEvent = eventService.updateEvent(id, event);
			return ResponseEntity.ok(updatedEvent);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	// delete event
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable int id) {
		try {
			eventService.deleteEvent(id);
			return ResponseEntity.noContent().build(); // 202 no content
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build(); // 404 not found
		}
	}

	// get event by venue
	@GetMapping("/by-venue")
	public ResponseEntity<List<Events>> deleteEventByVenue(Venues venue){
		List<Events> event= eventService.findByVenue(venue);
		if(event.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(event);
		}
	}
	
	
	// get event by organizer
	@GetMapping("/by-organizer")
	public ResponseEntity<List<Events>> getEventsByOrganizer(Organizer organizer){
		List<Events> events= eventService.findByOrganizer(organizer);
		if(events.isEmpty()) {
			return ResponseEntity.notFound().build();
			
		}
		else {
			return ResponseEntity.ok(events);
		}
	}
	
	

}
