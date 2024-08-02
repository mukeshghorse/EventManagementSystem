package com.eventManagementSystem.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventManagementSystem.entities.Venues;
import com.eventManagementSystem.repo.VenueRepo;
import com.eventManagementSystem.service.VenueService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VenueServiceImpl implements VenueService {
	
	@Autowired
	private VenueRepo venueRepo;

	@Override
	public Venues createVenue(Venues venue) {
		
		return venueRepo.save(venue);
	}

	@Override
	public Optional<Venues> getVenueById(int id) {
		
		return venueRepo.findById(id);
	}

	@Override
	public Venues updateVenue(int id, Venues venue) {
		if(venueRepo.existsById(id)) {
			venue.setVenueId(id);
			return venueRepo.save(venue);
		}
		else {
			throw new EntityNotFoundException("Event with ID \" + id + \" not found.");
		}
		
	}

	@Override
	public void deleteVenue(int id) {
		venueRepo.deleteById(id);
		
	}
	
	

}
