package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;

public interface ProductValidationRule {

    void validate (ProductDTO product);

    default void checkNotNull (ProductDTO product) {
        if (product == null){
            throw new ProductValidationException("Product must be not null");
        }
    }

}
