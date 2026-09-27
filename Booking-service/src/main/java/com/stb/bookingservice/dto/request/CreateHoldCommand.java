package com.stb.bookingservice.dto.request;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record CreateHoldCommand(UUID bookingId,
                                UUID eventId,
                                UUID userId,
                                Set<UUID> seatIds,
                                Instant time) {

}