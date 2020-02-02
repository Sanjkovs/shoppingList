package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductInShopRepository {

    private Map<Long, Product> productRepository = new HashMap<Long, Product>();
    private Long productIdSequence = 0L;

    public Product insert (Product product){
        product.setId(productIdSequence);
        productRepository.put(productIdSequence,product);
        productIdSequence++;
        return product;
    }

    public Product findProductById (long id){
        return productRepository.get(id);
    }
}
