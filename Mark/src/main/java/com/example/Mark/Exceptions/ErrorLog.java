package com.example.Mark.Exceptions;

import org.springframework.http.HttpStatus;
import java.time.LocalDate;

public class ErrorLog {

    private HttpStatus httpStatus;

    private LocalDate localDate;

    private String message;

    public ErrorLog(HttpStatus httpStatus,LocalDate localDate,String message) {
        this.httpStatus = httpStatus;
        this.localDate = localDate;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
