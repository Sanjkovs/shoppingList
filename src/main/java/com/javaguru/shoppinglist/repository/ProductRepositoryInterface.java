package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.Optional;

public interface ProductRepositoryInterface {

    Long save(Product product);

    void delete(Product product);

    Optional<Product> findProductById(Long id);

    boolean existsByName(String name);

    Optional<Product> findProductByName(String name);
}
