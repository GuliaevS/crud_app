CREATE TABLE clients
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(255),
    surname      VARCHAR(255),
    birthday     DATE,
    phone_number VARCHAR(255)
);