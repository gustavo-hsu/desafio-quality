package com.br.meli.desafioquality.service;

import com.br.meli.desafioquality.dto.HouseDTO;
import com.br.meli.desafioquality.model.House;
import com.br.meli.desafioquality.model.Room;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@AllArgsConstructor
public class HouseServiceImpl implements HouseService {
    private HouseConverter houseConverter;
    @Override
    public Double getHouseSize(HouseDTO houseDTO) throws Exception {
        House house = houseConverter.fromRequestToEntity(houseDTO);

        return house.getTotalSize();
    }

    public Double getHouseValue(HouseDTO houseDTO) throws Exception {
        House house = houseConverter.fromRequestToEntity(houseDTO);
        return house.getValue();
    }

    public Room getBiggestRoom(HouseDTO houseDTO) throws Exception {
        House house = houseConverter.fromRequestToEntity(houseDTO);
        return house.getBiggestRoom();
    }

    public HashMap<String, Double> getTotalSizeByRoom(House house) {
        HashMap<String, Double> roomSizesHashMap = new HashMap<>();

        for (Room room: house.getRooms()) {
            roomSizesHashMap.put(room.getName(), room.getSize());
        }

        return roomSizesHashMap;
    }
}
