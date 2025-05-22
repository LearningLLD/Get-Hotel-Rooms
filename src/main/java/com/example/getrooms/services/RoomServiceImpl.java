package com.example.getrooms.services;

import java.util.List;

import com.example.getrooms.models.Room;
import com.example.getrooms.models.RoomType;
import com.example.getrooms.repositories.RoomRepository;

public class RoomServiceImpl implements RoomService{

    private RoomRepository repository;

    public RoomServiceImpl(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Room> getRooms(String roomType) {
        try{
            if(roomType == "" || roomType == null) {
                return repository.getRooms();
            }

            RoomType type = RoomType.valueOf(roomType);
            return repository.getRoomsByRoomType(type);
        } catch(Exception ex) {
            throw new RuntimeException("Invalid Room type provided");
        }
    }
    
}
