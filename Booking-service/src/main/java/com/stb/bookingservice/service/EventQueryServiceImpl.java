package com.stb.bookingservice.service;

import com.stb.bookingservice.dto.response.EventResponse;
import com.stb.bookingservice.dto.response.SeatMapResponse;
import com.stb.bookingservice.entity.Event;
import com.stb.bookingservice.entity.EventSeat;
import com.stb.bookingservice.mapper.Mapper;
import com.stb.bookingservice.repository.EventRepository;
import com.stb.bookingservice.repository.EventSeatRepository;
import org.springframework.stereotype.Service;

//import java.time.Clock;
import java.awt.print.Pageable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public List<EventResponse> getEventList(Instant time, Pageable pageable){
        List<Event> eventList = eventRepository.findEventByStartTimeIsBeforeOrderByStartTime(time,pageable).getContent();
        List<EventResponse> eventResponsesList = new ArrayList<>();
        for(Event event:eventList){
            eventResponsesList.add(mapper.toEventResponse(event));
        }
        return eventResponsesList;
    }

    @Override
    public EventResponse getEvent(UUID eventId){
        Optional<Event> event = eventRepository.findEventById(eventId);
        EventResponse eventResponse=null;
        if(event.isPresent()) {
            eventResponse = mapper.toEventResponse(event);
        }
        return eventResponse;
    }

    @Override
    public SeatMapResponse getSeatMap(UUID eventId, UUID viewerUserId){
        //eventRepository.findPublishedById(eventId);
        //eventSeatRepository.findSeatMap(eventId, viewerUserId, clock.instant());
        List<EventSeat> seats = eventSeatRepository.findByEventId(eventId);
        return mapper.toSeatMapResponse(viewerUserId,eventId,seats);
    }
}