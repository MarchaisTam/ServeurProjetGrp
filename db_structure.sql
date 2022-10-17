CREATE DATABASE stations_api_db;
USE stations_api_db;

CREATE TABLE bike_station (
	id INT auto_increment PRIMARY KEY not null,
    name NVARCHAR(256) not null,
    address VARCHAR(512),
	lat DOUBLE not null,
    lon DOUBLE not null,
    banking BOOLEAN,
    stands INT,
    available_stands INT,
    available_bikes INT,
    status VARCHAR(128),
    last_update BIGINT
)ENGINE=InnoDB;
