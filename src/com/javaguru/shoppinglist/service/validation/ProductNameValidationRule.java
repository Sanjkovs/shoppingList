package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductNameValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName() == null) {
            throw new ProductValidationException("Product name must be not null");
        }
        if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new ProductValidationException("Name should be not less, than 3 letters and not more, than 100");
        }
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Price should be more than 0");
        }
        if (product.getDiscount().intValue() > 100 || product.getDiscount().intValue() < 0) {
            throw new ProductValidationException("Discount should be not more than 100 and not less than 0");
        }
        if (product.getPrice().compareTo(BigDecimal.valueOf(20)) <= 0) {
            product.setDiscount(BigDecimal.valueOf(0));
            throw new ProductValidationException("If price < 20, then discount is 0");
        }
    }
}
