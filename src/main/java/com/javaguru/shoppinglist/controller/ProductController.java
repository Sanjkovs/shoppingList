package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> create(
            @Validated({ProductDTO.Create.class}) @RequestBody ProductDTO productDTO,
            UriComponentsBuilder builder) {

        Long id = productService.createProduct(productDTO);
        return ResponseEntity.created(builder
                .path("tasks/{id}")
                .buildAndExpand(id)
                .toUri())
                .build();
    }

//    http://localhost:8080/products/id=1000...

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable("id") Long id) {
        Product product = productService.findProductById(id);
        return new ProductDTO(product.getId(),product.getName(),product.getPrice(),product.getCategory(),product.getDiscount(),product.getDescription());
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable("id") Long id,
            @Validated ({ProductDTO.Update.class}) @RequestBody ProductDTO productDTO){
        productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @GetMapping(params = "name")
    public ProductDTO findProductByName(@RequestParam("name") String name) {
       return productService.findProductByName(name);
    }

    @GetMapping
    public List<ProductDTO> findAll(){
        return productService.findAll();
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNoSuchElementException(NoSuchElementException ex){
    }


}
