package com.greenacademy.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greenacademy.models.Product;
import com.greenacademy.services.CategoryServices;
import com.greenacademy.services.ProductServices;

@Controller
public class ProductController {
    private ProductServices productServices;
    private CategoryServices categoryServices;

    public ProductController(ProductServices productServices, CategoryServices categoryServices) {
        this.productServices = productServices;
        this.categoryServices = categoryServices;
    }

    @GetMapping("/products")
    public String index(HttpSession session, Model model) {
        model.addAttribute("products", productServices.getProducts());
        return "product/index";
    }

    @GetMapping("/products/create")
    public String create(HttpSession session, Model model) {
        model.addAttribute("categories", categoryServices.getCategories());
        return "product/create";
    }

    @PostMapping("/products/create")
    public String store(
        @Valid @ModelAttribute("product") Product product,
        BindingResult result,
        Model model,
        HttpSession session,
        RedirectAttributes redirectAttributes
    ){
        if(result.hasErrors()){
            // Set message to model
            model.addAttribute("categories", categoryServices.getCategories());
            model.addAttribute("errors", result);
            return "product/create";
        }   

        // Simpan produk ke dalam session
        productServices.addProduct(product);

        // Set flash message
        redirectAttributes.addFlashAttribute("message", "Product created successfully!");

        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String edit() {
        return "product/edit";
    }

    @PostMapping("/products/edit/{id}")
    public String update() {
        return "redirect:/products";
    }
}
