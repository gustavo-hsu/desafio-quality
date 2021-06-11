package com.br.meli.desafioquality.service;

import com.br.meli.desafioquality.dto.HouseDTO;
import com.br.meli.desafioquality.dto.PropertySizeDTO;
import com.br.meli.desafioquality.dto.RoomDTO;
import com.br.meli.desafioquality.dto.RoomWithSizeDTO;
import com.br.meli.desafioquality.model.House;
import com.br.meli.desafioquality.model.Room;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@AllArgsConstructor
public class HouseServiceImpl implements HouseService {
    private HouseConverter houseConverter;

    @Override
    public PropertySizeDTO getHouseSize(HouseDTO houseDTO) throws Exception {
        House house = houseConverter.fromRequestToEntity(houseDTO);
        return new PropertySizeDTO(house.getTotalSize());
    }

    public Double getHouseValue(HouseDTO houseDTO) throws Exception {
        House house = houseConverter.fromRequestToEntity(houseDTO);
        return house.getValue();
    }

    public Room getBiggestRoom(HouseDTO houseDTO) throws Exception {
        House house = houseConverter.fromRequestToEntity(houseDTO);
        return house.getBiggestRoom();
    }

    @Override
    public List<RoomWithSizeDTO> getSizeOfEachRoom(HouseDTO houseDTO) throws Exception {
        House house = houseConverter.fromRequestToEntity(houseDTO);

        return null;
    }

}
