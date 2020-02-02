package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInShopRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class ProductService {

    private ProductInShopRepository repository = new ProductInShopRepository();
    private ProductValidationService validationService = new ProductValidationService();

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.insert(product);
        return createdProduct.getId();
    }

    public Product findProduct (Long id){
        return repository.findProductById(id);

    }
}
