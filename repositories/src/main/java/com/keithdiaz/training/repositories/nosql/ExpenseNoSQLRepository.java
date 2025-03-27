package com.keithdiaz.training.repositories.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.keithdiaz.training.nosql.ExpenseNoSql;

@Repository
public interface ExpenseNoSQLRepository extends MongoRepository<ExpenseNoSql, String>{
    
}
