package com.br.meli.desafioquality.service;

import com.br.meli.desafioquality.dto.PropertyDTO;
import com.br.meli.desafioquality.model.Property;

public interface PropertyConverter {
    Property fromDTOToEntity(PropertyDTO propertyDTO) throws Exception;
}
