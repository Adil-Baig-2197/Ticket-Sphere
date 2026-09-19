package com.stb.bookingservice.entity;

import com.stb.bookingservice.entity.enums.IdempotencyStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

/**
 * Guards POST /bookings/{id}/pay against duplicate submissions (e.g. a
 * double-clicked "Pay" button). The client supplies the key; the primary
 * key conflict on a second insert is what makes the check atomic — no
 * separate SELECT-then-INSERT race is possible.
 */
@Entity
@Table(name = "idempotency_keys")
@Getter
@Setter
@NoArgsConstructor
public class IdempotencyKey {

    @Id
    @Column(name = "idempotency_key", length = 100)
    private String key;

    @Column(name = "booking_id", nullable = false)
    private UUID bookingId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private IdempotencyStatus status = IdempotencyStatus.IN_PROGRESS;

    @Lob
    @Column(name = "response_body")
    private String responseBody;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();
}
