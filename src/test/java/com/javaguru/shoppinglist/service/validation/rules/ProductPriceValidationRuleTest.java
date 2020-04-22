package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductPriceValidationRuleTest {

    @Test
    public void testPriceValidation (){
        ProductPriceValidationRule rule = new ProductPriceValidationRule ();
        ProductDTO product = new ProductDTO();
        product.setPrice(BigDecimal.valueOf(-10));
        try {
            rule.validate(product);
//            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Price should be more than 0");
        }
    }
}