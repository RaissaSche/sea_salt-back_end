package br.com.cwi.crescer.tcc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class ExceptionEmailIndisponivel extends RuntimeException {

    public ExceptionEmailIndisponivel() {

        super("Email já cadastrado, faça login ou cadastre outro!");
    }
}
