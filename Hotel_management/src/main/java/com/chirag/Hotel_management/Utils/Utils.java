package com.chirag.Hotel_management.Utils;

import com.chirag.Hotel_management.dto.BookingDto;
import com.chirag.Hotel_management.dto.RoomDto;
import com.chirag.Hotel_management.dto.UserDto;
import com.chirag.Hotel_management.entity.Booking;
import com.chirag.Hotel_management.entity.Room;
import com.chirag.Hotel_management.entity.User;
import java.util.List;
import java.util.stream.Collectors;
import java.security.SecureRandom;

public class Utils {

    private static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom secureRandom = new SecureRandom();

    // Generate random confirmation code
    public static String generateRandomConfirmationCode(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    // Entity to DTO Mapping

    public static UserDto mapUserEntityToUserDTO(User user) {
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setRole(user.getRole());
        return userDTO;
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

    public static RoomDto mapRoomEntityToRoomDTOPlusBookings(Room room) {
        RoomDto roomDTO = new RoomDto();
        roomDTO.setId(room.getId());
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setRoomPrice(room.getRoomPrice());
        roomDTO.setRoomPhotoUrl(room.getRoomPhotoUrl());
        roomDTO.setRoomDescription(room.getRoomDescription());
        if (room.getBookings() != null) {
            roomDTO.setBookings(room.getBookings().stream().map(Utils::mapBookingEntityToBookingDTO).collect(Collectors.toList()));
        }
        return roomDTO;
    }

    public static BookingDto mapBookingEntityToBookingDTOPlusBookedRooms(Booking booking, boolean mapUser) {
        BookingDto bookingDTO = new BookingDto();
        bookingDTO.setId(booking.getId());
        bookingDTO.setCheckInDate(booking.getCheckInDate());
        bookingDTO.setCheckOutDate(booking.getCheckOutDate());
        bookingDTO.setNumOfAdults(booking.getNumOfAdults());
        bookingDTO.setNumOfChildren(booking.getNumOfChildren());
        bookingDTO.setTotalNumOfGuest(booking.getTotalNumOfGuest());
        bookingDTO.setBookingConfirmationCode(booking.getBookingConfirmationCode());
        if (mapUser) {
            bookingDTO.setUser(Utils.mapUserEntityToUserDTO(booking.getUser()));
        }
        if (booking.getRoom() != null) {
            bookingDTO.setRoom(Utils.mapRoomEntityToRoomDTO(booking.getRoom()));
        }
        return bookingDTO;
    }

    public static UserDto mapUserEntityToUserDTOPlusUserBookingsAndRoom(User user) {
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setRole(user.getRole());
        if (!user.getBookings().isEmpty()) {
            userDTO.setBookings(user.getBookings().stream()
                    .map(booking -> mapBookingEntityToBookingDTOPlusBookedRooms(booking, false))
                    .collect(Collectors.toList()));
        }
        return userDTO;
    }

    public static List<UserDto> mapUserListEntityToUserListDTO(List<User> userList) {
        return userList.stream().map(Utils::mapUserEntityToUserDTO).collect(Collectors.toList());
    }

    public static List<RoomDto> mapRoomListEntityToRoomListDTO(List<Room> roomList) {
        return roomList.stream().map(Utils::mapRoomEntityToRoomDTO).collect(Collectors.toList());
    }

    public static List<BookingDto> mapBookingListEntityToBookingListDTO(List<Booking> bookingList) {
        return bookingList.stream().map(Utils::mapBookingEntityToBookingDTO).collect(Collectors.toList());
    }

    // Reverse Mapping: DTO to Entity

    public static Booking mapBookingDtoToBookingEntity(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setCheckInDate(bookingDto.getCheckInDate());
        booking.setCheckOutDate(bookingDto.getCheckOutDate());
        booking.setNumOfAdults(bookingDto.getNumOfAdults());
        booking.setNumOfChildren(bookingDto.getNumOfChildren());
        booking.setTotalNumOfGuest(bookingDto.getTotalNumOfGuest());
        booking.setBookingConfirmationCode(bookingDto.getBookingConfirmationCode());

        if (bookingDto.getRoom() != null) {
            Room room = new Room();
            room.setId(bookingDto.getRoom().getId());
            room.setRoomType(bookingDto.getRoom().getRoomType());
            room.setRoomPrice(bookingDto.getRoom().getRoomPrice());
            room.setRoomPhotoUrl(bookingDto.getRoom().getRoomPhotoUrl());
            room.setRoomDescription(bookingDto.getRoom().getRoomDescription());
            booking.setRoom(room);
        }
        return booking;
    }

    public static Room mapRoomDtoToRoom
