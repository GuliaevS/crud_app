CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    role VARCHAR(255)
);

CREATE TABLE clients
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(255),
    surname      VARCHAR(255),
    birthday     DATE,
    phone_number VARCHAR(255),
    role_id SERIAL REFERENCES roles (id)
);