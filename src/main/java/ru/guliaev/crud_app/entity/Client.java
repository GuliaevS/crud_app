package ru.guliaev.crud_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class Client {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Имя
     */
    @Column(name = "name")
    private String name;

    /**
     * Фамилия
     */
    @Column(name = "surname")
    private String surname;

    /**
     * День рождения
     */
    @Column(name = "birthday")
    //@DateTimeFormat(pattern = "dd MM yyyy")
    private LocalDate birthday;

    /**
     * Номер телефона
     */
    @Column(name = "phone_number")
    private String phoneNumber;
}
