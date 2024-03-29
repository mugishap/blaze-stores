package com.management.repositories;

import com.management.entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.UUID;

@Transactional
@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, UUID> {

    public User findByEmail(String email) {
        return find("email", email).firstResult();
    }

}
