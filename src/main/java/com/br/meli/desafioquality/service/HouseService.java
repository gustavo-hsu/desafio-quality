package com.br.meli.desafioquality.service;

import com.br.meli.desafioquality.dto.HouseDTO;
import com.br.meli.desafioquality.model.House;
import com.br.meli.desafioquality.model.Room;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface HouseService {

    Double getHouseSize(HouseDTO house) throws Exception;

    Double getHouseValue(HouseDTO house) throws Exception;

    Room getBiggestRoom(HouseDTO house) throws Exception;

    HashMap<String, Double> getTotalSizeByRoom(House house);
}
