package com.br.meli.desafioquality.controller;

import com.br.meli.desafioquality.dto.PropertyDTO;
import com.br.meli.desafioquality.model.Property;
import com.br.meli.desafioquality.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/property")
public class PropertyController {
    private PropertyService propertyService;

    @PostMapping("/size")
    public ResponseEntity getPropertySize(@RequestBody @Valid PropertyDTO house) throws Exception {
        return new ResponseEntity (propertyService.getPropertySize(house), HttpStatus.OK);
    }

    @PostMapping("/value")
    public ResponseEntity getPropertyValue(@RequestBody @Valid PropertyDTO house) throws Exception {
        return new ResponseEntity (propertyService.getPropertyValue(house), HttpStatus.OK);
    }

    @PostMapping("/biggestRoom")
    public ResponseEntity getBiggestRoom(@RequestBody @Valid PropertyDTO house) throws Exception {
        return new ResponseEntity (propertyService.getBiggestRoom(house), HttpStatus.OK);
    }

    @PostMapping("/room/sizes")
    public void getTotalSizesByRoom(@RequestBody Property property) {
        //return houseService.getTotalSizeByRoom(house);
    }
}
