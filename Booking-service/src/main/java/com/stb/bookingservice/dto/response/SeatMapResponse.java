package com.stb.bookingservice.dto.response;

import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class SeatMapResponse {
    private UUID eventId;
    @Version
    private Long seatMapVersion;
    List<SeatResponse> seats;
}
