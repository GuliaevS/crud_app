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
//    @ToString.Exclude
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "role_id")
//    private Role role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                '}';
    }
}
