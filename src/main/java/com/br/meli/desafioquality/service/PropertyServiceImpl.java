package com.br.meli.desafioquality.service;

import com.br.meli.desafioquality.dto.PropertyDTO;
import com.br.meli.desafioquality.dto.PropertySizeDTO;
import com.br.meli.desafioquality.dto.PropertyValueDTO;
import com.br.meli.desafioquality.dto.RoomWithSizeDTO;
import com.br.meli.desafioquality.model.Property;
import com.br.meli.desafioquality.model.Room;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private PropertyConverterImpl propertyConverter;

    @Override
    public PropertySizeDTO getPropertySize(PropertyDTO propertyDTO) throws Exception {
        Property property = propertyConverter.fromDTOToEntity(propertyDTO);
        return new PropertySizeDTO(property.getTotalSize());
    }

    @Override
    public PropertyValueDTO getPropertyValue(PropertyDTO propertyDTO) throws Exception {
        Property property = propertyConverter.fromDTOToEntity(propertyDTO);
        return new PropertyValueDTO(property.getValue());
    }

    @Override
    public Room getBiggestRoom(PropertyDTO propertyDTO) throws Exception {
        Property property = propertyConverter.fromDTOToEntity(propertyDTO);
        return property.getBiggestRoom();
    }

    @Override
    public List<RoomWithSizeDTO> getSizeOfEachRoom(PropertyDTO propertyDTO) throws Exception {
        Property property = propertyConverter.fromDTOToEntity(propertyDTO);

        List<RoomWithSizeDTO> roomWithSizeDTOS = new ArrayList<>();

        for(Room room: property.getRooms()) {
            roomWithSizeDTOS.add(new RoomWithSizeDTO(room));
        }

        return roomWithSizeDTOS;
    }

}
