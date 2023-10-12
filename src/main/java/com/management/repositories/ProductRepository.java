package com.management.repositories;

import com.management.entities.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.UUID;

@Transactional
@ApplicationScoped
public class ProductRepository implements PanacheRepositoryBase<Product, UUID> {
}