package com.stb.bookingservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    /** Kept as a plain string rather than a Venue entity — this project
     * doesn't need a reusable venue catalog. */
    @Column(name = "venue_name", nullable = false)
    private String venueName;

    @Column(name = "start_time", nullable = false)
    private Instant startTime;
//
//    @Column(name = "totalSeats", nullable = false)
//    private int totalSeats;
//
//    @Column(name = "avlSeats", nullable = false)
//    private int avlSeats;
}
