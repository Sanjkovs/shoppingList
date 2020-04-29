package com.javaguru.shoppinglist.dto;

import com.javaguru.shoppinglist.domain.Product;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

public class ProductDTO {

    @NotNull (groups = {Update.class}, message = "ID must not be null")
    @Null (groups = {Create.class},  message = "Please do not provide ID on create")
    private Long id;

    @NotEmpty(groups = {Update.class, Create.class}, message = "Name must not be blank")
    private String name;
    private BigDecimal price;
    private String category;
    private BigDecimal discount;
    private String description;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, BigDecimal price,
                      String category, BigDecimal discount, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.discount = discount;
        this.description = description;
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.discount = product.getDiscount();
        this.description = product.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public interface Update {}
    public interface Create {}
}
