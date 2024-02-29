package ru.guliaev.crud_app.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.guliaev.crud_app.entity.Client;
import ru.guliaev.crud_app.entity.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {

    /**
     * Клиент
     */
    private Client client;

    /**
     * Роль
     */
    private Role role;

    /**
     * Id роли
     */
    private Long role_id;
}
