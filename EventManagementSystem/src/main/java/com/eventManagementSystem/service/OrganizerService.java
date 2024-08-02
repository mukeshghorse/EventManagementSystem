package com.eventManagementSystem.service;

import java.util.Optional;


import com.eventManagementSystem.entities.Organizer;
import com.eventManagementSystem.repo.OrganizerRepo;

public interface OrganizerService extends OrganizerRepo{
	
	Organizer createOrganizer(Organizer organizer);
	
	Optional<Organizer> getOrganizerById(int id);
	
	Organizer updateOrganizer(int id, Organizer organizer);
	
	void deleteOrganizer(int id);
}
