package ru.guliaev.crud_app.service;

import ru.guliaev.crud_app.controller.dto.RoleDto;
import ru.guliaev.crud_app.controller.dto.StatusResponse;

import java.util.List;

public interface RoleService {

    RoleDto create(RoleDto roleDto);

    List<RoleDto> getAllRoles();

    RoleDto update(RoleDto roleDto, Long id);

    StatusResponse delete(Long id);

    StatusResponse deleteAll();

}
