package com.example.demo.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestControllerAdvice {
    @ExceptionHandler(MyException.class)
    public String handleNotFoundException(MyException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String handleNotFoundException(Exception exception) {
        return exception.getMessage();
    }
}
