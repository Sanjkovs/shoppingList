package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new ProductValidationException("Price should be less than 0");
        }
//        if (product.getDiscount().intValue() > 100 || product.getDiscount().intValue() < 0) {
//            throw new ProductValidationException("Discount should be not more than 100 and not less than 0");
//        }
//        if (product.getPrice().compareTo(BigDecimal.valueOf(20)) <= 0) {
//            product.setDiscount(BigDecimal.valueOf(0));
//            throw new ProductValidationException("If price < 20, then discount is 0");
//        }
    }
}