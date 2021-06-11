package com.br.meli.desafioquality.service;

import com.br.meli.desafioquality.dto.HouseDTO;
import com.br.meli.desafioquality.dto.PropertySizeDTO;
import com.br.meli.desafioquality.dto.RoomDTO;
import com.br.meli.desafioquality.dto.RoomWithSizeDTO;
import com.br.meli.desafioquality.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseService {

    PropertySizeDTO getHouseSize(HouseDTO house) throws Exception;

    Double getHouseValue(HouseDTO house) throws Exception;

    Room getBiggestRoom(HouseDTO house) throws Exception;

    List<RoomWithSizeDTO> getSizeOfEachRoom(HouseDTO house) throws Exception;
}
