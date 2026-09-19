package com.stb.bookingservice.service;

import com.stb.bookingservice.dto.response.SeatMapResponse;
import com.stb.bookingservice.entity.EventSeat;
import com.stb.bookingservice.mapper.Mapper;
import com.stb.bookingservice.repository.EventRepository;
import com.stb.bookingservice.repository.EventSeatRepository;
import org.springframework.stereotype.Service;

//import java.time.Clock;
import java.util.List;
import java.util.UUID;

@Service
public class EventQueryServiceImpl implements EventQueryService{
    private final EventRepository eventRepository;
    private final EventSeatRepository eventSeatRepository;
    //Clock clock;
    Mapper mapper = new Mapper();

    public EventQueryServiceImpl(EventRepository eventRepository, EventSeatRepository eventSeatRepository){
        this.eventRepository = eventRepository;
        this.eventSeatRepository = eventSeatRepository;
    }

    @Override
    public SeatMapResponse getSeatMap(UUID eventId, UUID viewerUserId){
        eventRepository.findPublishedById(eventId);
        //eventSeatRepository.findSeatMap(eventId, viewerUserId, clock.instant());
        List<EventSeat> seats = eventSeatRepository.findByEventId(eventId);
        return mapper.toSeatMapResponse(viewerUserId,eventId,seats);
    }
}