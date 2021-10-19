package com.freesia.server.repositories;

import com.freesia.server.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.ship.id = :shipId")
    List<Flight> findFlightsByShipId(@Param("shipId") Long shipId);

}

