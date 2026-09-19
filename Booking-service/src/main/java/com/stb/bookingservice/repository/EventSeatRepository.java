package com.stb.bookingservice.repository;

import com.stb.bookingservice.entity.EventSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * Deliberately plain for this step (schema/entities only, per the build
 * order). Locking-specific query methods are added when we build:
 *   - the naive hold endpoint (step 2)
 *   - optimistic-locking hold (step 4) — relies on @Version, no extra
 *     repository method needed beyond save/saveAndFlush
 *   - pessimistic-locking hold (step 5) — adds a
 *     @Lock(LockModeType.PESSIMISTIC_WRITE) findByIdForUpdate() method here
 */
public interface EventSeatRepository extends JpaRepository<EventSeat, UUID> {

    List<EventSeat> findByEventId(UUID eventId);

    /** Replaces what a booking_seats join-table query would have done. */
    List<EventSeat> findByBookingId(UUID bookingId);

    //void findSeatMap(UUID eventId, UUID viewerUserId, Instant instant);
}
