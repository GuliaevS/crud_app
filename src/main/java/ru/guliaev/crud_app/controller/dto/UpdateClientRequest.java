package ru.guliaev.crud_app.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateClientRequest {
    /**
     * id клиента
     */
    private long id;

    /**
     * Клиент
     */
    private ClientDto clientDto;
}
