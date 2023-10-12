package com.management.entities;

import com.management.enums.ERole;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String names;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Set<ERole> roles;

    @Column(unique = true)
    private String telephone;

    private String password;

}
