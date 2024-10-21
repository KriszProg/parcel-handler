--liquibase formatted sql

--changeset kovacskr:0001 context:prod
--comment: create initial table(s) for parcel-handler project

CREATE TABLE clients
(
   id               INT NOT NULL AUTO_INCREMENT,
   client_name      VARCHAR NOT NULL,
   address          VARCHAR NOT NULL,
   zip_code         VARCHAR NOT NULL,
   city             VARCHAR NOT NULL,
   phone            VARCHAR NOT NULL,
   email            VARCHAR NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE parcels
(
    id              INT NOT NULL AUTO_INCREMENT,
    sender_id       INT NOT NULL,
    receiver_id     INT NOT NULL,
    parcel_no       VARCHAR NOT NULL,
    PRIMARY KEY     (id),
    CONSTRAINT      fk_sender FOREIGN KEY (sender_id) REFERENCES clients (id),
    CONSTRAINT      fk_receiver FOREIGN KEY (receiver_id) REFERENCES clients (id)
);

CREATE TABLE events
(
    id              SMALLINT NOT NULL AUTO_INCREMENT,
    event_name      VARCHAR NOT NULL,
    PRIMARY KEY     (id)
);

CREATE TABLE trackings
(
    id              INT NOT NULL AUTO_INCREMENT,
    parcel_id       INT NOT NULL,
    event_date      TIMESTAMP NOT NULL,
    event_id        SMALLINT NOT NULL,
    PRIMARY KEY     (id),
    CONSTRAINT      fk_parcel FOREIGN KEY (parcel_id) REFERENCES parcels (id),
    CONSTRAINT      fk_event FOREIGN KEY (event_id) REFERENCES events (id)
);
