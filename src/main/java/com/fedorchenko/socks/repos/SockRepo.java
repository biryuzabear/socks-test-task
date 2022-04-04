package com.fedorchenko.socks.repos;

import com.fedorchenko.socks.entities.SockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SockRepo extends JpaRepository<SockEntity, String> {
    public SockEntity findByColorAndCottonPart(String color, Integer cottonPart);
    public List<SockEntity> findByColor(String color);
}