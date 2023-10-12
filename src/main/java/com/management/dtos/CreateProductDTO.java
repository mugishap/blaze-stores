package com.management.dtos;

import com.management.enums.ECurrency;
import lombok.Data;

@Data
public class CreateProductDTO {

    private String name;
    private String description;
    private String price;
    private int quantity;
    private ECurrency currency;
    private String image;

}
