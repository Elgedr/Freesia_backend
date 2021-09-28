package com.freesia.server.controllers;

import com.freesia.server.models.Ship;
import com.freesia.server.services.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/ship")
@RestController
public class ShipController {

    @Autowired
    private ShipService shipService;

    @RequestMapping("/all")
    public List<Ship> ships() {
        return shipService.getAllShips();
    }

    @GetMapping("{id}")
    public Ship ship(@PathVariable Long id) {
        return shipService.getShipById(id);
    }
    @PostMapping
    public Ship saveHero(@RequestBody Ship ship) {
        return shipService.saveShip(ship);
    }

}
