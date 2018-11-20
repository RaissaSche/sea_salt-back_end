package br.com.cwi.crescer.tcc.mappers.usuario;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.requests.usuario.RequestLogarUsuario;

public class MapperRequestLogarUsuario {

    public Usuario map(RequestLogarUsuario request) {

        Usuario usuario = new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());

        return usuario;
    }
}
