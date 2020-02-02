package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductNameValidationRuleTest {

    @Test
    public void test1(){
        ProductNameValidationRule r = new ProductNameValidationRule();
        Product product = new Product();
        product.setName("ap");
        try {
            System.out.println("before");
            r.validate(product);

            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Name should be not less, than 3 letters and not more, than 100");
        }

    }
    @Test
    public void test2() {
        ProductNameValidationRule r = new ProductNameValidationRule();
        Product product = new Product();
        product.setName("");
        try {
            r.validate(product);
//            fail();
        } catch (Exception e) {
            assertNull(e.getMessage(), "Product name must be not null");
        }
    }

}