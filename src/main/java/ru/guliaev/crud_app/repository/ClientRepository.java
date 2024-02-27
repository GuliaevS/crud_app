package ru.guliaev.crud_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.guliaev.crud_app.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
