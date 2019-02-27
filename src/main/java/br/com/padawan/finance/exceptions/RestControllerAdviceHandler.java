package br.com.padawan.finance.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//Tutorial https://www.baeldung.com/exception-handling-for-rest-with-spring
@RestControllerAdvice
public class RestControllerAdviceHandler {

    @ExceptionHandler(NotOwnerTransactionException.class)
    public ResponseEntity<Erro> customHandler(Exception ex) {

        return new ResponseEntity<>(
                new Erro(ex.getMessage()),
                HttpStatus.FORBIDDEN
        );
    }
}
