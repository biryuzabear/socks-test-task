package com.fedorchenko.socks.controllers;

import com.fedorchenko.socks.entities.SockEntity;
import com.fedorchenko.socks.exceptions.BadParamsException;
import com.fedorchenko.socks.services.SockService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import java.util.Collections;
import java.util.List;

@RestController
@Validated
public class SockController {
    final
    SockService sockService;

    public SockController(SockService sockService) {
        this.sockService = sockService;
    }

    @GetMapping
    public List<SockEntity> getSock(@RequestParam String color, @RequestParam @Min(0) @Max(100) Integer cottonPart, @RequestParam String operation) throws BadParamsException {
        switch (operation) {
            case "equal":
                return Collections.singletonList(sockService.getSockByColorAndCottonPartEquals(color, cottonPart));
            case "moreThan":
                return sockService.getSocksByColorAndCottonPartMoreThan(color, cottonPart);
            case "lessThan":
                return sockService.getSocksByColorAndCottonPartLessThan(color, cottonPart);
            default:
                throw new BadParamsException("There is no such operation!");
        }
    }

    @PostMapping("/income")
    public SockEntity income(@RequestBody @Valid SockEntity sockEntity) {
        return sockService.income(sockEntity);
    }

    @PostMapping("/outcome")
    public SockEntity outcome(@RequestBody @Valid SockEntity sockEntity) throws BadParamsException {
        return sockService.outcome(sockEntity);
    }

}
