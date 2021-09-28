CREATE TABLE Flight
(
    id                INT AUTO_INCREMENT NOT NULL,
    departure_place   VARCHAR(50) NOT NULL,
    departure_time    TIMESTAMP   NOT NULL,
    destination_place VARCHAR(50) NOT NULL,
    arrival_time      TIMESTAMP   NOT NULL,
    CONSTRAINT pk_flight PRIMARY KEY (id)
);

CREATE TABLE Ship
(
    id            INT AUTO_INCREMENT NOT NULL,
    flight_id     INT         NOT NULL,
    name          VARCHAR(50) NOT NULL,
    num_of_places INT         NOT NULL,
    CONSTRAINT pk_ship PRIMARY KEY (id),
    CONSTRAINT fk_flight_id FOREIGN KEY (flight_id) REFERENCES Flight (id)
);

CREATE TABLE Place
(
    id           INT AUTO_INCREMENT NOT NULL,
    ship_id      INT         NOT NULL,
    passenger_id INT,
    type         VARCHAR(50) NOT NULL,
    price        INT         NOT NULL,
    place_num    INT         NOT NULL,
    CONSTRAINT pk_place PRIMARY KEY (id),
    CONSTRAINT fk_ship_id FOREIGN KEY (ship_id) REFERENCES Ship (id),
    CONSTRAINT fk_passenger_id FOREIGN KEY (passenger_id) REFERENCES Passenger (id)
);

CREATE TABLE Passenger
(
    id                INT AUTO_INCREMENT NOT NULL,
    passenger_name    VARCHAR(50) NOT NULL,
    passenger_surname VARCHAR(50) NOT NULL,
    email             VARCHAR(65) NOT NULL,
    telephone         VARCHAR(8)  NOT NULL,
    CONSTRAINT pk_reservation PRIMARY KEY (id),
    CONSTRAINT uq_passenger_data UNIQUE (passenger_name, passenger_surname, email, telephone)
);

