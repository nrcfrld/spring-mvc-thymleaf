package com.greenacademy.services;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.greenacademy.models.Category;
import com.greenacademy.models.Product;
import com.greenacademy.viewmodel.ProductViewModel;

@Service
@SessionScope
public class ProductServices {
    private ArrayList<ProductViewModel> products = new ArrayList<>();
    private HttpSession session;

    @Autowired
    private CategoryServices categoryServices;
    

    public ProductServices(HttpSession session) {
        this.session = session;

        this.products = (ArrayList<ProductViewModel>) session.getAttribute("products");
        if(this.products == null){
            this.products = new ArrayList<>();
        }
    }

    public ArrayList<ProductViewModel> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        // Validate categoryId
        Category category = categoryServices.getCategoryById(product.getCategoryId());
        if(category == null){
            throw new IllegalArgumentException("Invalid category ID");
        }

        // Create a new ProductViewModel
        ProductViewModel productViewModel = new ProductViewModel(product, category);

        this.products.add(productViewModel);
        session.setAttribute("products", this.products);
    }

    public ProductViewModel getProductById(String id) {
        for (ProductViewModel pvm : products) {
            if (pvm.getProduct().getId().equals(id)) {
                return pvm;
            }
        }
        return null;
    }

    public void updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProduct().getId().equals(product.getId())) {
                ProductViewModel pvm = new ProductViewModel(product, products.get(i).getCategory());

                products.set(i, pvm);
                break;
            }
        }
        session.setAttribute("products", this.products);
    }

    public void deleteProduct(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProduct().getId().equals(id)) {
                products.remove(i);
                break;
            }
        }
        session.setAttribute("products", this.products);
    }

}
