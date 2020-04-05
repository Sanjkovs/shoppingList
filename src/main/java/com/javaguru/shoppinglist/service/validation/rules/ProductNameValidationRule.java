package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import com.javaguru.shoppinglist.service.validation.ProductValidationRule;

public class ProductNameValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
//        ProductRepository repository = new ProductRepository();
        checkNotNull(product);
        if (product.getName() == null || product.getName().trim().length() == 0 ) {
            throw new ProductValidationException("Product name must be not empty");
        }
        if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new ProductValidationException("Name should be not less, than 3 letters and not more, than 100");
        }
//        if (product.getName() ==  )
//        if (repository.equals())
    }
}
