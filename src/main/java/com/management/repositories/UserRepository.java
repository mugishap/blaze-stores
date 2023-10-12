package com.management.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.vertx.mutiny.ext.auth.User;

import java.util.UUID;

public class UserRepository implements PanacheRepositoryBase<User, UUID> {
}
