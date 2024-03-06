package com.riodevida.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Object not found!");
    }
    public NotFoundException(String message) {
        super(message);
    }

}
