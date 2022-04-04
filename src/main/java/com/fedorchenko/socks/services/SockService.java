package com.fedorchenko.socks.services;

import com.fedorchenko.socks.entities.SockEntity;
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
            sockEntity.setQuantity(sockEntity.getQuantity() + sockInDb.getQuantity());
        return sockRepo.save(sockEntity);
    }

}
