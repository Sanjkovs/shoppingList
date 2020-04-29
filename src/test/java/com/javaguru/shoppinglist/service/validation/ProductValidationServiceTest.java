package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.validation.rules.ProductNameValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.ProductUniqueNameValidationRule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductValidationServiceTest {

    @Mock
    private ProductUniqueNameValidationRule uniqueNameValidationRule;

    @Mock
    private ProductNameValidationRule nameValidationRule;

    @Captor
    private ArgumentCaptor<ProductDTO> captor;

    private ProductValidationService victim;

    private ProductDTO productDTO = productDTO();

    @Before
    public void setUp() {
        Set<ProductValidationRule> rules = new HashSet<>();
        rules.add(uniqueNameValidationRule);
        rules.add(nameValidationRule);

        victim = new ProductValidationService(rules);
    }

    @Test
    public void shouldValidate(){
        victim.validate(productDTO);

        verify(uniqueNameValidationRule).validate(captor.capture());
        verify(nameValidationRule).validate(captor.capture());

        List<ProductDTO> resultList = captor.getAllValues();
        assertThat(resultList).containsOnly(productDTO);
    }

    private ProductDTO productDTO(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(123L);
        productDTO.setName("TEST_NAME");
        productDTO.setPrice(BigDecimal.valueOf(111L));
        productDTO.setCategory("TEST");
        productDTO.setDiscount(BigDecimal.valueOf(0L));
        productDTO.setDescription("TEST");
        return productDTO;
    }
}