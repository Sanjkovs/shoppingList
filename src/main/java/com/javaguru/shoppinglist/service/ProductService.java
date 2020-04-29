package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.repository.ProductRepositoryInterface;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductService {

    private final ProductRepositoryInterface repository;
    private final ProductValidationService validationService;
    private final ProductConverter productConverter;


    @Autowired
    public ProductService(ProductRepositoryInterface repository,
                          ProductValidationService validationService, ProductConverter productConverter) {
        this.repository = repository;
        this.validationService = validationService;
        this.productConverter = productConverter;
    }

    @Transactional
    public Long createProduct(ProductDTO productDTO) {
        validationService.validate(productDTO);
        Product product = productConverter.convert(productDTO);
        return repository.save(product);
    }

    public Product findProductById(Long id) {
        return repository.findProductById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found, id: " + id));


    }

    public void updateProduct(ProductDTO productDTO) {
        validationService.validate(productDTO);
        Product product = productConverter.convert(productDTO);
        repository.update(product);
    }

    public void deleteProduct(Long id) {
        repository.findProductById(id)
                .ifPresent(repository::delete);
    }

    public ProductDTO findProductByName(String name) {
        return repository.findProductByName(name)
                .map(productConverter::convert)
                .orElseThrow(() -> new NoSuchElementException("Product not found, name: " + name));
    }

    public List<ProductDTO> findAll() {
        return repository.findAll().stream()
                .map(productConverter::convert)
                .collect(Collectors.toList());
    }
}
