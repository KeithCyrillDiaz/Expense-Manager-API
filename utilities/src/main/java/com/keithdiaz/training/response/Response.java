package com.keithdiaz.training.response;

import lombok.Data;

@Data
public class Response {
    
    private String message;
    private int code;
    private Object data;
}
