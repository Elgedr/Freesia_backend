package com.freesia.server.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ship")
@Getter
@Setter
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "num_of_places")
    private Integer numOfPlaces;

    @Column(name = "num_of_available_places")
    private Integer numOfAvailablePlaces;

    public Ship() {
    }

    public Ship(long id, String name, int numOfPlaces, int numOfAvailablePlaces) {
        this.id = id;
        this.name = name;
        this.numOfPlaces = numOfPlaces;
        this.numOfAvailablePlaces = numOfAvailablePlaces;
    }

}
