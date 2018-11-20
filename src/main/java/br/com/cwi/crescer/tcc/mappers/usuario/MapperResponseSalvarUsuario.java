package br.com.cwi.crescer.tcc.mappers.usuario;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.responses.usuario.ResponseSalvarUsuario;

public class MapperResponseSalvarUsuario {

    public ResponseSalvarUsuario map(Usuario usuario) {
        ResponseSalvarUsuario response = new ResponseSalvarUsuario(
                usuario.getNomeCompleto(),
                usuario.getEmail(),
                usuario.getApelido(),
                usuario.getSenha(),
                usuario.getDataNascimento(),
                usuario.getImagemPerfil());

        return response;
    }
}
