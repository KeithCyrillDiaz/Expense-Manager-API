package com.keithdiaz.training.repositories.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keithdiaz.training.sql.ExpenseSql;

@Repository
public interface ExpenseSQLRepository extends JpaRepository<ExpenseSql, Long> {
    
}
