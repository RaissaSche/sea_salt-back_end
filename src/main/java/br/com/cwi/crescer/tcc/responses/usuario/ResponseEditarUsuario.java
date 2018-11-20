package br.com.cwi.crescer.tcc.responses.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseEditarUsuario {

    private String nomeCompleto;
    private String apelido;
    private String imagemPerfil;
}
