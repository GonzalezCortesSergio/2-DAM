package com.salesianostriana.dam.demo.dto;

import com.salesianostriana.dam.demo.model.Product;

import java.util.List;

public record GetProductListDto(
        Long count,
        List<Product> items
) {

    public static GetProductListDto of (List<Product> productList) {

        return new GetProductListDto(
                (long) productList.size(),
                productList
        );
    }

    public List<Product> to() {

        return items;
    }
}
