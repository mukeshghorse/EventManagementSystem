package com.eventManagementSystem.service;

import java.util.Optional;

import com.eventManagementSystem.entities.Venues;

public interface VenueService {

	Venues createVenue(Venues venue);

	Optional<Venues> getVenueById(int id);

	Venues updateVenue(int id, Venues venue);

	void deleteVenue(int id);
}
