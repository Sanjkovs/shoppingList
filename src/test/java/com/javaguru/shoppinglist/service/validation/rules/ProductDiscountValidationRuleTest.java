package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class ProductDiscountValidationRuleTest {

    @Spy
    private ProductDiscountValidationRule victim;

    private ProductDTO input = new ProductDTO();

    @Test
    public void shouldThrowProductValidationException() {
        input.setDiscount(BigDecimal.valueOf(-10));

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Discount should be not more than 100 and not less than 0");

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