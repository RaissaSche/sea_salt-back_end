package br.com.cwi.crescer.tcc.mappers.postagem;

import br.com.cwi.crescer.tcc.domains.Postagem;
import br.com.cwi.crescer.tcc.responses.postagem.ResponseSalvarPostagem;
import org.springframework.stereotype.Component;

@Component
public class MapperResponseSalvarPostagem {

    public ResponseSalvarPostagem map(Postagem postagem) {

        ResponseSalvarPostagem response = new ResponseSalvarPostagem(
                postagem.getTitulo(),
                postagem.getTexto(),
                postagem.getImagem());

        return response;
    }
}
