package com.stb.bookingservice.service;

import com.stb.bookingservice.dto.request.CreateHoldCommand;
import com.stb.bookingservice.dto.response.HoldCreatedResponse;
import com.stb.bookingservice.entity.IdempotencyKey;

import java.util.UUID;

public interface HoldService {
    HoldCreatedResponse createHold(CreateHoldCommand command, IdempotencyKey key);
}
