package com.freesia.server.controllers;

import com.freesia.server.models.Flight;
import com.freesia.server.models.Ship;
import com.freesia.server.services.FlightService;
import com.freesia.server.services.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("flights")
@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> flights() {
        return flightService.findAll();
    }

    @GetMapping("/{id}")
    public Flight flightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @PostMapping("/create")
    public void saveFlight(@RequestBody Flight flight) {
         flightService.saveFlight(flight);
    }


}
