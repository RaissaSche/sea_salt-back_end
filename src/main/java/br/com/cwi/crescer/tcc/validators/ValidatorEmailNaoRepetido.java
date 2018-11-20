package br.com.cwi.crescer.tcc.validators;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.exceptions.ExceptionEmailIndisponivel;
import br.com.cwi.crescer.tcc.repositories.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ValidatorEmailNaoRepetido implements Consumer<Usuario> {

    @Autowired
    RepositorioUsuario repositorio;

    public void accept(final Usuario usuario) {

        if (repositorio.existsByEmail(usuario.getEmail())) {
            throw new ExceptionEmailIndisponivel();
        }
    }
}
