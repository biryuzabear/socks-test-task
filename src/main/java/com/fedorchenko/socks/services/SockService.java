package com.fedorchenko.socks.services;

import com.fedorchenko.socks.entities.SockEntity;
import com.fedorchenko.socks.exceptions.BadParamsException;
import com.fedorchenko.socks.repos.SockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SockService {

    @Autowired
    SockRepo sockRepo;

    public SockEntity income(SockEntity sockEntity) {
        SockEntity sockInDb = sockRepo.findByColorAndCottonPart(sockEntity.getColor(), sockEntity.getCottonPart());
        if (sockInDb != null)
            sockEntity.setQuantity(sockInDb.getQuantity() + sockEntity.getQuantity());
        return sockRepo.save(sockEntity);
    }

    public SockEntity outcome(SockEntity sockEntity) throws BadParamsException {
        SockEntity sockInDb = sockRepo.findByColorAndCottonPart(sockEntity.getColor(), sockEntity.getCottonPart());
        if (sockInDb == null) throw new BadParamsException("There is no such socks!");
        else if (sockInDb.getQuantity() < sockEntity.getQuantity())
            throw new BadParamsException("You can't take more socks than you have!");

        sockEntity.setQuantity(sockInDb.getQuantity() - sockEntity.getQuantity());
        return sockRepo.save(sockEntity);
    }
}
