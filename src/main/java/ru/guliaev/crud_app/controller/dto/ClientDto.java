package ru.guliaev.crud_app.controller.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @Min(2)
    private String name;

    /**
     * Фамилия
     */
    @Min(2)
    private String surname;

    /**
     * День рождения
     */
    @NotBlank
    private LocalDate birthday;

    /**
     * Номер телефона
     */
    @Max(10)
    private String phoneNumber;
}
