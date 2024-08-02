package com.eventManagementSystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventManagementSystem.entities.Events;
import com.eventManagementSystem.entities.Organizer;
import com.eventManagementSystem.entities.Venues;
import com.eventManagementSystem.repo.EventRepository;
import com.eventManagementSystem.service.EventService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public Events createEvent(Events event) {
		return eventRepository.save(event);
	}

	@Override
	public List<Events> getAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public Optional<Events> getEventById(int id) {
		
		return eventRepository.findById(id);
	}


    @Override
    public Events updateEvent(int id, Events event) {
        if (eventRepository.existsById(id)) {
            event.setEventId(id);  // Ensure the ID of the event is preserved.
            return eventRepository.save(event);
        } else {
            throw new EntityNotFoundException("Event with ID " + id + " not found.");
        }
    }

	@Override
	public void deleteEvent(int id) {
		if(eventRepository.existsById(id)) {
			eventRepository.deleteById(id);;
		}
		else {
			throw new EntityNotFoundException("Event with ID " + id + " not found.");
		}
		
	}
	
	@Override
	public List<Events> findByVenue(Venues venue){
		return eventRepository.findByVenue(venue);
		
	}
	
	@Override
	public List<Events> findByOrganizer(Organizer organizer){
		return eventRepository.findByOrganizer(organizer);
	}

	

	
	
	
}
