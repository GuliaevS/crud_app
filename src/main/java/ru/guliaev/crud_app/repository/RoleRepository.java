package ru.guliaev.crud_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.guliaev.crud_app.entity.Role;
import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByNameOfRole (String nameOfRole);

}
