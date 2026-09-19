package com.stb.bookingservice.entity.enums;

public enum BookingStatus {
    PENDING,    // seats held, payment not yet confirmed
    CONFIRMED,  // payment confirmed, seats BOOKED
    EXPIRED,    // hold window passed without payment
    CANCELLED   // user or system cancelled after confirmation
}
