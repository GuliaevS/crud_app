package ru.guliaev.crud_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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

    /**
     * Роль
     */
    @ToString.Exclude
    @OneToMany(mappedBy = "clients")
    private List<Role> role;
}
