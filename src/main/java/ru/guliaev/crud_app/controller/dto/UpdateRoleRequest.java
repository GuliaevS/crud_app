package ru.guliaev.crud_app.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleRequest {
    /**
     * id роли
     */
    private long id;

    /**
     * Роль
     */
    private RoleDto roleDto;
}
