package com.freesia.server.controllers;

import com.freesia.server.models.Ship;
import com.freesia.server.services.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping({"/ships", "/ships/v12"})
@RestController
@CrossOrigin
public class ShipController {

    @Autowired
    private ShipService shipService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Ship>> ships() {
        return ResponseEntity.ok(shipService.getAllShips());
    }

    @GetMapping("{id}")
    public Ship ship(@PathVariable Long id) {
        return shipService.getTheShipById(id);
    }


}
