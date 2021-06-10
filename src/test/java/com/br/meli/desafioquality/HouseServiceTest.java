package com.br.meli.desafioquality;

import com.br.meli.desafioquality.dto.HouseDTO;
import com.br.meli.desafioquality.dto.RoomDTO;
import com.br.meli.desafioquality.model.District;
import com.br.meli.desafioquality.model.Room;
import com.br.meli.desafioquality.repository.DistrictRepository;
import com.br.meli.desafioquality.service.HouseService;
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
public class HouseServiceTest {

    @Autowired
    HouseService houseService;

    @MockBean
    DistrictRepository districtRepository;

    @Test
    void shouldReturnHouseSize() throws Exception {
        HouseDTO house = createHouseDTO();
        Double expectedSize = 300.0;

        Double resultSize = houseService.getHouseSize(house);

        assertEquals(expectedSize, resultSize);
    }

    @Test
    void shouldReturnHouseValue() throws Exception {
        when(districtRepository.findByName(any())).thenReturn(new District("mock", 10.0));
        HouseDTO house = createHouseDTO();
        Double expected = 3000.0;

        Double result= houseService.getHouseValue(house);

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnBiggestRoom() throws Exception {
        HouseDTO house = createHouseDTO();
        Room expected = new Room("dormRoom", 20.0, 10.0);

        Room result = houseService.getBiggestRoom(house);

        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }

    private HouseDTO createHouseDTO() {
        RoomDTO room = new RoomDTO("kitchen", 10.0, 10.0);
        RoomDTO room2 = new RoomDTO("dormRoom", 20.0, 10.0);
        List<RoomDTO> rooms = Arrays.asList(room, room2);

        return new HouseDTO("My house name is beautiful", "Liberdade", rooms);
    }
}
