package com.management.entities;

import com.management.enums.ERole;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String names;
    private String email;
    private ERole role;
    private String telephone;
    private String password;

}
