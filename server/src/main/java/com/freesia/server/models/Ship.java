package com.freesia.server.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;
    private String name;
    private int num_of_places;
    @OneToMany(mappedBy = "ship")
    private List<Place> places;

    protected Ship() {
    }

    public Ship(long id, Flight flight, String name, int num_of_places) {
        this.id = id;
        this.flight = flight;
        this.name = name;
        this.num_of_places = num_of_places;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
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
