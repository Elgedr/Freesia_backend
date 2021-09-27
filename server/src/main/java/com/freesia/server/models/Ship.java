package com.freesia.server.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int num_of_places;

    public Ship(long id, String name, int num_of_places) {
        this.id = id;
        this.name = name;
        this.num_of_places = num_of_places;
    }

    public Ship() {
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

    public int getNum_of_places() {
        return num_of_places;
    }

    public void setNum_of_places(int num_of_places) {
        this.num_of_places = num_of_places;
    }
}
