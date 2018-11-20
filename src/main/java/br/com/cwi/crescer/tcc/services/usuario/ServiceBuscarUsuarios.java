package br.com.cwi.crescer.tcc.services.usuario;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.repositories.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarUsuarios {

    @Autowired
    RepositorioUsuario repositorio;

    public Page<Usuario> buscarUsuarios(Pageable pageable) {

        return repositorio.findAll(pageable);
    }
}
