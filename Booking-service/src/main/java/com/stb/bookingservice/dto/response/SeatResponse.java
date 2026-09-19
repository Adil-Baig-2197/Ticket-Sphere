package com.stb.bookingservice.dto.response;

import com.stb.bookingservice.entity.enums.SeatStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class SeatResponse {
    private UUID id;
    private String section;
    private String rowLabel;
    private String seatNumber;
    private SeatStatus status;
    private BigDecimal price;
    private Instant heldUntil;
}
