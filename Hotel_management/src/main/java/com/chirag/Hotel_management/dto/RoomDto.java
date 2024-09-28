package com.chirag.Hotel_management.dto;

import com.chirag.Hotel_management.entity.Booking;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RoomDto {
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private String roomPhotoUrl;
    private String roomDescription;
    private List<Booking> bookings;

}
