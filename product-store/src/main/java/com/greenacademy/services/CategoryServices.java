package com.greenacademy.services;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.greenacademy.models.Category;

@Service
@SessionScope
public class CategoryServices {
    private ArrayList<Category> categories = new ArrayList<>();
    private HttpSession session;
    
    public CategoryServices(HttpSession session) {
        this.session = session;
    
        this.categories = (ArrayList<Category>) session.getAttribute("categories");
        if(this.categories == null){
            this.categories = new ArrayList<>();
        }
    }
    
    public ArrayList<Category> getCategories() {
        return categories;
    }
    public void addCategory(Category category) {
        this.categories.add(category);
        session.setAttribute("categories", this.categories);
    }
    public Category getCategoryById(String id) {
        for (Category category : categories) {
            if (category.getId().equals(id)) {
                return category;
            }
        }
        return null;
    }

    public void updateCategory(Category category) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId().equals(category.getId())) {
                categories.set(i, category);
                break;
            }
        }
        session.setAttribute("categories", this.categories);
    }
    public void deleteCategory(String id) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId().equals(id)) {
                categories.remove(i);
                break;
            }
        }
        session.setAttribute("categories", this.categories);
    }
    public void clearCategories() {
        this.categories.clear();
        session.setAttribute("categories", this.categories);
    }
}
