package br.com.cwi.crescer.tcc.services.usuario;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.repositories.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEditarUsuario {

    @Autowired
    RepositorioUsuario repositorio;

    public Usuario editar(Usuario usuarioEditado) {

        Usuario usuarioRetorno = repositorio.save(usuarioEditado);

        return usuarioRetorno;
    }

}
