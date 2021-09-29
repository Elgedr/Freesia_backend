package com.freesia.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long id;
    public String passenger_name;
    public String passenger_surname;
    public String email;
    public String telephone;

    public Passenger() {
    }

    public Passenger(long id, String name, String passenger_surname, String email, String telephone) {
        this.id = id;
        this.passenger_name = name;
        this.passenger_surname = passenger_surname;
        this.email = email;
        this.telephone = telephone;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getPassenger_surname() {
        return passenger_surname;
    }

    public void setPassenger_surname(String passenger_surname) {
        this.passenger_surname = passenger_surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
