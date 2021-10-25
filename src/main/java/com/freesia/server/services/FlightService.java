package com.freesia.server.services;

import com.freesia.server.models.Flight;
import com.freesia.server.models.Ship;
import com.freesia.server.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public Long count() {
        return flightRepository.count();
    }

    public void deleteById(Long flightId) {

        flightRepository.deleteById(flightId);
    }

    public void saveAll(List<Flight> flights) {
        flightRepository.saveAll(flights);
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }


    // a
}
