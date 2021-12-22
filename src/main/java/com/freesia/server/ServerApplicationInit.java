package com.freesia.server;

import com.freesia.server.models.ERole;
import com.freesia.server.models.Flight;
import com.freesia.server.models.Place;
import com.freesia.server.models.Role;
import com.freesia.server.models.Ship;
import com.freesia.server.models.User;
import com.freesia.server.repositories.FlightRepository;
import com.freesia.server.repositories.ReservationRepository;
import com.freesia.server.repositories.RoleRepository;
import com.freesia.server.repositories.ShipRepository;
import com.freesia.server.repositories.UserRepository;
import com.freesia.server.services.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ServerApplicationInit implements CommandLineRunner {
    @Autowired
    protected ShipRepository shipRepository;
    @Autowired
    protected FlightRepository flightRepository;
    @Autowired
    protected ReservationRepository reservationRepository;
    @Autowired
    protected RoleRepository roleRepository;
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    private ShipService shipService;

    @Override
    public void run(String... args) {
        Role admin = new Role(1, ERole.ROLE_ADMIN);
        Role user = new Role(2, ERole.ROLE_USER);
        Role guest = new Role(3, ERole.ROLE_GUEST);
        roleRepository.saveAll(List.of(admin, user, guest));

//        User admin1 = new User("erika", "erika.maksimova@gmail.com", "123456");
//        Set<Role> roles = new HashSet<>();
//        roles.add(admin);
//        admin1.setRoles(roles);
//        userRepository.save(admin1);

        Ship ship1 = new Ship(1L, "RS-329", 3, 3);
        Ship ship2 = new Ship(2L, "M-238", 3, 3);
        Ship ship3 = new Ship(3L, "COV-2019", 3, 3);
        Ship ship4 = new Ship(4L, "GO", 3, 3);
        Ship ship5 = new Ship(5L, "POSEIDON", 3, 3);
        Ship ship6 = new Ship(6L, "OLYMPIA-1", 3, 3);
        Ship ship7 = new Ship(7L, "TALTECH", 2, 2);
        Ship ship8 = new Ship(8L, "DESTINY", 2, 2);
        shipRepository.saveAll(List.of(ship1, ship2, ship3, ship4, ship5, ship6, ship7, ship8));



        LocalDateTime date1 = LocalDateTime.of(2022, Month.FEBRUARY, 12, 16, 30);
        LocalDateTime date11 = LocalDateTime.of(2022, Month.FEBRUARY, 12, 22, 28);

        LocalDateTime date2 = LocalDateTime.of(2022, Month.MARCH, 9, 19, 0);
        LocalDateTime date22 = LocalDateTime.of(2022, Month.MARCH, 9, 23, 30);

        LocalDateTime date3 = LocalDateTime.of(2022, Month.JULY, 1, 15, 45);
        LocalDateTime date33 = LocalDateTime.of(2022, Month.JULY, 1, 18, 18);

        LocalDateTime date4 = LocalDateTime.of(2023, Month.NOVEMBER, 29, 23, 59);
        LocalDateTime date44 = LocalDateTime.of(2023, Month.NOVEMBER, 30, 4, 11);

        LocalDateTime date5 = LocalDateTime.of(2025, Month.DECEMBER, 19, 0, 0);
        LocalDateTime date55 = LocalDateTime.of(2025, Month.DECEMBER, 19, 5, 40);

        LocalDateTime date6 = LocalDateTime.of(2030, Month.SEPTEMBER, 10, 4, 20);
        LocalDateTime date66 = LocalDateTime.of(2030, Month.SEPTEMBER, 10, 6, 20);

        LocalDateTime date7 = LocalDateTime.of(2022, Month.FEBRUARY, 19, 16, 30);
        LocalDateTime date77 = LocalDateTime.of(2022, Month.FEBRUARY, 19, 22, 28);

        LocalDateTime date8 = LocalDateTime.of(2022, Month.MAY, 20, 11, 30);
        LocalDateTime date88 = LocalDateTime.of(2022, Month.MAY, 20, 15, 28);

        LocalDateTime date9 = LocalDateTime.of(2022, Month.SEPTEMBER, 1, 16, 30);
        LocalDateTime date99 = LocalDateTime.of(2022, Month.SEPTEMBER, 1, 20, 28);

        LocalDateTime date10= LocalDateTime.of(2022, Month.OCTOBER, 15, 16, 30);
        LocalDateTime date101 = LocalDateTime.of(2022, Month.OCTOBER, 14, 22, 28);

        LocalDateTime date111 = LocalDateTime.of(2022, Month.NOVEMBER, 4, 10, 20);
        LocalDateTime date1111 = LocalDateTime.of(2022, Month.NOVEMBER, 4, 15, 28);

        LocalDateTime date12 = LocalDateTime.of(2022, Month.AUGUST, 3, 18, 30);
        LocalDateTime date121 = LocalDateTime.of(2022, Month.SEPTEMBER, 12, 20, 45);

        Flight moon = new Flight(1L, "Tallinn", date1, "Moon", date11);


        Flight mercury = new Flight(2L, "Tallinn", date2, "Mercury", date22);

        Flight jupiter = new Flight(3L, "Tallinn", date3, "Jupiter", date33);


        Flight mars = new Flight(4L, "Tallinn", date4, "Mars", date44);

        Flight saturn = new Flight(5L, "Tallinn", date5, "Saturn", date55);


        Flight uranus = new Flight(6L, "Tallinn", date6, "Uranus", date66);

        Flight neptune = new Flight(7L, "Tallinn", date8, "Neptune", date88);

        Flight moon1 = new Flight(8L, "Tallinn", date7, "Moon", date77);


        Flight mercury1 = new Flight(9L, "Tallinn", date9, "Mercury", date99);


        Flight jupiter1 = new Flight(10L, "Tallinn", date10, "Jupiter", date101);


        Flight mars1 = new Flight(11L, "Tallinn", date111, "Mars", date1111);

        Flight saturn1 = new Flight(12L, "Tallinn", date12, "Saturn", date121);


        moon.setShip(ship1);
        mercury.setShip(ship2);
        jupiter.setShip(ship3);
        saturn.setShip(ship4);
        uranus.setShip(ship5);
        neptune.setShip(ship6);
        moon1.setShip(ship7);
        mercury1.setShip(ship8);
        jupiter1.setShip(ship2);
        mars1.setShip(ship2);
        saturn1.setShip(ship1);

        List<Flight> flights = List.of(moon, mercury, jupiter, saturn, uranus, neptune, moon1, mercury1, jupiter1, mars1, saturn1);
        flightRepository.saveAll(flights);
    }
}
