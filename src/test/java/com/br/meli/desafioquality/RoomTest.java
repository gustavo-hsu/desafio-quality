package com.br.meli.desafioquality;

import com.br.meli.desafioquality.model.District;
import com.br.meli.desafioquality.model.House;
import com.br.meli.desafioquality.model.Room;
import com.br.meli.desafioquality.service.HouseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoomTest {

    @Autowired
    HouseService houseService;


    @Test
    void shouldCalculateRoomSize() {
        Room room = new Room("kitchen", 10.0, 20.0);
        Double expected = 200.0;

        Double result = room.getSize();

        assertEquals(expected, result);
    }
}
