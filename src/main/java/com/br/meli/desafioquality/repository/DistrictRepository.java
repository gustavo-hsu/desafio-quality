package com.br.meli.desafioquality.repository;

import com.br.meli.desafioquality.model.District;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


@Repository
public class DistrictRepository {
    public District findByName(String name) throws Exception {
        District district1 = new District("Liberdade do bairro", 100.0);
        District district2 = new District("Liberdade", 100.0);
        List<District> districts = Arrays.asList(district1, district2);

        for(District district: districts) {
            if(district.getName().equals(name))
                return district;
        }

        throw new Exception("District not found");
    }
}
