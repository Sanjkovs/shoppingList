package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.repository.ProductRepositoryInterface;
import com.javaguru.shoppinglist.service.validation.rules.ProductPriceValidationRule;
import org.junit.Before;
import org.mockito.Mockito;

public class ProductValidationServiceTestOLD {

    private ProductRepositoryInterface repository;

    private ProductValidationService service;

    private ProductPriceValidationRule validationRule;

    @Before
    public void setup() {
        repository = Mockito.mock(ProductRepositoryInterface.class);
//        service = new ProductValidationService(repository, validationRule);
    }

//    @Test
//    public void shouldReturnErrorWhenProductAlreadyExist() {
//        Product testPoduct = new Product();
//
//        Product foundProduct = new Product();
//        Mockito.when(repository.findProductById((long) 2)).thenReturn( foundProduct);
//
//        try {
//            service.validate(testPoduct);
//            fail();
//        } catch (ProductValidationException e) {
//
//            assertEquals(e.getMessage(), "  ====  ERROR === \n" +
//                    "In database with ID: 2 is a product with name: milk ! be careful !");
//        }

//        Mockito.verify(repository).delete(foundProduct);

//    }
}