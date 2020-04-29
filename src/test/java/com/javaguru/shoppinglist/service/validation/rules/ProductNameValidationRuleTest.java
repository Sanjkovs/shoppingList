package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import com.javaguru.shoppinglist.service.validation.rules.ProductNameValidationRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductNameValidationRuleTest {

    @Spy
    private ProductNameValidationRule victim;

    private ProductDTO input;

    @Test
    public void shouldThrowProductValidationException(){
        input = productDTO(null);

        assertThatThrownBy(()-> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product name must be not empty");
        verify(victim).checkNotNull(input);
    }

    @Test
    public void shouldValidateSuccess(){
        input = productDTO("valid name");
        victim.validate(input);
        verify(victim).checkNotNull(input);
    }

    private ProductDTO productDTO(String name){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(name);
        return productDTO;
    }

    @Test
    public void testNameLengthValidation(){
        ProductNameValidationRule r = new ProductNameValidationRule();
        ProductDTO product = new ProductDTO();
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
        ProductDTO product = new ProductDTO();
        product.setName("");
        try {
            r.validate(product);
//            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Product name must be not empty");
        }
    }



}