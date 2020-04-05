package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import com.javaguru.shoppinglist.service.validation.ProductValidationRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUniqueNameValidationRule implements ProductValidationRule {

    private final ProductRepository repository;

    @Autowired
    public ProductUniqueNameValidationRule(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if(repository.existsByName(product.getName())){
            throw new ProductValidationException("Task name must be unique.");
        }
    }
}
