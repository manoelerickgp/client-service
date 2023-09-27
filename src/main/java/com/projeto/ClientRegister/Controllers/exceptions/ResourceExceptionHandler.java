package com.projeto.ClientRegister.Controllers.exceptions;

import com.projeto.ClientRegister.services.exceptions.ClientDatabaseException;
import com.projeto.ClientRegister.services.exceptions.ClientNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ClientNotFound.class)
    public ResponseEntity<StandardError> entityNotFound(ClientNotFound e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Client not found";

        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ClientDatabaseException.class)
    public ResponseEntity<StandardError> databaseIntegrity(ClientDatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String error = "Database exception";

        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
