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

@SpringBootTest
public class HouseControllerTest {

    @Autowired
    HouseService houseService;


    @Test
    void shouldReturnHouseTotalSize() {

    }
}
