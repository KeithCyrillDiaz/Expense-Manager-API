package com.keithdiaz.training.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.keithdiaz.training.ExpenseModel;
import com.keithdiaz.training.exceptions.CustomException;
import com.keithdiaz.training.repositories.ExpenseRepository;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }
    
    public List<ExpenseModel> getAllExpense () {
        List<ExpenseModel> expenses = expenseRepository.findAll();
        if(expenses.isEmpty()) {
            throw new CustomException("No Expense Records Found", HttpStatus.NOT_FOUND);
        }
        return expenses;
    }

    public ExpenseModel getById(String id){
        ExpenseModel existingExpense = expenseRepository.findById(id).orElse(null);
        if(existingExpense == null) {
            throw new CustomException("Expense Record Not Found", HttpStatus.NOT_FOUND);
        }
        return existingExpense;
    }

    public ExpenseModel createExpense( ExpenseModel newExpense){
       return expenseRepository.save(newExpense);
    }

    public ExpenseModel updateExpense(ExpenseModel newExpense){
        ExpenseModel existingModel = expenseRepository.findById(newExpense.getId()).orElse(null);
        if(existingModel == null) {
            throw new CustomException("Expense Record Not Found", HttpStatus.NOT_FOUND);
        }
        return  expenseRepository.save(newExpense);
    }

    public ExpenseModel deleteExpense(String id){
        ExpenseModel data = getById(id);
        expenseRepository.deleteById(id);
       return data;
    }

    public List<ExpenseModel> DeleteExpenses(List<ExpenseModel> expenses){
        expenseRepository.deleteAll(expenses);
        return expenses;
    }

}
