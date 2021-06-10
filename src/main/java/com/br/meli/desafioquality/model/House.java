package com.br.meli.desafioquality.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private String name;
    private List<Room> rooms;
    private District district;

    public House(String propName, List<Room> rooms) {
        this.name = propName;
        this.rooms = rooms;
    }

    public Double getValue() {
        Double totalValue = 0.0;

        for(Room room:this.getRooms())
            totalValue += room.getSize()*district.pricePerSquareMeter;

        return totalValue;
    }

    public Room getBiggestRoom() {
        Room biggestRoom = this.getRooms().get(0);

        for(Room room:this.getRooms()) {
            if(room.getSize() >= biggestRoom.getSize()) {
                biggestRoom = room;
            }
        }

        return biggestRoom;
    }

    public Double getTotalSize() {
        Double totalSize = 0.0;

        for(Room room:this.getRooms())
            totalSize += room.getSize();

        return totalSize;
    }
}
