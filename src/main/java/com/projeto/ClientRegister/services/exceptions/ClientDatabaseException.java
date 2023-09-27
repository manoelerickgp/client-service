package com.projeto.ClientRegister.services.exceptions;

public class ClientDatabaseException extends RuntimeException {

    private String message;

    public ClientDatabaseException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
