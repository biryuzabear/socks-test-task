package com.fedorchenko.socks.services;

import com.fedorchenko.socks.entities.SockEntity;
import com.fedorchenko.socks.exceptions.BadParamsException;
import com.fedorchenko.socks.repos.SockRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SockService {

    final
    SockRepo sockRepo;

    public SockService(SockRepo sockRepo) {
        this.sockRepo = sockRepo;
    }

    public SockEntity income(SockEntity sockEntity) {
        try {
            SockEntity sockInDb = sockRepo.findByColorAndCottonPartEquals(sockEntity.getColor(), sockEntity.getCottonPart()).orElseThrow();
            sockEntity.setQuantity(sockInDb.getQuantity() + sockEntity.getQuantity());
        } catch (NoSuchElementException ignored) {
        }
        return sockRepo.save(sockEntity);
    }

    public SockEntity outcome(SockEntity sockEntity) throws BadParamsException {
        SockEntity sockInDb = getSockByColorAndCottonPartEquals(sockEntity.getColor(), sockEntity.getCottonPart());
        if (sockInDb.getQuantity() < sockEntity.getQuantity())
            throw new BadParamsException("You can't take more socks than you have!");

        sockEntity.setQuantity(sockInDb.getQuantity() - sockEntity.getQuantity());
        return sockRepo.save(sockEntity);
    }

    public SockEntity getSockByColorAndCottonPartEquals(String color, Integer cottonPart) throws BadParamsException {
        return sockRepo.findByColorAndCottonPartEquals(color, cottonPart).orElseThrow(() -> new BadParamsException("There's no such socks!"));
    }

    public List<SockEntity> getSocksByColorAndCottonPartLessThan(String color, Integer cottonPart) {
        return sockRepo.findAllByColorAndCottonPartLessThan(color, cottonPart);
    }

    public List<SockEntity> getSocksByColorAndCottonPartMoreThan(String color, Integer cottonPart) {
        return sockRepo.findAllByColorAndCottonPartGreaterThan(color, cottonPart);
    }
}
