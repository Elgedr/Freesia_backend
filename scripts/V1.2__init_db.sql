CREATE SEQUENCE IF NOT EXISTS ship_id_seq START 1;

CREATE SEQUENCE IF NOT EXISTS place_id_seq START 1;

CREATE SEQUENCE IF NOT EXISTS reservation_id_seq START 1;

CREATE SEQUENCE IF NOT EXISTS flight_id_seq START 1;

CREATE TABLE ship
(
    id                      INTEGER DEFAULT nextval('ship_id_seq') NOT NULL,
    name                    VARCHAR(50)                            NOT NULL,
    num_of_places           INTEGER                                    NOT NULL,
    num_of_available_places INTEGER                                    NOT NULL,
    CONSTRAINT pk_ship PRIMARY KEY (id)
);

CREATE TABLE place
(
    id        INTEGER DEFAULT nextval('place_id_seq') NOT NULL,
    type      VARCHAR(50)                             NOT NULL,
    price     INTEGER                                     NOT NULL,
    is_booked BOOLEAN DEFAULT FALSE,
    CONSTRAINT pk_place PRIMARY KEY (id)
);

CREATE TABLE ship_place_combination
(
    ship_id  INTEGER NOT NULL,
    place_id INTEGER NOT NULL,
    CONSTRAINT pk_ship_place_combination PRIMARY KEY (ship_id, place_id),
    CONSTRAINT fk_ship_place_combination_ship_id FOREIGN KEY (ship_id) REFERENCES ship (id),
    CONSTRAINT fk_ship_place_combination_place_id FOREIGN KEY (place_id) REFERENCES place (id)
);


CREATE TABLE ship_places_availability
(
    ship_id                 INTEGER NOT NULL,
    num_of_available_places INTEGER NOT NULL,
    CONSTRAINT fk_ship_places_availability_ship_id FOREIGN KEY (ship_id) REFERENCES ship (id)
);

CREATE TABLE reservation
(
    id                INTEGER DEFAULT nextval('reservation_id_seq') NOT NULL,
    ship_id           INTEGER                                       NOT NULL,
    place_id          INTEGER                                       NOT NULL,
    passenger_name    VARCHAR(50)                                   NOT NULL,
    passenger_surname VARCHAR(50)                                   NOT NULL,
    email             VARCHAR(65)                                   NOT NULL,
    telephone         VARCHAR(8)                                    NOT NULL,
    CONSTRAINT pk_reservation PRIMARY KEY (id),
    CONSTRAINT fk_reservation_ship_id FOREIGN KEY (ship_id) REFERENCES ship (id),
    CONSTRAINT fk_reservation_place_id FOREIGN KEY (place_id) REFERENCES place (id),
    CONSTRAINT uq_passenger_data UNIQUE (passenger_name, passenger_surname, email, telephone)
);

CREATE TABLE flight
(
    id                INTEGER     DEFAULT nextval('flight_id_seq') NOT NULL,
    ship_id           INTEGER     NOT NULL,
    departure_place   VARCHAR(50) NOT NULL,
    departure_time    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    destination_place VARCHAR(50) NOT NULL,
    arrival_time      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_flight PRIMARY KEY (id),
    CONSTRAINT fk_flight_ship_id FOREIGN KEY (ship_id) REFERENCES ship (id)
);

CREATE VIEW v_ship AS
SELECT s.id,
       s.name,
       s.num_of_places,
       spa.num_of_available_places
FROM ship s
         RIGHT JOIN ship_places_availability spa on s.id = spa.ship_id;


