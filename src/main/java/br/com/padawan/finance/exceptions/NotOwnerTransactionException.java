package br.com.padawan.finance.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotOwnerTransactionException extends RuntimeException {

    public NotOwnerTransactionException() {
        super("Essa transação não te pertence, portanto não pode ser manipulada.");
    }
}
