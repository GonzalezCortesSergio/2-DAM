package com.salesianostriana.dam.demo.dto;

import com.salesianostriana.dam.demo.model.Product;

public record CreateProductDto(
        String name,
        double price
) {

    public Product toProduct () {

        return new Product(null, this.name, this.price);
    }
}
