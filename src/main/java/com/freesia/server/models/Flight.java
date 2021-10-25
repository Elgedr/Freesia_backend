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
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
@Table(name = "flight")
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String departurePlace;

    private LocalDateTime departureTime;

    private String destinationPlace;

    private LocalDateTime arrivalTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ship_id")
    private Ship ship;

    public Flight() {
    }

    public Flight(long id, String departurePlace, LocalDateTime departureTime, String destinationPlace, LocalDateTime arrivalTime) {
        this.id = id;
        this.departurePlace = departurePlace;
        this.departureTime = departureTime;
        this.destinationPlace = destinationPlace;
        this.arrivalTime = arrivalTime;
    }

}
