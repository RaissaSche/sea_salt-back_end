package br.com.cwi.crescer.tcc.mappers.usuario;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.requests.usuario.RequestEditarUsuario;
import br.com.cwi.crescer.tcc.securities.UserPrincipal;
import br.com.cwi.crescer.tcc.services.usuario.ServiceBuscarUsuarioPorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperRequestEditarUsuario {

    @Autowired
    ServiceBuscarUsuarioPorEmail serviceBuscarUsuarioPorEmail;

    public Usuario map(RequestEditarUsuario request, UserPrincipal user) {

        Usuario usuario = serviceBuscarUsuarioPorEmail.buscarPorEmail(user.getEmail());
        usuario.setNomeCompleto(request.getNomeCompleto());
        usuario.setApelido(request.getApelido());
        usuario.setImagemPerfil(request.getImagemPerfil());

        return usuario;
    }
}
