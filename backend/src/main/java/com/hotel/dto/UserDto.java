package com.hotel.dto;

import lombok.Data;

@Data
public class UserDto {

    private long Id;

    private String email;

    private String name;

    private String UserRole;
}
