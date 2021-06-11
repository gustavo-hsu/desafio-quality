package com.br.meli.desafioquality.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler{
    @ExceptionHandler(value = { MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleMethodArgumentNotValidEx(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(ex.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { DistrictNotFoundException.class})
    protected ResponseEntity<Object> handleDistrictNotFoundEx(DistrictNotFoundException ex) {
        return new ResponseEntity<>(ex.getDescription(), HttpStatus.NOT_FOUND);
    }
}