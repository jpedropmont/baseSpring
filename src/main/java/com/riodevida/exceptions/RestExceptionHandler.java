package com.riodevida.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionResponse> objectNotFoundHandler(NotFoundException exception) {
        var status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(new ExceptionResponse(status, exception.getMessage()));
    }
}
