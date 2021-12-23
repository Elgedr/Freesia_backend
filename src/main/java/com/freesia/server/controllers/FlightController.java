package com.freesia.server.controllers;

import com.freesia.server.models.Flight;
import com.freesia.server.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/flights")
@RestController

public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Flight>> flights() {
        return ResponseEntity.ok(flightService.findAll());
    }

    @GetMapping("/{id}")
    public Flight flightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }


}

