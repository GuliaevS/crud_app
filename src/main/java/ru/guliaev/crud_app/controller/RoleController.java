package ru.guliaev.crud_app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.guliaev.crud_app.controller.dto.RoleDto;
import ru.guliaev.crud_app.controller.dto.UpdateRoleRequest;
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
     * @param roleDto
     * @return статус
     */
    @PostMapping("/create")
    public StatusResponse create(@RequestBody RoleDto roleDto) {
        return roleServiceImp.create(roleDto);
    }

    /**
     * Получение списка всех ролей
     *
     * @return Список всех ролей
     */
    @GetMapping("/findAll")
    public List<RoleDto> findAll() {
        return roleServiceImp.getAllRoles();
    }

    /**
     * Изменение существующей роли
     *
     * @param updateRoleRequest данные на обновление
     * @return статус
     */
    @PostMapping("/update")
    public StatusResponse update(@RequestBody UpdateRoleRequest updateRoleRequest) {
        return roleServiceImp.update(updateRoleRequest);
    }

    /**
     * Удаление роли по id
     *
     * @param id
     * @return статус
     */
    @DeleteMapping("/delete/{id}")
    public StatusResponse delete(@PathVariable Long id) {
        return roleServiceImp.delete(id);
    }

    /**
     * Удаление всех ролей
     *
     * @return статус
     */
    @DeleteMapping("/deleteAll")
    public StatusResponse deleteAll() {
        return roleServiceImp.deleteAll();
    }
}
