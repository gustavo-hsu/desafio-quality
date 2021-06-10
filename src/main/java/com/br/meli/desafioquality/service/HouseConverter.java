package com.br.meli.desafioquality.service;

import com.br.meli.desafioquality.dto.HouseDTO;
import com.br.meli.desafioquality.model.District;
import com.br.meli.desafioquality.model.House;
import com.br.meli.desafioquality.model.Room;
import com.br.meli.desafioquality.repository.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HouseConverter {
    DistrictRepository districtRepository;

    public House fromRequestToEntity(HouseDTO houseDTO) throws Exception {
        District district = districtRepository.findByName(houseDTO.getPropDistrict());

        List<Room> rooms = houseDTO.getAllRooms();

        return new House(houseDTO.getPropName(), rooms, district);
    }

}
