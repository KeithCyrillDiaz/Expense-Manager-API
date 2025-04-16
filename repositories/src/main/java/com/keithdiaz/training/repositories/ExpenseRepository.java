package com.keithdiaz.training.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.keithdiaz.training.ExpenseModel;


@Repository
public interface ExpenseRepository extends MongoRepository<ExpenseModel, String>{
    
    ExpenseModel findByTitle(String title);
}
