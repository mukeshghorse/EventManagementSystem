package com.eventManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventManagementSystem.entities.Organizer;

@Repository
public interface OrganizerRepo extends JpaRepository<Organizer, Integer> {

	
}
