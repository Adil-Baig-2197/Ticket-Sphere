package com.stb.bookingservice.service;

import com.stb.bookingservice.dto.request.CreateHoldCommand;
import com.stb.bookingservice.dto.response.HoldCreatedResponse;
import com.stb.bookingservice.repository.BookingRepository;
import com.stb.bookingservice.repository.EventRepository;
import com.stb.bookingservice.repository.EventSeatRepository;

public class HoldServiceImpl  implements HoldService {
    private final EventRepository eventRepository;
    private final BookingRepository bookingRepository;
    private final EventSeatRepository eventSeatRepository;

    public HoldServiceImpl(EventSeatRepository eventSeatRepository,
                           BookingRepository bookingRepository,
                           EventRepository eventRepository) {
        this.eventRepository = eventRepository;
        this.bookingRepository = bookingRepository;
        this.eventSeatRepository = eventSeatRepository;
    }

    @Override
    public HoldCreatedResponse createHold(CreateHoldCommand command){
        return null;
    }
}
