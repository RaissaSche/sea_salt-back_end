package br.com.cwi.crescer.tcc.mappers.postagem;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.services.usuario.ServiceBuscarUsuarioPorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperRequestBuscarPostagensUsuario {

    @Autowired
    ServiceBuscarUsuarioPorId serviceBuscarUsuarioPorId;

    public Usuario map(Long id) {

        Usuario usuario = serviceBuscarUsuarioPorId.buscarPorId(id);

        return usuario;
    }
}
