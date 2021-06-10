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
public class RoomDTO {
    @NotBlank(message = "The name of the room can not be empty")
    @Size(max = 30, message = "The room name can not have more than 30 characters")
    private String roomName;

    @NotNull(message = "The width of the room can not be empty")
    @Max(value = 25, message = "The max room width allowed is 25 meters")
    private Double roomWidth;

    @NotNull(message = "The length of the room can not be empty")
    @Max(value = 33, message = "The max room width allowed is 33 meters")
    private Double roomLength;

    public Room toRoom() {
        return new Room(roomName, roomWidth, roomLength);
    }
}
