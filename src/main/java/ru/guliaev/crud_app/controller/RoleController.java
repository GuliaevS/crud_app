package ru.guliaev.crud_app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.guliaev.crud_app.controller.dto.RoleRequest;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
import ru.guliaev.crud_app.entity.Role;
import ru.guliaev.crud_app.service.imp.RoleServiceImp;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/role")
public class RoleController {
    private final RoleServiceImp roleServiceImp;

    /**
     * Создание новой роли
     * @param role Название роли
     * @return статус
     */
    @PostMapping("/create")
    public StatusResponse createRole(@RequestBody Role role) {
        return roleServiceImp.create(role);
    }

    /**
     * Присвоение роли определенному клиенту
     * @param roleRequest
     * @return статус
     */
    @PostMapping("/setRole/{role_id}")
    public StatusResponse setRole(@RequestBody RoleRequest roleRequest) {
        return roleServiceImp.set(roleRequest);
    }
}
