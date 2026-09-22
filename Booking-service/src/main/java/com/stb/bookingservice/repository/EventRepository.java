package com.stb.bookingservice.repository;

import com.stb.bookingservice.entity.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID>, JpaSpecificationExecutor<Event> {
    //void findPublishedById(UUID eventId);
    Optional<Event> findEventById(UUID eventId);
}
