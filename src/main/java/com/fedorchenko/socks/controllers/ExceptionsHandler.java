package com.fedorchenko.socks.controllers;

import com.fedorchenko.socks.exceptions.BadParamsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionsHandler {

    @ResponseBody
    @ExceptionHandler(BadParamsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String badParams(BadParamsException ex) {
        return ex.getMessage();
    }

}
