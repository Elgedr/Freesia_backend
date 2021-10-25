package com.freesia.server.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "place")
@Getter
@Setter
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;

    private Integer price;

    private Integer isBooked;


    public Place() {
    }

    public Place(long id, String type, int price, int isBooked) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.isBooked = isBooked;
    }

}
