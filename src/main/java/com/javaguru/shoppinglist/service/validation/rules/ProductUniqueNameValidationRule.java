package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.repository.ProductRepositoryInterface;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import com.javaguru.shoppinglist.service.validation.ProductValidationRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUniqueNameValidationRule implements ProductValidationRule {

    private final ProductRepositoryInterface repository;

    @Autowired
    public ProductUniqueNameValidationRule(ProductRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void validate(ProductDTO product) {
        checkNotNull(product);
        if(repository.existsByName(product.getName())){
            throw new ProductValidationException("Product name must be unique.");
        }
    }
}
