package com.management.entities;


import com.management.enums.ECurrency;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String description;
    private String price;
    private int quantity;
    private ECurrency currency=ECurrency.RWF;
    private String image;

}
