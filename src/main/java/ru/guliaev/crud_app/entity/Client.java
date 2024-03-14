package ru.guliaev.crud_app.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
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
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private Role role;

}
