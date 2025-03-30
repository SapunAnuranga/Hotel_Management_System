package com.hotel.service.admin.rooms;

import com.hotel.dto.RoomDto;
import com.hotel.dto.RoomsResponseDto;

public interface RoomsService {

    boolean postRoom(RoomDto roomDto);

    RoomsResponseDto getAllRooms(int pageNumber);
}
