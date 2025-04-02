package com.hotel.service.admin.rooms;

import com.hotel.dto.RoomDto;
import com.hotel.dto.RoomsResponseDto;

public interface RoomsService {

    boolean postRoom(RoomDto roomDto);

    RoomsResponseDto getAllRooms(int pageNumber);

    RoomDto getRoomById(long roomId);

    boolean updateRoom(Long id, RoomDto roomDto);

    void deleteRoom (Long id);
}
