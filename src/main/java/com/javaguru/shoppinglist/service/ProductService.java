package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInShopRepository;
import com.javaguru.shoppinglist.repository.ProductInShopRepositoryInterface;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.LongToDoubleFunction;

@Component
public class ProductService {

    private ProductInShopRepositoryInterface repository;
    private ProductValidationService validationService;


    @Autowired
    public ProductService(ProductInShopRepository repository, ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.insert(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return repository.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found, id: " + id));


    }
}
