package com.br.meli.desafioquality.service;

import com.br.meli.desafioquality.dto.PropertyDTO;
import com.br.meli.desafioquality.model.District;
import com.br.meli.desafioquality.model.Property;
import com.br.meli.desafioquality.model.Room;
import com.br.meli.desafioquality.repository.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PropertyConverter {
    DistrictRepository districtRepository;

    public Property fromRequestToEntity(PropertyDTO propertyDTO) throws Exception {
        District district = districtRepository.findByName(propertyDTO.getPropDistrict());

        List<Room> rooms = propertyDTO.getAllRooms();

        return new Property(propertyDTO.getPropName(), rooms, district);
    }
}
