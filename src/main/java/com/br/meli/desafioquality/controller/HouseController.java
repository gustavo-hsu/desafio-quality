package com.br.meli.desafioquality.controller;

import com.br.meli.desafioquality.dto.HouseDTO;
import com.br.meli.desafioquality.dto.PropertySizeDTO;
import com.br.meli.desafioquality.model.House;
import com.br.meli.desafioquality.service.HouseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("/house")
public class HouseController {
    private HouseService houseService;

    @PostMapping("/size")
    public ResponseEntity getTotalHouseSize(@RequestBody @Valid HouseDTO house) throws Exception {
        return new ResponseEntity (houseService.getHouseSize(house), HttpStatus.OK);
    }

    @PostMapping("/value")
    public ResponseEntity getHouseValue(@RequestBody @Valid HouseDTO house) throws Exception {
        return new ResponseEntity (houseService.getHouseValue(house), HttpStatus.OK);
    }

    @PostMapping("/biggestRoom")
    public ResponseEntity getBiggestRoom(@RequestBody @Valid HouseDTO house) throws Exception {
        return new ResponseEntity (houseService.getBiggestRoom(house), HttpStatus.OK);
    }

    @PostMapping("/room/sizes")
    public void getTotalSizesByRoom(@RequestBody House house) {
        //return houseService.getTotalSizeByRoom(house);
    }
}
