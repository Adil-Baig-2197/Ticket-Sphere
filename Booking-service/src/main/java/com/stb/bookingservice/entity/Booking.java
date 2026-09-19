package com.stb.bookingservice.entity;

import com.stb.bookingservice.entity.enums.BookingStatus;
import com.stb.bookingservice.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * A user's attempt to hold and pay for one or more seats.
 *
 * Payment fields (amount/providerReference/paymentStatus) live directly on
 * Booking rather than a separate Payment entity — a booking is effectively
 * 1:1 with its payment here, so a standalone table just meant an extra join
 * for every read without adding any real independence between the two.
 */
@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private BookingStatus status = BookingStatus.PENDING;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();

    /** Mirrors the hold expiry of this booking's seats; used by the cleanup sweep. */
    @Column(name = "expires_at")
    private Instant expiresAt;

    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", length = 20)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    /** Payment provider's charge/intent id (e.g. Stripe PaymentIntent id). */
    @Column(name = "provider_reference")
    private String providerReference;

    /** The seats this booking currently holds/owns — replaces a booking_seats join table. */
    @OneToMany(mappedBy = "booking")
    private Set<EventSeat> seats = new HashSet<>();
}
