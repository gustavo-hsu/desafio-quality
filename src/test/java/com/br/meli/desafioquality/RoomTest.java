package com.br.meli.desafioquality;

import com.br.meli.desafioquality.model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoomTest {

    @Test
    void shouldReturnRoomSize() {
        Room room = new Room("kitchen", 10.0, 20.0);
        Double expected = 200.0;

        Double result = room.getSize();

        assertEquals(expected, result);
    }
}
