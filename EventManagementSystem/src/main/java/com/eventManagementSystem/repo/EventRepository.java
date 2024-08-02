package com.eventManagementSystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventManagementSystem.entities.Events;
import com.eventManagementSystem.entities.Organizer;
import com.eventManagementSystem.entities.Venues;

@Repository
public interface EventRepository extends JpaRepository<Events, Integer> {
    List<Events> findByVenue(Venues venue);
    List<Events> findByOrganizer(Organizer organizer);
}
