CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    role VARCHAR(255)
);

CREATE TABLE clients_role
(
    client_id SERIAL,
    client_role SERIAL,
    client_id SERIAL REFERENCES clients (id)
);