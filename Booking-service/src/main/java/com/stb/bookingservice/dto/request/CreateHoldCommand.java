package com.stb.bookingservice.dto.request;

import java.util.Set;
import java.util.UUID;

public record CreateHoldCommand(UUID eventId,
                                UUID userId,
                                Set<UUID> seatIds) {

}
