package com.stb.bookingservice.service;

import com.stb.bookingservice.dto.request.CreateHoldCommand;
import com.stb.bookingservice.dto.response.HoldCreatedResponse;
import com.stb.bookingservice.entity.Hold;
import com.stb.bookingservice.repository.BookingRepository;
import com.stb.bookingservice.repository.EventRepository;
import com.stb.bookingservice.repository.EventSeatRepository;

import java.time.Duration;

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
        Hold hold = new Hold();
        hold.setBookingId(command.bookingId());
        hold.setEventId(command.eventId());
        hold.setUserId(command.userId());
        hold.setCreatedAt(command.time());
        hold.setExpiresAt(command.time().plus(Duration.ofMinutes(10)));

        return  new HoldCreatedResponse();
    }
}
