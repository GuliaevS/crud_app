package ru.guliaev.crud_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.guliaev.crud_app.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}