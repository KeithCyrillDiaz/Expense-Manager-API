package com.keithdiaz.training.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.keithdiaz.training.response.Response;
import com.keithdiaz.training.response.ResponseUtil;

@RestControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Response> expenseException(CustomException e){
        return ResponseUtil.createResponse(e.getStatus(), e.getMessage(), null);
    }
}
