package com.greenacademy.models;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.greenacademy.services.CategoryServices;


public class Product {
    private String id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must be positive")
    private Integer price;

    @NotBlank(message = "Category is required")
    private String categoryId;
    // private String category;

    @NotNull(message = "Stock is required")
    @PositiveOrZero(message = "Stock must be positive")
    private Integer stock;


    public Product(String name, String description, Integer price) {
        this.name = name;
        this.description = description;
        this.price = price;

        this.id = UUID.randomUUID().toString();
    }

    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}