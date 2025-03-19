package com.hotel.dto;

import com.hotel.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;

    private long userId;

    private UserRole userRole;
}
