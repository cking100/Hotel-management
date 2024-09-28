package com.chirag.Hotel_management.dto;

import com.chirag.Hotel_management.entity.Room;
import com.chirag.Hotel_management.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDto {
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numOfAdults;
    private int numOfChildren;
    private int totalNumOfGuest;
    private String bookingConfirmationCode;
    private UserDto user;
    private RoomDto room;
}
