package com.br.meli.desafioquality.model;

import com.br.meli.desafioquality.model.District;
import com.br.meli.desafioquality.model.Property;
import com.br.meli.desafioquality.model.Room;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PropertyTest {

    @Test
    void shouldReturnPropertySize() {
        Property property = createProperty();
        Double expectedSize = 200.0;

        Double resultSize = property.getTotalSize();

        assertEquals(expectedSize, resultSize);
    }

    @Test
    void shouldReturnPropertyValue() {
        Property property = createProperty();
        Double expectedValue = 1000.0;

        Double resultValue = property.getValue();

        assertEquals(expectedValue, resultValue);
    }

    @Test
    void shouldReturnBiggestRoom() {
        Room room1 = new Room("room1", 10.0, 10.0);
        Room room2 = new Room("room2", 12.0, 10.0);
        Room room3 = new Room("room3", 10.0, 5.0);
        Property property = new Property("Name", Lists.newArrayList(room1, room2, room3));
        Room expectedRoom = room2;

        Room resultRoom = property.getBiggestRoom();

        assertEquals(expectedRoom, resultRoom);
    }

    private Property createProperty() {
        Room room1 = new Room("room1", 10.0, 10.0);
        Room room2 = new Room("room2", 10.0, 5.0);
        Room room3 = new Room("room3", 10.0, 5.0);
        District district = new District("district", 5.0);

        Property property = new Property("Name", Lists.newArrayList(room1, room2, room3), district);

        return property;
    }
}
