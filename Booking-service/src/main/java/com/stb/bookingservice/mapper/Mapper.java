package com.stb.bookingservice.mapper;

import com.stb.bookingservice.dto.response.EventResponse;
import com.stb.bookingservice.dto.response.SeatMapResponse;
import com.stb.bookingservice.dto.response.SeatResponse;
import com.stb.bookingservice.entity.Event;
import com.stb.bookingservice.entity.EventSeat;
import com.stb.bookingservice.entity.enums.SeatStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Component
public class Mapper {

    public SeatMapResponse toSeatMapResponse(UUID userId,UUID eventId,List<EventSeat> seats){
        SeatMapResponse seatMapResponse = new SeatMapResponse();
        seatMapResponse.setEventId(eventId);
        for(EventSeat seat:seats){
            SeatResponse se = new SeatResponse();
            se.setId(seat.getId());
            se.setPrice(seat.getPrice());
            se.setSection(seat.getSection());
            se.setSeatNumber(seat.getSeatNumber());
            se.setRowLabel(seat.getRowLabel());
            if(Objects.equals(seat.getBooking().getUserId(), userId)){
                se.setStatus(SeatStatus.AVAILABLE);
                se.setHeldUntil(seat.getHeldUntil());
            }else {
                se.setStatus(seat.getStatus());
                se.setHeldUntil(null);
            }
        }
        return seatMapResponse;
    }

    public static EventResponse toEventResponse(Event event){
        EventResponse eventResponse = new EventResponse();
        eventResponse.setId(event.getId());
        eventResponse.setName(event.getName());
        eventResponse.setVenueName(event.getVenueName());
        eventResponse.setStartTime(event.getStartTime());
        eventResponse.setAvlSeats(event.getAvlSeats());
        eventResponse.setTotalSeats(event.getTotalSeats());
        return eventResponse;
    }

    public EventResponse toEventResponse(Optional<Event> event){
        EventResponse eventResponse = new EventResponse();
        eventResponse.setId(event.get().getId());
        eventResponse.setName(event.get().getName());
        eventResponse.setVenueName(event.get().getVenueName());
        eventResponse.setStartTime(event.get().getStartTime());
        eventResponse.setAvlSeats(event.get().getAvlSeats());
        eventResponse.setTotalSeats(event.get().getTotalSeats());
        return eventResponse;
    }
}
