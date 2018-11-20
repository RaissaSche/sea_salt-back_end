package br.com.cwi.crescer.tcc.DTOs;

import br.com.cwi.crescer.tcc.domains.Postagem;
import br.com.cwi.crescer.tcc.domains.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DTOPagePostagemComUsuario {

    private Postagem postagem;
    private Usuario usuario;
}
