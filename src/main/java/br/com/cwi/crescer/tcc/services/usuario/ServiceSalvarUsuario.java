package br.com.cwi.crescer.tcc.services.usuario;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.repositories.RepositorioUsuario;
import br.com.cwi.crescer.tcc.validators.ValidatorEmailNaoRepetido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceSalvarUsuario {

    @Autowired
    RepositorioUsuario repositorio;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ValidatorEmailNaoRepetido validator;

    public Usuario salvar(Usuario novoUsuario) {

        novoUsuario.setSenha(passwordEncoder.encode(novoUsuario.getSenha()));
        validator.accept(novoUsuario);
        Usuario usuarioRetorno = repositorio.save(novoUsuario);

        return usuarioRetorno;
    }
}