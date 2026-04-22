package com.library.LibraryMS.controller;

import com.library.LibraryMS.entity.Category;
import com.library.LibraryMS.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String findAllCategories(Model model){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        return "categories";
    }

    @GetMapping("/remove-category/{id}")
    public String deleteCategory(@PathVariable Long id, Model model){
        categoryService.deleteCategory(id);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "categories";

    }

    @GetMapping("update-category/{id}")
    public String updateCategory( @PathVariable Long id,Model model){
        model.addAttribute("category",categoryService.getCategoryById(id));
        return "update-category";

    }

    @PostMapping("/update-category/{id}")
    public String saveCategory(@PathVariable Long id,Category category, BindingResult result,Model model){
        if (result.hasErrors()){
            return "update-category";
        }
        Category existingCategory=categoryService.getCategoryById(id);
        existingCategory.setName(category.getName());
        categoryService.updateCategory(existingCategory);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "redirect:/categories";
    }

    @GetMapping("/add-category")
    public String addCategory(Category category,Model model){
        return "add-category";
    }


    @PostMapping("/save-category")
    public String saveCategory(Category category,BindingResult result,Model model){
        if (result.hasErrors()){
            return "add-category";
        }
        categoryService.createCategory(category);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "redirect:/categories";
    }
}
