package com.freesia.server.repositories;

import com.freesia.server.models.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
}

