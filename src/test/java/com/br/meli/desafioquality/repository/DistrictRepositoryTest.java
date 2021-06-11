package com.br.meli.desafioquality.repository;

import com.br.meli.desafioquality.exceptions.DistrictNotFoundException;
import com.br.meli.desafioquality.model.District;
import com.br.meli.desafioquality.model.Property;
import com.br.meli.desafioquality.model.Room;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DistrictRepositoryTest {

    District district1 = new District("DistrictTest", 12.0);
    District district2 = new District("TestDistrict", 100.0);
    private List<District> districts = Arrays.asList(district1, district2);

    private DistrictRepository districtRepository = new DistrictRepository(districts);

    @Test
    void shouldReturnDistrictWithPricePerSquareMeterWhenItIsPresent() throws Exception {
        District result = districtRepository.findByName("DistrictTest");
        District secondResult = districtRepository.findByName("TestDistrict");

        assertEquals(12.0, result.getPricePerSquareMeter());
        assertEquals(100.0, secondResult.getPricePerSquareMeter());
    }

    @Test
    void shouldThrowExceptionWhenDistrictNotFound() {
        assertThrows(DistrictNotFoundException.class, () -> districtRepository.findByName("NoExistentDistrict"));
    }
}
