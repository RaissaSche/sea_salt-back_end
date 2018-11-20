package br.com.cwi.crescer.tcc.requests.postagem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestSalvarPostagem {

    @Valid
    private Long idUsuario;
    @Valid
    private String titulo;
    @Valid
    private String texto;
    @Valid
    private String imagem;
    @Valid
    private String isPublic;
}
