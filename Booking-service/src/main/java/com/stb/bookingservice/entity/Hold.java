package com.stb.bookingservice.entity;

import com.stb.bookingservice.entity.enums.HoldStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "holds")
@Getter
@Setter
@NoArgsConstructor
public class Hold {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID holdId;

    @Column(nullable = false)
    private UUID bookingId;

    @Column(nullable = false)
    private UUID eventId;

    @Column(nullable = false)
    private UUID userId;

    @ManyToMany
    @JoinTable(
            name = "hold_event_seats",
            joinColumns = @JoinColumn(name = "hold_id"),
            inverseJoinColumns = @JoinColumn(name = "event_seat_id")
    )
    private Set<EventSeat> seats = new HashSet<>();

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant expiresAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HoldStatus status = HoldStatus.ACTIVE;
}