package com.freesia.server.services;

import com.freesia.server.models.Ship;
import com.freesia.server.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipService {
    @Autowired
    private final ShipRepository repository;

    public ShipService(ShipRepository repository) {
        this.repository = repository;
    }

    public Ship saveShip(Ship ship) {
        return repository.save(ship);
    }

    public List<Ship> getAllShips() {
        List<Ship> ships = new ArrayList<Ship>();
        repository.findAll().forEach(ships::add);
        return ships;
    }

    public Ship getTheShipById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteShip(Long id) {
        repository.deleteById(id);
        return "Ship is not available!";
    }

    public List<Ship> saveShips(List<Ship> ships) {
        return (List<Ship>) repository.saveAll(ships);
    }

}
