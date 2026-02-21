package com.project.fitnessMonolithic.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDuplicateEmail() {
        return ResponseEntity
                .badRequest()
                .body("Email already exists");
    }


    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleDuplicate(IllegalStateException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

