package com.greenacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greenacademy.models.Category;
import com.greenacademy.models.UserProfile;
import com.greenacademy.services.CategoryServices;

@Controller
public class HomeController {
    private CategoryServices categoryServices;
    public HomeController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping("/")
    public String index(Model mdl) {
        mdl.addAttribute("message", "Welcome to the Home Page!");

        Category category = new Category("Electronics", "Devices and gadgets");
        categoryServices.addCategory(category);
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    // @GetMapping("/hello")
    // @ResponseBody
    // public String hello(
    //     @RequestParam(required = false , defaultValue =b "") String name,
    //     @RequestParam(required = false , defaultValue = "0") int age,
    //     @RequestParam(required = false, defaultValue = "Pria") String gender
    // ){
    //     return "Hai " + name + " , your age is " + age + " and your gender is " + gender;
    // }

    @GetMapping("/hello")
    // @ResponseBody
    public String hello(@ModelAttribute("userProfile") UserProfile userProfile, Model model) {
        // model.addAttribute("userProfile", userProfile);
        return "hello";
    }
}
