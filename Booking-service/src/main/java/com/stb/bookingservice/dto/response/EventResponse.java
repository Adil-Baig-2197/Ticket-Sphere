package com.stb.bookingservice.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class EventResponse {
    private UUID id;
    private String name;
    private String venueName;
    private Instant startTime;
    private int totalSeats;
    private int avlSeats;
}