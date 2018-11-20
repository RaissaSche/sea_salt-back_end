package br.com.cwi.crescer.tcc.requests.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestEditarUsuario {

    @NotEmpty
    private String nomeCompleto;
    @NotEmpty
    private String apelido;
    @NotEmpty
    private String imagemPerfil;
}
