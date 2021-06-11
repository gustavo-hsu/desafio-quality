package com.br.meli.desafioquality.service;

import com.br.meli.desafioquality.dto.*;
import com.br.meli.desafioquality.exceptions.DistrictNotFoundException;
import com.br.meli.desafioquality.model.District;
import com.br.meli.desafioquality.model.Property;
import com.br.meli.desafioquality.model.Room;
import com.br.meli.desafioquality.repository.DistrictRepository;
import com.br.meli.desafioquality.service.PropertyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PropertyServiceTest {

    @Autowired
    PropertyService propertyService;

    @MockBean
    DistrictRepository districtRepository;

    @Test
    void shouldReturnPropertySize() throws Exception {
        PropertyDTO property = createPropertyDTO();
        Double expectedSize = 300.0;

        PropertySizeDTO result = propertyService.getPropertySize(property);

        assertEquals(expectedSize, result.getPropertySize());
    }

    @Test
    void shouldReturnPropertyValueWhenDistrictExists() throws Exception {
        when(districtRepository.findByName(any())).thenReturn(new District("District", 10.0));
        PropertyDTO propertyDTO = createPropertyDTO();
        Double expected = 3000.0;

        PropertyValueDTO result = propertyService.getPropertyValue(propertyDTO);

        assertEquals(expected, result.getPropertyValue());
    }

    @Test
    void shouldThrowExceptionWhenDistrictNotFound() throws Exception {
        when(districtRepository.findByName(any())).thenThrow(new DistrictNotFoundException("District not found"));
        PropertyDTO propertyDTO = createPropertyDTO();

        assertThrows(DistrictNotFoundException.class, () -> propertyService.getPropertyValue(propertyDTO));
    }

    @Test
    void shouldReturnBiggestRoom() throws Exception {
        PropertyDTO property = createPropertyDTO();
        Room expected = new Room("dormRoom", 20.0, 10.0);

        Room result = propertyService.getBiggestRoom(property);

        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void shouldReturnTheSizeOfEachRoom() throws Exception {
        PropertyDTO property = createPropertyDTO();

        List<RoomWithSizeDTO> result = propertyService.getSizeOfEachRoom(property);

        assertEquals(100.0, result.get(0).getRoomSize());
        assertEquals(200.0, result.get(1).getRoomSize());
    }

    private PropertyDTO createPropertyDTO() {
        RoomDTO room = new RoomDTO("kitchen", 10.0, 10.0);
        RoomDTO room2 = new RoomDTO("dormRoom", 20.0, 10.0);
        List<RoomDTO> rooms = Arrays.asList(room, room2);

        return new PropertyDTO("My property name is beautiful", "Liberdade", rooms);
    }
}
