package com.freesia.server;

import com.freesia.server.models.Flight;
import com.freesia.server.models.Passenger;
import com.freesia.server.models.Place;
import com.freesia.server.models.Ship;
//import com.freesia.server.repositories.PassengerRepository;
import com.freesia.server.repositories.FlightRepository;
import com.freesia.server.repositories.PassengerRepository;
import com.freesia.server.repositories.ShipRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class ServerApplicationInit implements CommandLineRunner {
    @Autowired
    protected ShipRepository shipRepository;
    @Autowired
    protected FlightRepository flightRepository;
    @Autowired
    protected PassengerRepository passengerRepository;

    @Override
    public void run(String... args) {
        long now = System.currentTimeMillis();
        Timestamp sqlTimestamp = new Timestamp(now);

        long then = System.currentTimeMillis();
        Timestamp arrival = new Timestamp(then);

        Flight moon = new Flight(1, "Earth", sqlTimestamp, "Moon", arrival);
        Flight sun = new Flight(2, "Earth", sqlTimestamp, "Sun", arrival);
        Flight jupiter = new Flight(3, "Earth", sqlTimestamp, "Jupiter", arrival);

        List<Ship> ships = List.of(
                new Ship(1, moon, "RS-329", 10),
                new Ship(2, sun, "M-238", 10),
                new Ship(3, jupiter, "COV-2019", 15)
        );

        Passenger passengerJulia = new Passenger(1, "Julia", "Djomina", "julia.djomina@gmail.com", "58078808");
        Passenger passengerEllina = new Passenger(2, "Ellina", "Gedrojets", "ellina.gedrojets@gmail.com", "55555555");
        Passenger passengerErika = new Passenger(3, "Erika", "Maksimova", "erika.maksimova@gmail.com", "52222222");
        List<Passenger> passengers = List.of(passengerJulia, passengerErika, passengerEllina);

        Place firstPlace = new Place(1, ships.get(0), passengerJulia, "Econom", 10, 1);
        Place secondPlace = new Place(2, ships.get(0), passengerEllina, "Econom", 10, 2);
        Place thirdPlace = new Place(3, ships.get(0), passengerErika, "Econom", 10, 3);
        Place fourthPlace = new Place(3, ships.get(0), null, "Econom", 10, 3);
        List<Flight> flights = List.of(moon, sun, jupiter);
        flightRepository.saveAll(flights);
        passengerRepository.saveAll(passengers);
        shipRepository.saveAll(ships);
    }
}
