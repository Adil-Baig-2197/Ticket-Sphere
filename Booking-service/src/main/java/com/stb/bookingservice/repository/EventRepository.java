package com.stb.bookingservice.repository;

import com.stb.bookingservice.dto.response.EventResponse;
import com.stb.bookingservice.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    //void findPublishedById(UUID eventId);
    Optional<Event> findEventById(UUID eventId);
    Page<Event> findEventByStartTimeIsBeforeOrderByStartTime(Instant time, Pageable pageable);
}
