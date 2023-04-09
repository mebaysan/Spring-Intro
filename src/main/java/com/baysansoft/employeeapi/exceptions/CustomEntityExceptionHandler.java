package com.baysansoft.employeeapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomEntityExceptionResponse> handleException(Exception exception) {
        CustomEntityExceptionResponse response = new CustomEntityExceptionResponse();

        response.setMessage(exception.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, null, response.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CustomEntityExceptionResponse> handleEmployeeNotFoundException(
            EmployeeNotFoundError exception) {
        CustomEntityExceptionResponse response = new CustomEntityExceptionResponse();

        response.setMessage(exception.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, null, response.getStatus());
    }

}
