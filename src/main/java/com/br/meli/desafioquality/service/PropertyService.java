package com.br.meli.desafioquality.service;

import com.br.meli.desafioquality.dto.PropertyDTO;
import com.br.meli.desafioquality.dto.PropertySizeDTO;
import com.br.meli.desafioquality.dto.PropertyValueDTO;
import com.br.meli.desafioquality.dto.RoomWithSizeDTO;
import com.br.meli.desafioquality.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService {

    PropertySizeDTO getPropertySize(PropertyDTO property) throws Exception;

    PropertyValueDTO getPropertyValue(PropertyDTO property) throws Exception;

    Room getBiggestRoom(PropertyDTO property) throws Exception;

    List<RoomWithSizeDTO> getSizeOfEachRoom(PropertyDTO property) throws Exception;
}
