package br.com.padawan.finance.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {

    @ExceptionHandler(NotOwnerTransactionException.class)
    public ResponseEntity<Erro> customHandler(Exception ex) {

        return new ResponseEntity<>(
                new Erro(ex.getMessage()),
                HttpStatus.FORBIDDEN
        );
    }
}
