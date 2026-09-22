package com.stb.bookingservice.service;

import com.stb.bookingservice.dto.response.EventResponse;
import com.stb.bookingservice.dto.response.SeatMapResponse;

import java.util.UUID;

public interface EventQueryService {
    EventResponse getEvent(UUID eventId);
    SeatMapResponse getSeatMap(UUID eventId, UUID viewerUserId);
}
