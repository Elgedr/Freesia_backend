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
    public Ship saveShip(Ship ship){
        return repository.save(ship);
    }

    public List<Ship> getAllShips()
    {
        List<Ship> ships = new ArrayList<Ship>();
        repository.findAll().forEach(ship1 -> ships.add(ship1));
        return ships;
    }
    public Ship getShipById(Long id){
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id)
    {
        repository.deleteById(id);
    }
}
