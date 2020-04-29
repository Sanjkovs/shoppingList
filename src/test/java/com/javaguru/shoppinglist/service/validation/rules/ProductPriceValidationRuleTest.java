package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductPriceValidationRuleTest {

    @Spy
    private ProductPriceValidationRule victim;

    private ProductDTO input = new ProductDTO();

    @Test
    public void shouldThrowProductValidationException() {
        input.setPrice(BigDecimal.valueOf(-10));

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Price should be more than 0");
    }

    @Test
    public void shouldValidateSuccess(){
        input.setPrice(BigDecimal.valueOf(10));
        victim.validate(input);
        verify(victim).validate(input);
    }



    @Test
    public void testPriceValidation() {
        ProductPriceValidationRule rule = new ProductPriceValidationRule();
        ProductDTO product = new ProductDTO();
        product.setPrice(BigDecimal.valueOf(-10));
        try {
            rule.validate(product);
//            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Price should be more than 0");
        }
    }

    private ProductDTO productDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(123L);
        productDTO.setName("TEST_NAME");
        productDTO.setPrice(BigDecimal.valueOf(111L));
        productDTO.setCategory("none");
        productDTO.setDiscount(BigDecimal.valueOf(0L));
        productDTO.setDescription("none");
        return productDTO;
    }

}