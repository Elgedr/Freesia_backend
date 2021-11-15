package com.freesia.server.controllers;


import com.freesia.server.models.Flight;
import com.freesia.server.repositories.FlightRepository;
import com.freesia.server.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RequestMapping("/api/freesia")
@RestController
public class ExampleController {

    @Autowired
    private FlightService flightService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Flight>> hello() {
        List<Flight> flights = flightService.findAll();
        return ResponseEntity.ok(flights);
    }
}
