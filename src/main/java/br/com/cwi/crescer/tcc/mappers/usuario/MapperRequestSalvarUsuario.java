package br.com.cwi.crescer.tcc.mappers.usuario;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.requests.usuario.RequestSalvarUsuario;

public class MapperRequestSalvarUsuario {

    public Usuario map(RequestSalvarUsuario request) {

        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(request.getNomeCompleto());
        usuario.setEmail(request.getEmail());
        usuario.setApelido(request.getApelido());
        usuario.setSenha(request.getSenha());
        usuario.setDataNascimento(request.getDataDeNascimento());
        usuario.setImagemPerfil(request.getImagemPerfil());

        return usuario;
    }
}
