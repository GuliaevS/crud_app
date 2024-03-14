package ru.guliaev.crud_app.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {
    /**
     * Имя
     */
    private String name;

    /**
     * Фамилия
     */
    private String surname;

    /**
     * День рождения
     */
    private LocalDate birthday;

    /**
     * Номер телефона
     */
    private String phoneNumber;

    /**
     *
     */
    private String nameOfRole;
}
