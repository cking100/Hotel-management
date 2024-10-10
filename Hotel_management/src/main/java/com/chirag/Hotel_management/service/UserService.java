package com.chirag.Hotel_management.service;
import com.chirag.Hotel_management.dto.LoginRequest;
import com.chirag.Hotel_management.dto.Response;
import com.chirag.Hotel_management.entity.User;

public interface UserService {
    Response register(User user);
    Response login (LoginRequest loginRequest);
    Response getALlUser();
    Response getBookingHistory(String userId);
    Response deleteUser(String userId);
    Response getUserById(String userId);
    Response getMyBookings(String email);

}
