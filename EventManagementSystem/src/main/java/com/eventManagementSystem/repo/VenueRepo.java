package com.eventManagementSystem.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventManagementSystem.entities.Venues;

@Repository
public interface VenueRepo extends JpaRepository<Venues, Integer>{

	
	
}
