package com.freesia.server.services;

import com.freesia.server.models.Ship;
import com.freesia.server.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return repository.findAll();
    }

    public Ship getTheShipById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteShip(Long id) {
        repository.deleteById(id);
    }

    public List<Ship> saveShips(List<Ship> ships) {
        return (List<Ship>) repository.saveAll(ships);
    }
    // a
}
