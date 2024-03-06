CREATE TABLE role
(
    id           SERIAL PRIMARY KEY,
    name_of_role VARCHAR(255)
);

CREATE TABLE client
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(255),
    surname      VARCHAR(255),
    birthday     DATE,
    phone_number VARCHAR(255),
    role_id      SERIAL REFERENCES role (id)
);

CREATE TABLE permissions
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
)