package br.com.wmn.greenzonemonitor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflitException extends RuntimeException {

    public ConflitException(String mensagem) {
        super(mensagem);
    }
}
