package com.br.meli.desafioquality.dto;


import com.br.meli.desafioquality.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
public class RoomWithSizeDTO {
    private String roomName;

    private Double roomWidth;

    private Double roomLength;

    private Double roomSize;

    public RoomWithSizeDTO(Room room) {
        this.roomName = room.getName();
        this.roomWidth = room.getWidth();
        this.roomLength =  room.getLength();
        this.roomSize = room.getSize();
    }
}
