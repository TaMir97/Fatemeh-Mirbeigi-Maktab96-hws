package org.example.exception;

public class NotDefinedCategory extends RuntimeException{
    public NotDefinedCategory(String message) {
        super(message);
    }
}
