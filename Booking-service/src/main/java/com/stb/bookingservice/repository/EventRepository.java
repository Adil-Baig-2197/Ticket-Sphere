package com.stb.bookingservice.repository;

import com.stb.bookingservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    //void findPublishedById(UUID eventId);
    public Event findEventById(UUID eventId);
}
