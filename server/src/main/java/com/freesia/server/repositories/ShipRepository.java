package com.freesia.server.repositories;

import com.freesia.server.models.Ship;
import org.springframework.data.repository.CrudRepository;

public interface ShipRepository extends CrudRepository<Ship, Long> {
    Ship findByName(String name);
}
