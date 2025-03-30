package com.hotel.dto;

import lombok.Data;
import java.util.List;

@Data
public class RoomsResponseDto {


    private List<RoomDto> RoomDtoList;

    private Integer totalPages;

    private Long totalRooms;

    private Integer pageNumber;


}
