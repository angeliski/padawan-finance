package br.com.padawan.finance.exceptions;

public class Erro {
    private final String message;

    public Erro(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
