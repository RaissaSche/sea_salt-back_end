package br.com.cwi.crescer.tcc.services.usuario;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.securities.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarUsuarioLogado {

    @Autowired
    ServiceBuscarUsuarioPorId serviceBuscarUsuarioPorId;

    public Usuario buscarUsuarioLogado(UserPrincipal user) {

        return serviceBuscarUsuarioPorId.buscarPorId(user.getId());
    }
}
