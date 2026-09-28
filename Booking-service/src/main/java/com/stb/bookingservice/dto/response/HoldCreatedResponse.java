package com.stb.bookingservice.dto.response;

import com.stb.bookingservice.entity.EventSeat;
import com.stb.bookingservice.entity.enums.HoldStatus;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class HoldCreatedResponse {
    private UUID holdId;
    private UUID bookingId;
    private UUID eventId;
    private Set<EventSeat> seats = new HashSet<>();
    private Instant expiresAt;
    private HoldStatus status;
    private BigDecimal totalPrice;
}
