package com.fedorchenko.socks.repos;

import com.fedorchenko.socks.entities.SockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SockRepo extends JpaRepository<SockEntity, String> {
    Optional<SockEntity> findByColorAndCottonPartEquals(String color, Integer cottonPart);

    List<SockEntity> findAllByColorAndCottonPartLessThan(String color, Integer cottonPart);

    List<SockEntity> findAllByColorAndCottonPartGreaterThan(String color, Integer cottonPart);
}