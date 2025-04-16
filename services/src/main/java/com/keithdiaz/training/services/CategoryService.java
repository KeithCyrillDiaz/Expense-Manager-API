package com.keithdiaz.training.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keithdiaz.training.CategoryModel;
import com.keithdiaz.training.repositories.CategoryRepository;

@Service
public class CategoryService {
    

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryModel> getAllCategory(){
        return categoryRepository.findAll();
    }

    public CategoryModel getCategoryById(String id){
        return categoryRepository.findById(id).orElse(null);
    }

    public CategoryModel getCategoryByTitle(String title){
        return categoryRepository.findByTitle(title);
    }

    public CategoryModel createCategory(CategoryModel category){
        CategoryModel existingCategory = getCategoryByTitle(category.getTitle());

        if(existingCategory == null) {
            return categoryRepository.save(category);
        }

        return null;
    }

    public void deleteCategoryById(String id){
        categoryRepository.deleteById(id);
    }
}
