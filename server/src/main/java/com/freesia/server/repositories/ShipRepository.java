package com.freesia.server.repositories;

import com.freesia.server.models.Ship;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShipRepository extends PagingAndSortingRepository<Ship, Long> {
    Ship findByName(String name);
}
