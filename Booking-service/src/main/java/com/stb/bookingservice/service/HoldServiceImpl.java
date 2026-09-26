package com.stb.bookingservice.service;

import com.stb.bookingservice.dto.request.CreateHoldCommand;
import com.stb.bookingservice.dto.response.HoldCreatedResponse;
import com.stb.bookingservice.entity.IdempotencyKey;

public class HoldServiceImpl  implements HoldService {
    @Override
    public HoldCreatedResponse createHold(CreateHoldCommand command, IdempotencyKey key){
        return null;
    }
}
