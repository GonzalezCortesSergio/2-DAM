package com.salesianostriana.dam.demo.controller;

import com.salesianostriana.dam.demo.dto.CreateProductDto;
import com.salesianostriana.dam.demo.dto.GetProductListDto;
import com.salesianostriana.dam.demo.error.ProductNotFountException;
import com.salesianostriana.dam.demo.model.Product;
import com.salesianostriana.dam.demo.repository.ProductRepository;
import com.salesianostriana.dam.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public GetProductListDto findAll(
            @RequestParam(required = false,
            value = "maxPrice", defaultValue = "-1") double max,
            @RequestParam(required = false,
            value = "sort", defaultValue = "no") String sortDirecion
    ) {

        /*
            List<Product> productList = productRepository.getAll();

            if(productList.isEmpty())
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok(productList);
        */


        return GetProductListDto.of(productService.query(max, sortDirecion));

    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {

        return productService.get(id);

    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody CreateProductDto product) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.add(product.toProduct()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@RequestBody Product product, @PathVariable Long id){

        return ResponseEntity.ok(productService.edit(id, product));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        productService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
