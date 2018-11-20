package br.com.cwi.crescer.tcc.responses.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ResponseSalvarUsuario {

    private String nomeCompleto;
    private String email;
    private String apelido;
    private String senha;
    private LocalDate dataDeNascimento;
    private String imagemPerfil;
}
