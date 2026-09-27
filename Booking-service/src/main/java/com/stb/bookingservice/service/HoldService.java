package com.stb.bookingservice.service;

import com.stb.bookingservice.dto.request.CreateHoldCommand;
import com.stb.bookingservice.dto.response.HoldCreatedResponse;

public interface HoldService {
    HoldCreatedResponse createHold(CreateHoldCommand command);
}
