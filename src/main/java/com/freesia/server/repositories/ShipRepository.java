package com.freesia.server.repositories;

import com.freesia.server.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ShipRepository extends JpaRepository<Ship, Long> {
}
