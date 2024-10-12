package com.chirag.Hotel_management.Utils;

import com.chirag.Hotel_management.dto.BookingDto;
import com.chirag.Hotel_management.dto.RoomDto;
import com.chirag.Hotel_management.dto.UserDto;
import com.chirag.Hotel_management.entity.Booking;
import com.chirag.Hotel_management.entity.Room;
import com.chirag.Hotel_management.entity.User;

import java.security.SecureRandom;

public class Utils {
    private static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom secureRandom = new SecureRandom();
    public static String generateCode(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<length; i++) {
            int randomIndex = secureRandom.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    public static RoomDto mapRoomEntityToRoomDTO(Room room) {
        RoomDto roomDTO = new RoomDto();
        roomDTO.setId(room.getId());
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setRoomPrice(room.getRoomPrice());
        roomDTO.setRoomPhotoUrl(room.getRoomPhotoUrl());
        roomDTO.setRoomDescription(room.getRoomDescription());
        return roomDTO;
    }
    public static BookingDto mapBookingEntityToBookingDTO(Booking booking) {
        BookingDto bookingDTO = new BookingDto();
        bookingDTO.setId(booking.getId());
        bookingDTO.setCheckInDate(booking.getCheckInDate());
        bookingDTO.setCheckOutDate(booking.getCheckOutDate());
        bookingDTO.setNumOfAdults(booking.getNumOfAdults());
        bookingDTO.setNumOfChildren(booking.getNumOfChildren());
        bookingDTO.setTotalNumOfGuest(booking.getTotalNumOfGuest());
        bookingDTO.setBookingConfirmationCode(booking.getBookingConfirmationCode());
        return bookingDTO;
    }
    public static UserDto mapUserEntityToUserDTO(User user) {
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

}
