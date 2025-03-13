package com.hotel.service.auth;

import com.hotel.dto.SignUpRequest;
import com.hotel.dto.UserDto;

public interface AuthService {

    UserDto createUser(SignUpRequest signUpRequest);
}
