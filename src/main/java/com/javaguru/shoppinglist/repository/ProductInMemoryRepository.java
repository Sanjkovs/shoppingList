package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Profile("inmemory")
public class ProductInMemoryRepository implements ProductRepositoryInterface {

    private Map<Long, Product> productRepository = new HashMap<Long, Product>();
    private Long productIdSequence = 0L;

    public Product insert (Product product){
        product.setId(productIdSequence);
        productRepository.put(productIdSequence,product);
        productIdSequence++;
        return product;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return Optional.empty();
    }

    public Product findProductById (long id){
        return productRepository.get(id);
    }
}
