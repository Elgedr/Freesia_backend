package com.freesia.server;

import com.freesia.server.models.Flight;
import com.freesia.server.models.Place;
import com.freesia.server.models.Ship;
import com.freesia.server.repositories.FlightRepository;
import com.freesia.server.repositories.PassengerRepository;
import com.freesia.server.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

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

        Flight moon = new Flight(1L, "Earth", sqlTimestamp, "Moon", arrival);
        Flight sun = new Flight(2L, "Earth", sqlTimestamp, "Sun", arrival);
        Flight jupiter = new Flight(3L, "Earth", sqlTimestamp, "Jupiter", arrival);

        Ship ship1 = new Ship(1, "RS-329", 10);
        Ship ship2 = new Ship(2,"M-238", 10);
        Ship ship3 = new Ship(3, "COV-2019", 15);


//        Passenger passengerJulia = new Passenger(1, "Julia", "Djomina", "julia.djomina@gmail.com", "58078808");
//        Passenger passengerEllina = new Passenger(2, "Ellina", "Gedrojets", "ellina.gedrojets@gmail.com", "55555555");
//        Passenger passengerErika = new Passenger(3, "Erika", "Maksimova", "erika.maksimova@gmail.com", "52222222");
//        List<Passenger> passengers = List.of(passengerJulia, passengerErika, passengerEllina);
//
        Place firstPlace = new Place(1, "Econom", 10, 1);
        Place secondPlace = new Place(2,  "Econom", 10, 2);
        Place thirdPlace = new Place(3, "Econom", 10, 3);
        Place fourthPlace = new Place(3, "Econom", 10, 3);

        ship1.addPlace(firstPlace);
        shipRepository.save(ship1);
//        List<Flight> flights = List.of(moon, sun, jupiter);
//        flightRepository.saveAll(flights);
//        passengerRepository.saveAll(passengers);
//        shipRepository.saveAll(ships);
    }
}
