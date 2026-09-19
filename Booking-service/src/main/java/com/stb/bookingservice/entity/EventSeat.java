package com.stb.bookingservice.entity;

import com.stb.bookingservice.entity.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * THE core concurrency-sensitive entity. Two concurrent requests racing to
 * flip the same row from AVAILABLE to HELD must not both succeed.
 *
 * Seat identity (section/row/seat number) lives directly on this row rather
 * than a separate Seat entity — there's no need for a venue-wide seat
 * catalog reused across events in this project, so splitting "the seat"
 * from "the seat's booking state" only added an extra join for no benefit.
 *
 * - {@code version} backs optimistic locking (Hibernate manages the
 *   "WHERE version = ?" check and increment automatically on update).
 * - Pessimistic locking, when used instead, is applied at the repository
 *   query level (SELECT ... FOR UPDATE) and needs no extra column here.
 * - {@code booking} is set when a hold is placed and is the replacement
 *   for a separate booking_seats join table: a seat can only ever be held
 *   by one booking at a time, so a direct FK captures that fully.
 */
@Entity
@Table(
    name = "event_seats",
    uniqueConstraints = @UniqueConstraint(columnNames = {"event_id", "section", "row_label", "seat_number"})
)
@Getter
@Setter
@NoArgsConstructor
public class EventSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(nullable = false)
    private String section;

    @Column(name = "row_label", nullable = false)
    private String rowLabel;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SeatStatus status = SeatStatus.AVAILABLE;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /** Set once a hold is placed; null when AVAILABLE. Replaces a separate join table. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    /** User/session id currently holding this seat. Null when AVAILABLE. */
    @Column(name = "held_by")
    private String heldBy;

    /** When the current hold expires. Null when AVAILABLE. */
    @Column(name = "held_until")
    private Instant heldUntil;

    /**
     * Optimistic locking column. Hibernate appends this to every UPDATE
     * WHERE clause and increments it on write; a stale write throws
     * ObjectOptimisticLockingFailureException instead of silently
     * overwriting a concurrent change.
     */
    @Version
    @Column(nullable = false)
    private Long version;
}
