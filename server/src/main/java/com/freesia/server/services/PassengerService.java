package com.freesia.server.services;

import com.freesia.server.models.Reservation;
import com.freesia.server.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private final PassengerRepository repository;

    public PassengerService(PassengerRepository repository) {
        this.repository = repository;
    }

    public void savePassenger(Reservation reservation) {
        repository.save(reservation);
    }

    public void savePassengers(List<Reservation> reservations) {
         repository.saveAll(reservations);
    }

//
//    public List<Ship> getAllShips()
//    {
//        List<Ship> ships = new ArrayList<Ship>();
//        repository.findAll().forEach(ships::add);
//        return ships;
//    }
//    public Ship getTheShipById(Long id){
//        return repository.findById(id).orElse(null);
//    }
//
//    public String deleteShip(Long id)
//    {
//        repository.deleteById(id);
//        return "Ship is not available!";
//    }

}
