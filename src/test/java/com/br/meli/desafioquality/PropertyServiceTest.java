package com.br.meli.desafioquality;

import com.br.meli.desafioquality.dto.PropertyDTO;
import com.br.meli.desafioquality.dto.PropertySizeDTO;
import com.br.meli.desafioquality.dto.PropertyValueDTO;
import com.br.meli.desafioquality.dto.RoomDTO;
import com.br.meli.desafioquality.model.District;
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

        PropertySizeDTO resultSize = propertyService.getPropertySize(property);

        assertEquals(expectedSize, resultSize);
    }

    @Test
    void shouldReturnPropertyValue() throws Exception {
        when(districtRepository.findByName(any())).thenReturn(new District("mock", 10.0));
        PropertyDTO propertyDTO = createPropertyDTO();
        Double expected = 3000.0;

        PropertyValueDTO result = propertyService.getPropertyValue(propertyDTO);

        assertEquals(expected, result);
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
        //PropertyDTO property = createPropertyDTO();
        //Room expected = new Room("dormRoom", 20.0, 10.0);

        //List<RoomDTO> result = propertyService.getSizeOfEachRoom(property);

        //assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }

    private PropertyDTO createPropertyDTO() {
        RoomDTO room = new RoomDTO("kitchen", 10.0, 10.0);
        RoomDTO room2 = new RoomDTO("dormRoom", 20.0, 10.0);
        List<RoomDTO> rooms = Arrays.asList(room, room2);

        return new PropertyDTO("My property name is beautiful", "Liberdade", rooms);
    }
}
