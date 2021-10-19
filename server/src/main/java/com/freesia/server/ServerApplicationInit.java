package com.freesia.server;

import com.freesia.server.models.Flight;
import com.freesia.server.models.Place;
import com.freesia.server.models.Reservation;
import com.freesia.server.models.Ship;
import com.freesia.server.repositories.FlightRepository;
import com.freesia.server.repositories.ReservationRepository;
import com.freesia.server.repositories.ShipRepository;
import com.freesia.server.services.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ServerApplicationInit implements CommandLineRunner {
    @Autowired
    protected ShipRepository shipRepository;
    @Autowired
    protected FlightRepository flightRepository;
    @Autowired
    protected ReservationRepository reservationRepository;

    @Autowired
    private ShipService shipService;

    @Override
    public void run(String... args) {
        LocalDateTime departure = LocalDateTime.now();

        LocalDateTime arrival = LocalDateTime.now();

        Flight moon = new Flight(1L, "Earth", departure, "Moon", arrival);
        Flight sun = new Flight(2L, "Earth", departure, "Sun", arrival);
        Flight jupiter = new Flight(3L, "Earth", departure, "Jupiter", arrival);

        Ship ship1 = new Ship(1, "RS-329", 10, 10);
        Ship ship2 = new Ship(2, "M-238", 10, 10);
        Ship ship3 = new Ship(3, "COV-2019", 15, 15);


        Reservation passengerJulia = new Reservation(1, "Julia", "Djomina", "julia.djomina@gmail.com", "58078808");
        Reservation passengerEllina = new Reservation(2, "Ellina", "Gedrojets", "ellina.gedrojets@gmail.com", "55555555");
        Reservation passengerErika = new Reservation(3, "Erika", "Maksimova", "erika.maksimova@gmail.com", "52222222");
        List<Reservation> reservations = List.of(passengerJulia, passengerErika, passengerEllina);

        Place firstPlace = new Place(1, "Econom", 10, 1);
        Place secondPlace = new Place(2, "Econom", 10, 2);
        Place thirdPlace = new Place(3, "Econom", 10, 3);
        Place fourthPlace = new Place(3, "Econom", 10, 3);

        moon.setShip(ship1);
        sun.setShip(ship2);
        jupiter.setShip(ship3);
        shipRepository.save(ship1);
        List<Flight> flights = List.of(moon, sun, jupiter);
        flightRepository.saveAll(flights);
//        passengerRepository.saveAll(passengers);
//        shipRepository.saveAll(ships);
        Ship shipFromDb = shipService.getTheShipById(1L);
        System.out.println(shipFromDb.getName());
    }
}
