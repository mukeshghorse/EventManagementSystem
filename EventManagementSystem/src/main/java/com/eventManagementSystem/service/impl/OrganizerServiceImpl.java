package com.eventManagementSystem.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.eventManagementSystem.entities.Organizer;
import com.eventManagementSystem.repo.OrganizerRepo;
import com.eventManagementSystem.service.OrganizerService;

@Service
public class OrganizerServiceImpl implements OrganizerService{
	
	@Autowired
	private OrganizerRepo organizerRepo;


	@Override
	public Organizer getById(Integer id) {
		
		return null;
	}

	
	@Override
	public Organizer createOrganizer(Organizer organizer) {

		return organizerRepo.save(organizer);
	}

	@Override
	public Optional<Organizer> getOrganizerById(int id) {
		return Optional.empty();
	}

	@Override
	public Organizer updateOrganizer(int id, Organizer organizer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrganizer(int id) {
		// TODO Auto-generated method stub
		
	}

}
