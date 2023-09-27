package com.projeto.ClientRegister.services.exceptions;

public class ClientNotFound extends RuntimeException {

    private String message;

    public ClientNotFound(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
}
