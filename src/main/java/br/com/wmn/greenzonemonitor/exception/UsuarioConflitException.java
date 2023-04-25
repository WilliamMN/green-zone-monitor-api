package br.com.wmn.greenzonemonitor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsuarioConflitException extends RuntimeException {

    public UsuarioConflitException(String mensagem) {
        super(mensagem);
    }
}
