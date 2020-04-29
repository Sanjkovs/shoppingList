package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.repository.HibernateProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductUniqueNameValidationRuleTest {

    @Mock
    private HibernateProductRepository repository;

    @Spy
    @InjectMocks
    private ProductUniqueNameValidationRule victim;

    private ProductDTO productDTO = productDTO();

    @Test
    public void shouldThrowException(){
        when(repository.existsByName(productDTO.getName()))
                .thenReturn(true);

        assertThatThrownBy(()-> victim.validate(productDTO))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product name must be unique.");

        verify(victim).checkNotNull(productDTO);
    }

    private ProductDTO productDTO(){
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