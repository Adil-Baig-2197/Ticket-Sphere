package com.stb.bookingservice.entity.enums;

/**
 * Lifecycle of a single seat for a single event.
 *
 * AVAILABLE -> HELD   (hold() succeeds, race-protected by locking strategy)
 * HELD      -> BOOKED (payment confirmed via webhook)
 * HELD      -> AVAILABLE (hold expires / user cancels)
 * BOOKED    -> AVAILABLE (refund / cancellation, policy-dependent)
 */
public enum SeatStatus {
    AVAILABLE,
    HELD,
    BOOKED
}
