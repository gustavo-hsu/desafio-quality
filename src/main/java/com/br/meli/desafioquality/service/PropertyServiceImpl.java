package com.br.meli.desafioquality.service;

import com.br.meli.desafioquality.dto.PropertyDTO;
import com.br.meli.desafioquality.dto.PropertySizeDTO;
import com.br.meli.desafioquality.dto.PropertyValueDTO;
import com.br.meli.desafioquality.dto.RoomWithSizeDTO;
import com.br.meli.desafioquality.model.Property;
import com.br.meli.desafioquality.model.Room;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private PropertyConverter propertyConverter;

    @Override
    public PropertySizeDTO getPropertySize(PropertyDTO propertyDTO) throws Exception {
        Property property = propertyConverter.fromRequestToEntity(propertyDTO);
        return new PropertySizeDTO(property.getTotalSize());
    }

    public PropertyValueDTO getPropertyValue(PropertyDTO propertyDTO) throws Exception {
        Property property = propertyConverter.fromRequestToEntity(propertyDTO);
        return new PropertyValueDTO(property.getValue());
    }

    public Room getBiggestRoom(PropertyDTO propertyDTO) throws Exception {
        Property property = propertyConverter.fromRequestToEntity(propertyDTO);
        return property.getBiggestRoom();
    }

    @Override
    public List<RoomWithSizeDTO> getSizeOfEachRoom(PropertyDTO propertyDTO) throws Exception {
        Property property = propertyConverter.fromRequestToEntity(propertyDTO);

        return null;
    }

}
