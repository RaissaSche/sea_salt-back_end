package br.com.cwi.crescer.tcc.mappers.postagem;

import br.com.cwi.crescer.tcc.domains.Postagem;
import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.requests.postagem.RequestSalvarPostagem;
import br.com.cwi.crescer.tcc.services.usuario.ServiceBuscarUsuarioPorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperRequestSalvarPostagem {

    @Autowired
    ServiceBuscarUsuarioPorId serviceBuscarUsuarioPorId;

    public Postagem map(RequestSalvarPostagem request) {

        Usuario usuarioLogado = serviceBuscarUsuarioPorId.buscarPorId(request.getIdUsuario());

        Postagem postagem = new Postagem();
        postagem.setUsuario(usuarioLogado);
        postagem.setTitulo(request.getTitulo());
        postagem.setTexto(request.getTexto());
        postagem.setImagem(request.getImagem());
        postagem.setIsPublic(request.getIsPublic());

        return postagem;
    }
}
