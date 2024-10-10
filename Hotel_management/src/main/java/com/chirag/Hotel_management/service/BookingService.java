package com.chirag.Hotel_management.service;
import com.chirag.Hotel_management.dto.Response;
import com.chirag.Hotel_management.entity.Booking;

public interface BookingService {
    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);
}


