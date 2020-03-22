package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInShopRepository;
import com.javaguru.shoppinglist.repository.ProductInShopRepositoryInterface;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import com.javaguru.shoppinglist.service.validation.ProductValidationRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule {

    private final ProductInShopRepositoryInterface repository;

    @Autowired
    public ProductDiscountValidationRule(ProductInShopRepositoryInterface repository){
        this.repository = repository;
    }

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getDiscount().intValue() > 100 || product.getDiscount().intValue() < 0) {
            throw new ProductValidationException("Discount should be not more than 100 and not less than 0");
        }
        if (product.getPrice().intValue() < 20) {
            product.setDiscount(BigDecimal.ZERO);
            throw new ProductValidationException("If price < 20, then discount is 0");
        }
    }
}
