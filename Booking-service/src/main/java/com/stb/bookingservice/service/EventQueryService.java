package com.stb.bookingservice.service;

import com.stb.bookingservice.dto.response.SeatMapResponse;

import java.util.UUID;

public interface EventQueryService {
    SeatMapResponse getSeatMap(UUID eventId, UUID viewerUserId);
}
