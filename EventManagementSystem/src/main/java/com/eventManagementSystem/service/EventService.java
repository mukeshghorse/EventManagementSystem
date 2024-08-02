package com.eventManagementSystem.service;

import java.util.List;
import java.util.Optional;

import com.eventManagementSystem.entities.Events;
import com.eventManagementSystem.entities.Organizer;
import com.eventManagementSystem.entities.Venues;

public interface EventService {

	Events createEvent(Events event);
	
	List<Events> getAllEvents();
	
	Optional<Events> getEventById(int id);
	
	Events updateEvent(int id,Events event);
	
	void deleteEvent(int id);

	List<Events> findByVenue(Venues venue);

	List<Events> findByOrganizer(Organizer organizer);
	
}
