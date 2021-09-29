package com.freesia.server.services;

import com.freesia.server.models.Passenger;
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

    public Passenger savePassenger(Passenger passenger) {
        return repository.save(passenger);
    }

    public List<Passenger> savePassengers(List<Passenger> passengers) {
        return (List<Passenger>) repository.saveAll(passengers);
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
