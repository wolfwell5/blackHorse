CREATE TABLE IF NOT EXISTS airplane_ticket
(
    company VARCHAR NOT NULL UNIQUE PRIMARY KEY,
    airplaneId VARCHAR NOT NULL,
    airplaneType VARCHAR NOT NULL,
    startTime TIMESTAMP NOT NULL,
    arriveTime TIMESTAMP NOT NULL,
    price VARCHAR NULL,
    locationFrom VARCHAR NOT NULL,
    locationTo VARCHAR NOT NULL,
)
