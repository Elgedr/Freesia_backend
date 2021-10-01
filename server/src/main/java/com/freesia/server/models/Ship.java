package com.freesia.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "num_of_places")
    private Integer numOfPlaces;

    @Column(name = "num_of_available_places")
    private Integer numOfAvailablePlaces;

    protected Ship() {
    }

    public Ship(long id, String name, int numOfPlaces, int numOfAvailablePlaces) {
        this.id = id;
        this.name = name;
        this.numOfPlaces = numOfPlaces;
        this.numOfAvailablePlaces = numOfAvailablePlaces;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfPlaces() {
        return numOfPlaces;
    }

    public void setNumOfPlaces(int numOfPlaces) {
        this.numOfPlaces = numOfPlaces;
    }

    public int getNumOfAvailablePlaces() {
        return numOfAvailablePlaces;
    }

    public void setNumOfAvailablePlaces(int numOfAvailablePlaces) {
        this.numOfAvailablePlaces = numOfAvailablePlaces;
    }
}
