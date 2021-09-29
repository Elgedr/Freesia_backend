package com.freesia.server.services;

import com.freesia.server.models.Flight;
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

        var it = flightRepository.findAll();

        var flights = new ArrayList<Flight>();
        it.forEach(flights::add);

        return flights;
    }

    public Long count() {

        return flightRepository.count();
    }

    public void deleteById(Long flightId) {

        flightRepository.deleteById(flightId);
    }

    public List<Flight> saveAll(List<Flight> flights) {
        return (List<Flight>) flightRepository.saveAll(flights);
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public List<Flight> saveFlights(List<Flight> flights) {
        return (List<Flight>) flightRepository.saveAll(flights);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

}
