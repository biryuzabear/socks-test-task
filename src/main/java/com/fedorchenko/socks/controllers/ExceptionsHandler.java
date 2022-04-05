package com.fedorchenko.socks.controllers;

import com.fedorchenko.socks.exceptions.BadParamsException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

@ControllerAdvice
public class ExceptionsHandler {

    @ResponseBody
    @ExceptionHandler(BadParamsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String badParams(BadParamsException ex) {
        return ExceptionUtils.getStackTrace(ex);
    }

//    По умолчанию валидация от Spring выдает 500 ошибку при валидации параметров метода.
//    Поэтому было решено отлавливать их вручную и ставить более подходящий статус.

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    String exceptionHandler(ValidationException ex) {
        return ExceptionUtils.getStackTrace(ex);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    String exceptionHandler(ConstraintViolationException ex) {
        return ExceptionUtils.getStackTrace(ex);
    }

}
