package br.com.cwi.crescer.tcc.services.usuario;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.exceptions.RegistroNaoEncontradoException;
import br.com.cwi.crescer.tcc.repositories.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarUsuarioPorId {

    @Autowired
    RepositorioUsuario repositorio;

    public Usuario buscarPorId(Long id) {

        Usuario usuario = repositorio.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException(Usuario.class.getSimpleName()));

        return usuario;
    }
}
