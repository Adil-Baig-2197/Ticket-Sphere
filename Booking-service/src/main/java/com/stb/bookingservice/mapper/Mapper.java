package com.stb.bookingservice.mapper;

import com.stb.bookingservice.dto.response.SeatMapResponse;
import com.stb.bookingservice.dto.response.SeatResponse;
import com.stb.bookingservice.entity.EventSeat;
import com.stb.bookingservice.entity.enums.SeatStatus;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

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


}
