package com.keithdiaz.training.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.keithdiaz.training.CategoryModel;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryModel, String> {
    
    CategoryModel findByTitle(String title);
}
