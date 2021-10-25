package com.freesia.server.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ship_id", referencedColumnName = "id")
    private Ship ship;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place place;

    public String passengerName;

    public String passengerSurname;

    public String email;

    public String telephone;

    public Reservation() {
    }

    public Reservation(long id, String passengerName, String passengerSurname, String email, String telephone) {
        this.id = id;
        this.passengerName = passengerName;
        this.passengerSurname = passengerSurname;
        this.email = email;
        this.telephone = telephone;
    }

}
