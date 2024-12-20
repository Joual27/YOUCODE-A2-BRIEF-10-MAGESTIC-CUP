package org.youcode.magestic_cup.shared.utils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.youcode.magestic_cup.exceptions.EntityNotFoundException;
import org.youcode.magestic_cup.exceptions.UsernameAlreadyExistsException;
import org.youcode.magestic_cup.shared.utils.DTOs.ErrorDTO;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleEntityNotFoundException(EntityNotFoundException e) {
        return new ErrorDTO(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleValidationsException(MethodArgumentNotValidException e) {
        Map<String, String> validationErrors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(
                err -> validationErrors.put(err.getField(), err.getDefaultMessage())
        );
        return new ErrorDTO(HttpStatus.BAD_REQUEST.value(), "Validations Error", validationErrors, LocalDateTime.now());
    }

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleUsernameAlreadyExistsException(Exception e) {
        return new ErrorDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleBindException(BindException e) {
        Map<String, String> validationErrors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error ->
                validationErrors.put(error.getField(), error.getDefaultMessage())
        );
        e.getBindingResult().getGlobalErrors().forEach(error ->
                validationErrors.put(error.getObjectName(), error.getDefaultMessage())
        );
        return new ErrorDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error",
                validationErrors,
                LocalDateTime.now()
        );
    }
}