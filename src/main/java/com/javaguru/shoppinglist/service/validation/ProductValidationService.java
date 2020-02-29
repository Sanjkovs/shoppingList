package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInShopRepository;
import com.javaguru.shoppinglist.service.validation.rules.ProductDiscountValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.ProductNameValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.ProductPriceValidationRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProductValidationService {

    private ProductValidationRule validationRule;

    private final Set<ProductValidationRule> validationRules;

    private ProductInShopRepository repository;

    @Autowired
    public ProductValidationService (Set<ProductValidationRule> validationRules){
        this.validationRules = validationRules;

    }
    public void validate (Product product){
        validationRules.forEach(s -> s.validate(product));
    }

}
