package com.greenacademy.viewmodel;


import com.greenacademy.models.Category;
import com.greenacademy.models.Product;

public class ProductViewModel {
    // Fields
    private Product product;
    private Category category;
    
    public ProductViewModel(Product product, Category category) {
        this.product = product;
        this.category = category;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}
