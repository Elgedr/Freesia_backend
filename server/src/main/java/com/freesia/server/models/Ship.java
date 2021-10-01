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
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "num_of_places")
    private int numOfPlaces;

    @Column(name = "num_of_available_places")
    private int numOfAvailablePlaces;

    protected Ship() {
    }

    public Ship(long id, String name, int numOfPlaces) {
        this.id = id;
        this.name = name;
        this.numOfPlaces = numOfPlaces;
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

    public void setNumOfPlaces(int num_of_places) {
        this.numOfPlaces = num_of_places;
    }
}
