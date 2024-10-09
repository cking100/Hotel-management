package com.chirag.Hotel_management.repository;
import com.chirag.Hotel_management.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

    public interface BookingRepository extends JpaRepository<Booking, Long> {

        Optional<Booking> findByBookingConfirmationCode(String confirmationCode);
    }
