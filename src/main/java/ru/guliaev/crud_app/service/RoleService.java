package ru.guliaev.crud_app.service;

import ru.guliaev.crud_app.controller.dto.RoleDto;
import ru.guliaev.crud_app.controller.dto.UpdateRoleRequest;
import ru.guliaev.crud_app.controller.dto.StatusResponse;

import java.util.List;

public interface RoleService {

    StatusResponse create(RoleDto roleDto);

    List<RoleDto> getAllRoles();

    StatusResponse update(UpdateRoleRequest updateRoleRequest);

    StatusResponse delete (Long id);

    StatusResponse deleteAll();

}
