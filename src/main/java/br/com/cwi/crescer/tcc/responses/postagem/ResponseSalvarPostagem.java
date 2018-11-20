package br.com.cwi.crescer.tcc.responses.postagem;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseSalvarPostagem {

    private String titulo;
    private String texto;
    private String imagem;
}
