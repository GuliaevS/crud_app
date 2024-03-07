package ru.guliaev.crud_app.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "role")
public class Role {

    /**
     * Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Название роли
     */
    @Column(name = "name_of_role")
    private String nameOfRole;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Client> clients = new ArrayList<>();
}
