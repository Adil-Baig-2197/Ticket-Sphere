package com.stb.bookingservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

/**
 * Guards the payment gateway webhook handler against redelivered events
 * (e.g. Stripe retrying a webhook that timed out on ack). The event id is
 * the primary key, so a second delivery hits a unique-constraint conflict
 * instead of re-confirming the booking.
 */
@Entity
@Table(name = "processed_webhook_events")
@Getter
@Setter
@NoArgsConstructor
public class ProcessedWebhookEvent {

    @Id
    @Column(name = "event_id", length = 100)
    private String eventId;

    @Column(name = "processed_at", nullable = false)
    private Instant processedAt = Instant.now();
}
