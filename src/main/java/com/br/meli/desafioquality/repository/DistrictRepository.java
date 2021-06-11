package com.br.meli.desafioquality.repository;

import com.br.meli.desafioquality.exceptions.DistrictNotFoundException;
import com.br.meli.desafioquality.model.District;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


@Repository
@NoArgsConstructor
public class DistrictRepository {

    private District district1 = new District("Liberdade do bairro", 100.0);
    private District district2 = new District("Liberdade", 100.0);
    private List<District> districts = Arrays.asList(district1, district2);

    public District findByName(String name) throws Exception {
        for(District district: districts) {
            if(district.getName().equals(name))
                return district;
        }

        throw new DistrictNotFoundException("District " + name + " not found");
    }

    public DistrictRepository(List<District> districts) {
        this.districts =  districts;
    }
}
