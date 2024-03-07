package ru.guliaev.crud_app.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
     * @param roleDto данные на обновление
     * @param id роли
     * @return roleDto
     */
    @PostMapping("/update")
    public RoleDto update(@Valid @RequestBody RoleDto roleDto, @NotBlank Long id) {
        return roleServiceImp.update(roleDto, id);
    }

    /**
     * Удаление роли по id
     *
     * @param id
     * @return статус
     */
    @DeleteMapping("/delete/{id}")
    public StatusResponse delete(@NotBlank @PathVariable Long id) {
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
