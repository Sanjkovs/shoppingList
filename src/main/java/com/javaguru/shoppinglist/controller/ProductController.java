package com.javaguru.shoppinglist.controller;


import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setDiscount(productDTO.getDiscount());
        product.setDescription(productDTO.getDescription());
        productService.createProduct(product);
        return ResponseEntity.ok(product);
    }

//    http://localhost:8080/products/id=1000...

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable("id") Long id){
        Product product = productService.findProductById(id);
        return new ProductDTO(product);
    }

}
