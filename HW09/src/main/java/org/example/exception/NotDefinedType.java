package org.example.exception;

public class NotDefinedType extends RuntimeException{
    public NotDefinedType(String message) {
        super(message);
    }
}
