package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class ProductValidationRuleTest extends TestCase {

    @Spy
    private ProductValidationRule victim;

    @Test
    public void shouldThrowValidationException(){
        assertThatThrownBy(() -> victim.checkNotNull(null))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product must be not null");
    }

    @Test
    public void shouldCheckNotNull(){
        ProductDTO productDTO = new ProductDTO();

        victim.checkNotNull(productDTO);
    }
}