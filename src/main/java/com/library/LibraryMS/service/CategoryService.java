package com.library.LibraryMS.service;

import com.library.LibraryMS.entity.Category;
import com.library.LibraryMS.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAllCategories(){
        return categoryRepository.findAll(Sort.by("id").ascending());
    }

    public Category getCategoryById(Long id){
        Category category =categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category with this Id cannot be found!"));
        return category;
    }

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        Category category=categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category with this Id cannot be found!"));

        categoryRepository.deleteById(category.getId());

    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }
}
