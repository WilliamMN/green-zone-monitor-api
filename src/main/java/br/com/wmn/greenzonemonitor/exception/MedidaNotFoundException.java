package br.com.wmn.greenzonemonitor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MedidaNotFoundException extends RuntimeException {
    public MedidaNotFoundException(String message) {
        super(message);
    }
}
