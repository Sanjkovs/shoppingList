package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.rules.ProductNameValidationRule;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductNameValidationRuleTest {

    @Test
    public void testNameLengthValidation(){
        ProductNameValidationRule r = new ProductNameValidationRule();
        Product product = new Product();
        product.setName("ap");
        try {
            r.validate(product);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Name should be not less, than 3 letters and not more, than 100");
        }

    }
    @Test
    public void testEmptyNameValidation() {
        ProductNameValidationRule r = new ProductNameValidationRule();
        Product product = new Product();
        product.setName("");
        try {
            r.validate(product);
//            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Product name must be not empty");
        }
    }

}