CREATE TABLE Ship
(
    id            INT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(50)        NOT NULL,
    num_of_places INT                NOT NULL,
    CONSTRAINT pk_ship PRIMARY KEY (id)
);

CREATE TABLE Place
(
    id        INT AUTO_INCREMENT NOT NULL,
    type      VARCHAR(50)        NOT NULL,
    price     INT                NOT NULL,
    is_booked BOOLEAN DEFAULT FALSE,
    CONSTRAINT pk_place PRIMARY KEY (id)
);

CREATE TABLE Ship_Place_Combination
(
    ship_id  INT NOT NULL,
    place_id INT NOT NULL,
    CONSTRAINT pk_ship_place_combination PRIMARY KEY (ship_id, place_id),
    CONSTRAINT fk_ship_place_combination_ship_id FOREIGN KEY (ship_id) REFERENCES Ship (id),
    CONSTRAINT fk_ship_place_combination_place_id FOREIGN KEY (place_id) REFERENCES Place (id)
);


CREATE TABLE Ship_Places_Availability
(
    ship_id                 INT NOT NULL,
    num_of_available_places INT NOT NULL,
    CONSTRAINT fk_ship_places_availability_ship_id FOREIGN KEY (ship_id) REFERENCES Ship (id)
);

CREATE TABLE Reservation
(
    id                INT AUTO_INCREMENT NOT NULL,
    ship_id           INT                NOT NULL,
    place             INT                NOT NULL,
    passenger_name    VARCHAR(50)        NOT NULL,
    passenger_surname VARCHAR(50)        NOT NULL,
    email             VARCHAR(65)        NOT NULL,
    telephone         VARCHAR(8)         NOT NULL,
    CONSTRAINT pk_reservation PRIMARY KEY (id),
    CONSTRAINT fk_reservation_ship_id FOREIGN KEY (ship_id) REFERENCES Ship (id),
    CONSTRAINT uq_passenger_data UNIQUE (passenger_name, passenger_surname, email, telephone)
);

CREATE TABLE Flight
(
    id                INT AUTO_INCREMENT NOT NULL,
    ship_id           INT                NOT NULL,
    departure_place   VARCHAR(50)        NOT NULL,
    departure_time    TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP,
    destination_place VARCHAR(50)        NOT NULL,
    arrival_time      TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_flight PRIMARY KEY (id),
    CONSTRAINT fk_flight_ship_id FOREIGN KEY (ship_id) REFERENCES Ship (id)
);

