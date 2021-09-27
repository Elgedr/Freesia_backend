package com.freesia.server.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int num_of_places;
//    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL)
//    private List<Place> placeList;

    public Ship(long id, String name, int num_of_places) {
        this.id = id;
        this.name = name;
        this.num_of_places = num_of_places;
    }

    protected Ship() {
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
