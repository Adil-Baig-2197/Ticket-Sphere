package com.stb.bookingservice.repository;

import com.stb.bookingservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    //void findPublishedById(UUID eventId);
    public Optional<Event> findEventById(UUID eventId);
}
