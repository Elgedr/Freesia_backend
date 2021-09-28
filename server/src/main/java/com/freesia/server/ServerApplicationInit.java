//package com.freesia.server;
//
//import com.freesia.server.models.Ship;
//import com.freesia.server.repositories.ShipRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class ServerApplicationInit implements CommandLineRunner {
//    @Autowired
//    protected ShipRepository shipRepository;
//
//    @Override
//    public void run(String... args) {
//        List<Ship> ships = List.of(
//                new Ship(1, "Julia", 10),
//                new Ship(2, "Ellina", 10),
//                new Ship(3, "Erika", 2000000)
//        );
//        shipRepository.saveAll(ships);
//    }
//}
