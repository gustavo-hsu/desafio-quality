package com.br.meli.desafioquality.dto;


import com.br.meli.desafioquality.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PropertyDTO {
    @NotBlank(message = "The name of the property can not be empty")
    @Size(max = 30, message = "The property name length can not have more than 30 characters")
    @Pattern(regexp="^[A-Z][a-zA-Z ]*$")
    private String propName;

    @NotBlank(message = "The name of the district can not be empty")
    @Size(max=45, message = "The max district name can not have more than 45 characters")
    private String propDistrict;

    @Valid
    private List<RoomDTO> rooms;

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        for(RoomDTO roomDTO: this.getRooms()) {
            rooms.add(roomDTO.toRoom());
        }

        return rooms;
    }
}
