package com.keithdiaz.training;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keithdiaz.training.response.Response;
import com.keithdiaz.training.response.ResponseUtil;
import com.keithdiaz.training.services.ExpenseService;

@RestController
@RequestMapping("expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<Response> fetchAllExpense(){
        List<ExpenseModel> data = expenseService.getAllExpense();
        return ResponseUtil.createResponse(HttpStatus.OK, "Successfully Fetched Expense Records", data);
    }

    @GetMapping("/getById")
    public ResponseEntity<Response> fetchById(@PathVariable String id){
        ExpenseModel data = expenseService.getById(id);
        return ResponseUtil.createResponse(HttpStatus.OK, "Successfully Fetched Expense Record", data);
    }

    @PostMapping("/create")
    public ResponseEntity<Response> createExpense(
        @RequestBody ExpenseModel newExpenseModel
    ) {
        ExpenseModel data = expenseService.createExpense(newExpenseModel);
        return ResponseUtil.createResponse(HttpStatus.CREATED, "Successfully Created Expense", data);
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateExpense(@RequestBody ExpenseModel newExpenseModel){
        ExpenseModel data = expenseService.updateExpense(newExpenseModel);
        return ResponseUtil.createResponse(HttpStatus.OK,  "Successfully Updated Expense Record", data);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Response> deleteExpense(@PathVariable("id") String id) {
       ExpenseModel data = expenseService.deleteExpense(id);
       return ResponseUtil.createResponse(HttpStatus.OK, "SuccessFully Deleted Expense Record", data);
    }

    @DeleteMapping("/deleteManyById")
    public ResponseEntity<Response> deleteExpenses(@RequestBody List<ExpenseModel> expenses){
        List <ExpenseModel> data = expenseService.DeleteExpenses(expenses);
        return ResponseUtil.createResponse(HttpStatus.OK, "Successfully Deleted Expesnes Record", data);
    }

}
