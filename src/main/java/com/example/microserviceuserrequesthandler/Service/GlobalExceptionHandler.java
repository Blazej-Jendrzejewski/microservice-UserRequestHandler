package com.example.microserviceuserrequesthandler.Service;

import com.example.microserviceuserrequesthandler.Model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleResponseStatusException(ResponseStatusException e) {
        ErrorResponse error = new ErrorResponse(e.getStatusCode().value(), e.getReason());
        return new ResponseEntity<>(error, e.getStatusCode());
    }
}

