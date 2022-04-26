package com.doubletex.app.handlers;

import com.doubletex.app.exceptions.DoubletexBadRequest;
import com.doubletex.app.exceptions.DoubletexNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Alexandru Enache
 * @date 26.04.2022
 */

@RestControllerAdvice
public class DoubletexControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DoubletexBadRequest handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        DoubletexBadRequest doubletexBadRequest = new DoubletexBadRequest();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            doubletexBadRequest.addValidation(fieldName, errorMessage);
        });
        return doubletexBadRequest;
    }

    @ExceptionHandler(DoubletexBadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DoubletexBadRequest handleCustomException(DoubletexBadRequest e) {
        return e;
    }

    @ExceptionHandler(DoubletexNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public DoubletexNotFound handleCustomException(DoubletexNotFound e) {
        return e;
    }
}
