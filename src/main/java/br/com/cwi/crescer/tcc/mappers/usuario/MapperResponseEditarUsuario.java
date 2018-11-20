package br.com.cwi.crescer.tcc.mappers.usuario;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.responses.usuario.ResponseEditarUsuario;
import org.springframework.stereotype.Component;

@Component
public class MapperResponseEditarUsuario {

    public ResponseEditarUsuario map(Usuario usuario) {
        ResponseEditarUsuario response = new ResponseEditarUsuario(
                usuario.getNomeCompleto(),
                usuario.getApelido(),
                usuario.getImagemPerfil());

        return response;
    }
}
