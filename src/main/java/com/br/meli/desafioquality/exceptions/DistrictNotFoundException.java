package com.br.meli.desafioquality.exceptions;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends ApiException {
    private final static String CODE = "NOT_FOUND";
    private final static Integer STATUS_CODE = HttpStatus.NOT_FOUND.value();

    public DistrictNotFoundException() {
        super(CODE, CODE, STATUS_CODE);
    }

    public DistrictNotFoundException(String description) {
        super(CODE, description, STATUS_CODE);
    }
}