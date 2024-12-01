package com.angelldca.sga.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;



@Data
public class SigaAppExceptions extends RuntimeException{

    private String msg;
    private HttpStatus httpStatus;
    public SigaAppExceptions(String msg, HttpStatus httpStatus){
        super(msg);
        this.msg = msg;
        this.httpStatus = httpStatus;
    }
}
