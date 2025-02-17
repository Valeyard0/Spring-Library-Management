package com.example.Mark.Exceptions;

public class BookNotFound extends RuntimeException{
    public BookNotFound(String message) {
        super(message);
    }
}
