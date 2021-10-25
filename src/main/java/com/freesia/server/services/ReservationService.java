package com.freesia.server.services;

import com.freesia.server.models.Reservation;
import com.freesia.server.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private final ReservationRepository repository;


    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public void saveReservation(Reservation reservation) {
        repository.save(reservation);
    }

    public void saveReservation(List<Reservation> reservations) {
        repository.saveAll(reservations);
    }
// a
}
