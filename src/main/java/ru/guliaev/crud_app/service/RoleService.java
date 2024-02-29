package ru.guliaev.crud_app.service;

import ru.guliaev.crud_app.controller.dto.RoleRequest;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
import ru.guliaev.crud_app.entity.Role;

public interface RoleService {

    StatusResponse create(Role role);

    StatusResponse set(RoleRequest roleRequest);
}
