package com.example.getrooms.controllers;

import java.util.List;

import com.example.getrooms.dtos.GetRoomsRequestDto;
import com.example.getrooms.dtos.GetRoomsResponseDto;
import com.example.getrooms.dtos.ResponseStatus;
import com.example.getrooms.models.Room;
import com.example.getrooms.services.RoomService;

public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    public GetRoomsResponseDto getRooms(GetRoomsRequestDto requestDto) {
        List<Room> list; 
        GetRoomsResponseDto responseDto = new GetRoomsResponseDto();
        try{
            list = roomService.getRooms(requestDto.getRoomType());
            responseDto.setRooms(list);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch(Exception ex) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        

        return responseDto;
    }
}
