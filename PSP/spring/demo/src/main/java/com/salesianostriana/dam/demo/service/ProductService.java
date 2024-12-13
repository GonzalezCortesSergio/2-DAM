package com.salesianostriana.dam.demo.service;

import com.salesianostriana.dam.demo.error.ProductNotFountException;
import com.salesianostriana.dam.demo.model.Product;
import com.salesianostriana.dam.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> query (double maxPrice, String sortDirection) {

        List<Product> result = productRepository.query(maxPrice, sortDirection);
        if(result.isEmpty())
            throw new ProductNotFountException();

        return result;
    }

    public Product get(Long id) {

        return productRepository.get(id)
                .orElseThrow(() -> new ProductNotFountException(id));
    }

    public Product add(Product product) {

        return productRepository.add(product);
    }

    public Product edit(Long id, Product product) {

        return productRepository.edit(id, product).orElseThrow(() -> new ProductNotFountException(id));
    }


    public void delete(Long id) {

        productRepository.delete(id);
    }
}
