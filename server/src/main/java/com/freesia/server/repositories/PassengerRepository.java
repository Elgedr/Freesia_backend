package com.freesia.server.repositories;

import com.freesia.server.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Reservation, Long> {
}

