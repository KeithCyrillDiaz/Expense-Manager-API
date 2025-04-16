package com.keithdiaz.training.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static Response generateResponse(HttpStatus code, String message, Object data){
        Response response = new Response();
        response.setCode(code.value());
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public static ResponseEntity<Response> createResponse(HttpStatus code, String message, Object data){
        Response response = generateResponse(code, message, data);
        return ResponseEntity.status(code).body(response);
    }
    
}
