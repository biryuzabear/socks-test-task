package com.fedorchenko.socks.controllers;

import com.fedorchenko.socks.entities.SockEntity;
import com.fedorchenko.socks.exceptions.BadParamsException;
import com.fedorchenko.socks.services.SockService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/")
public class SockController {
    @Autowired
    SockService sockService;

    @GetMapping
    public List<SockEntity> getSock(@RequestParam String color, @RequestParam Integer cottonPart, @RequestParam String operation){
        // TODO: Написать логику контроллера с поиском носков
        return null;
    }


    @PostMapping
    public SockEntity income(@RequestBody SockEntity sockEntity) throws BadParamsException {
        if(sockEntity.hasEmptyFields()) throw new BadParamsException("Bad params!");
        return sockService.income(sockEntity);
    }

}
