package com.example.Mark.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BookNotFound.class})
    private ResponseEntity<Object> bookNotFoundException(BookNotFound ex){
        ErrorLog errorLog = new ErrorLog(HttpStatus.NOT_FOUND,LocalDate.now(),ex.getMessage());
        return new ResponseEntity<Object>(errorLog,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({RuntimeException.class})
    private ResponseEntity<Object> handleRunTimeException(RuntimeException ex) {
        ErrorLog errorLog = new ErrorLog(HttpStatus.INTERNAL_SERVER_ERROR, LocalDate.now(), ex.getMessage());
        return new ResponseEntity<Object>(errorLog, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
}
