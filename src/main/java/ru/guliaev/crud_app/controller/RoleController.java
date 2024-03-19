package ru.guliaev.crud_app.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.guliaev.crud_app.controller.dto.RoleDto;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
import ru.guliaev.crud_app.service.imp.RoleServiceImp;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/role")
public class RoleController {

    private final RoleServiceImp roleServiceImp;

    /**
     * Создание новой роли
     *
     * @param roleDto Новая роль
     * @return roleDto
     */
    @PostMapping("/create")
    public RoleDto create(@Valid @RequestBody RoleDto roleDto) {
        log.info("[API] start create new role {}", roleDto);
        return roleServiceImp.create(roleDto);
    }

    /**
     * Получение списка всех ролей
     *
     * @return Список всех ролей
     */
    @GetMapping("/findAll")
    public List<RoleDto> findAll() {
        log.info("[API] start find all roles");
        return roleServiceImp.getAllRoles();
    }

    /**
     * Изменение существующей роли
     *
     * @param roleDto данные на обновление
     * @param id      роли
     * @return roleDto
     */
    @PostMapping("/update/{id}")
    public RoleDto update(@RequestBody RoleDto roleDto, @PathVariable Long id) {
        log.info("[API] start update role {}", roleDto);
        return roleServiceImp.update(roleDto, id);
    }

    /**
     * Удаление роли по id
     *
     * @param id роли
     * @return статус
     */
    @DeleteMapping("/delete/{id}")
    public StatusResponse delete(@PathVariable Long id) {
        log.info("[API] start delete role_id {}", id);
        return roleServiceImp.delete(id);
    }

    /**
     * Удаление всех ролей
     *
     * @return статус
     */
    @DeleteMapping("/deleteAll")
    public StatusResponse deleteAll() {
        log.info("[API] start delete all roles");
        return roleServiceImp.deleteAll();
    }
}
